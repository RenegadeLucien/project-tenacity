package logic;

import data.databases.AbilityDatabase;
import data.dataobjects.Ability;
import data.dataobjects.Enemy;

import java.util.*;
import java.util.stream.Collectors;

public class Encounter implements java.io.Serializable {

    private List<List<Enemy>> enemyGroups;
    private List<Restriction> restrictions;

    public Encounter(List<List<String>> enemyGroups, List<Restriction> restrictions) {
        this.enemyGroups = new ArrayList<>();
        for (List<String> enemyGroup : enemyGroups) {
            this.enemyGroups.add(enemyGroup.stream().map(a -> Enemy.getEnemyByName(a)).collect(Collectors.toList()));
        }
        this.restrictions = restrictions;
    }

    public Encounter(List<List<String>> enemyGroups) {
        this.enemyGroups = new ArrayList<>();
        for (List<String> enemyGroup : enemyGroups) {
            this.enemyGroups.add(enemyGroup.stream().map(a -> Enemy.getEnemyByName(a)).collect(Collectors.toList()));
        }
        this.restrictions = new ArrayList<>();
    }

    public Encounter(String enemy, List<Restriction> restrictions) {
        this.enemyGroups = Collections.singletonList(Collections.singletonList(Enemy.getEnemyByName(enemy)));
        this.restrictions = restrictions;
    }

    public Encounter(String enemy) {
        this.enemyGroups = Collections.singletonList(Collections.singletonList(Enemy.getEnemyByName(enemy)));
        this.restrictions = new ArrayList<>();
    }

    public List<List<Enemy>> getEnemyGroups() {
        return enemyGroups;
    }

    public List<Restriction> getRestrictions() {
        return restrictions;
    }

    public CombatResults calculateCombat(Player p, int invenSpaces, String combatStyle) {
        CombatResults results = null;
        double minHpLost = 1000000001;
        for (Loadout loadout : p.generateLoadouts(combatStyle)) {
            double myLp = p.getLevel("Constitution") * 100 + loadout.totalLp();
            int ticks = 0;
            double hpLost = 0;
            for (List<Enemy> enemyGroup : enemyGroups) {
                for (Enemy enemy : enemyGroup) {
                    //System.out.println("Began fighting: " + enemy.getName());
                    int affinity;
                    String accuracySkill;
                    String damageSkill;
                    if (combatStyle.equals("Melee")) {
                        affinity = enemy.getAffmelee();
                        accuracySkill = "Attack";
                        damageSkill = "Strength";
                    } else if (combatStyle.equals("Ranged")) {
                        affinity = enemy.getAffranged();
                        accuracySkill = damageSkill = "Ranged";
                    } else {
                        affinity = enemy.getAffmage();
                        accuracySkill = damageSkill = "Magic";
                    }
                    double myAccuracy = (0.0008 * Math.pow(p.getLevel(accuracySkill), 3) + 4 * p.getLevel(accuracySkill) + 40) + loadout.getMainWep().getAccuracy();
                    double myHitChance = Math.min(1, (affinity * myAccuracy / (enemy.getArmor() + 2.5 * enemy.getDef())) / 100.0);
                    double myDamage;
                    if (loadout.getMainWep().getAtkspd() == 4) {
                        myDamage = 2.5 * p.getLevel(damageSkill) + loadout.getMainWep().getDamage() + Math.min(loadout.getMainWep().getMaxAmmo(), loadout.getAmmo().getDamage());
                    }
                    else if (loadout.getMainWep().getAtkspd() == 5) {
                        myDamage = 2.5 * p.getLevel(damageSkill) + (loadout.getMainWep().getDamage() + Math.min(loadout.getMainWep().getMaxAmmo(), loadout.getAmmo().getDamage()))*192.0/245.0;
                    }
                    else if (loadout.getMainWep().getAtkspd() == 6) {
                        myDamage = 2.5 * p.getLevel(damageSkill) + (loadout.getMainWep().getDamage() + Math.min(loadout.getMainWep().getMaxAmmo(), loadout.getAmmo().getDamage()))*96.0/149.0;
                    }
                    else {
                        System.out.println("What the heck kind of weapon do you have?");
                        throw new RuntimeException("Error: Weapon has invalid attack speed. Must be 4, 5, or 6");
                    }
                    double enemyMaxAcc = Math.max(enemy.getAccmage(), Math.max(enemy.getAccmelee(), enemy.getAccranged()));
                    double enemyMaxAccSkill = Math.max(enemy.getAttack(), Math.max(enemy.getRanged(), enemy.getMagic()));
                    double enemyHitChance = Math.min(1, (55 * (enemyMaxAcc + (0.0008 * Math.pow(enemyMaxAccSkill, 3) + 4 * enemyMaxAccSkill + 40)) / (2.5 * (p.getLevel("Defense")) + loadout.totalArmour())) / 100);
                    double enemyDamage = (Math.max(enemy.getMaxhitmagic(), Math.max(enemy.getMaxhitmelee(), enemy.getMaxhitranged())) + 1) / 2.0;
                    double enemyLp = enemy.getLp();
                    int adren = 0;
                    int invenUsed = 0;
                    int foodCooldown = 0;
                    Map<Ability, Integer> cooldowns = new HashMap<>();
                    for (Ability ability : AbilityDatabase.getAbilityDatabase().getAbilities()) {
                        if (ability.canUse(adren, loadout.getMainWep(), p))
                        cooldowns.put(ability, 0);
                    }
                    cooldowns.put(new Ability("Auto-attack", loadout.getMainWep().getWeaponClass(), "Any", "Auto", loadout.getMainWep().getAtkspd(),
                        (loadout.getMainWep().getDamage()+loadout.getAmmo().getDamage())*0.5/myDamage, new ArrayList<>()), 0);
                    while (myLp > 0 && enemyLp > 0) {
                        Ability abilityUsedThisTick = null;
                        double maxDamage = 0;
                        if (myLp < Math.max(enemy.getMaxhitmagic(), Math.max(enemy.getMaxhitmelee(), enemy.getMaxhitranged())) && invenUsed < invenSpaces) {
                            if (foodCooldown == 0) {
                                myLp += Math.min(loadout.getFoodUsed().getAmountHealed(), p.getLevel("Constitution")*25);
                                invenUsed++;
                                adren = Math.max(0, adren - 10);
                                foodCooldown = 3;
                                for (Map.Entry<Ability, Integer> abilityWithCooldown : cooldowns.entrySet()) {
                                    if (abilityWithCooldown.getValue() < 3)
                                        cooldowns.put(abilityWithCooldown.getKey(), 3);
                                }
                                //System.out.println("Tick " + ticks + ": Ate food number " + invenUsed);
                            }
                        } else {
                            for (Map.Entry<Ability, Integer> abilityWithCooldown : cooldowns.entrySet()) {
                                if (abilityWithCooldown.getValue() == 0) {
                                    if (abilityUsedThisTick == null || abilityWithCooldown.getKey().getExpectedDamage() > maxDamage) {
                                        abilityUsedThisTick = abilityWithCooldown.getKey();
                                        maxDamage = abilityWithCooldown.getKey().getExpectedDamage();
                                    }
                                }
                            }
                        }
                        if (abilityUsedThisTick != null) {
                            enemyLp -= myHitChance * myDamage * maxDamage;
                            //System.out.println("Tick " + ticks + ": Used " + abilityUsedThisTick.getName() + ", Enemy has " + enemyLp + " LP left");
                            cooldowns.put(abilityUsedThisTick, abilityUsedThisTick.getCooldown());
                            for (Map.Entry<Ability, Integer> abilityWithCooldown : cooldowns.entrySet()) {
                                if (abilityWithCooldown.getValue() < 3)
                                    cooldowns.put(abilityWithCooldown.getKey(), 3);
                                foodCooldown = 3;
                            }
                            switch (abilityUsedThisTick.getType()) {
                                case "Auto":
                                    adren += 2;
                                    break;
                                case "Basic":
                                    adren += 8;
                                    break;
                                case "Threshold":
                                    adren -= 15;
                                    break;
                                case "Ultimate":
                                    adren = 0;
                                    break;
                                default:
                                    throw new RuntimeException(String.format("Invalid type of ability: must be Auto, Basic, Threshold, or Ultimate, was %s", abilityUsedThisTick.getType()));
                            }
                            adren = Math.min(100, adren);
                        }
                        for (Map.Entry<Ability, Integer> abilityWithCooldown : cooldowns.entrySet())
                            cooldowns.put(abilityWithCooldown.getKey(), abilityWithCooldown.getValue() - 1);
                        foodCooldown--;
                        if (ticks % enemy.getAtkspd() == 0 && ticks != 0) {
                            myLp -= enemyHitChance * enemyDamage * (1 - loadout.totalReduc());
                            hpLost += enemyHitChance * enemyDamage * (1 - loadout.totalReduc());
                            //System.out.println("Tick " + ticks + ": LP Remaining: " + myLp);
                        }
                        ticks++;
                    }
                }
            }
            if (myLp < 0) {
                hpLost = 1000000000;
            }
            if (hpLost < minHpLost) {
                results = new CombatResults(hpLost, ticks, loadout);
                minHpLost = hpLost;
            }
        }
        return results;
    }
}
