package logic;

import data.databases.AbilityDatabase;
import data.databases.FamiliarDatabase;
import data.dataobjects.*;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Encounter implements Serializable {

    private static final int TICKS_PER_HOUR = 6000;

    private List<List<Enemy>> enemyGroups;
    private int partySize;
    private boolean safespot;

    public Encounter(List<List<String>> enemyGroups) {
        this.enemyGroups = new ArrayList<>();
        for (List<String> enemyGroup : enemyGroups) {
            this.enemyGroups.add(enemyGroup.stream().map(a -> Enemy.getEnemyByName(a)).collect(Collectors.toList()));
        }
        this.partySize = 1;
        this.safespot = false;
    }

    public Encounter(List<List<String>> enemyGroups, boolean safespot) {
        this.enemyGroups = new ArrayList<>();
        for (List<String> enemyGroup : enemyGroups) {
            this.enemyGroups.add(enemyGroup.stream().map(a -> Enemy.getEnemyByName(a)).collect(Collectors.toList()));
        }
        this.partySize = 1;
        this.safespot = safespot;
    }

    public Encounter(List<List<String>> enemyGroups, int partySize) {
        this.enemyGroups = new ArrayList<>();
        for (List<String> enemyGroup : enemyGroups) {
            this.enemyGroups.add(enemyGroup.stream().map(a -> Enemy.getEnemyByName(a)).collect(Collectors.toList()));
        }
        this.partySize = partySize;
        this.safespot = false;
    }

    public Encounter(String enemy, int partySize) {
        this.enemyGroups = Collections.singletonList(Collections.singletonList(Enemy.getEnemyByName(enemy)));
        this.partySize = partySize;
        this.safespot = false;
    }

    public Encounter(String enemy) {
        this.enemyGroups = Collections.singletonList(Collections.singletonList(Enemy.getEnemyByName(enemy)));
        this.partySize = 1;
        this.safespot = false;
    }

    public List<List<Enemy>> getEnemyGroups() {
        return enemyGroups;
    }

    public int getPartySize() {
        return partySize;
    }

    public boolean isSafespot() {
        return safespot;
    }

    public CombatResults calculateCombat(Player p, CombatParameters parameters) {
        CombatScenario scenario = new CombatScenario(this, parameters);
        if (StoredCombatCalcs.getSuccessfulCombats().get(scenario) != null) {
            return StoredCombatCalcs.getSuccessfulCombats().get(scenario);
        }
        CombatResults results = new CombatResults(1000000000, 0, 6100, null);;
        double minHpLost = 1000000001;
        int maxKills = 0;
        for (Loadout loadout : generateLoadouts(p, parameters.getCombatStyle())) {
            double myLp = p.getLevel("Constitution") * 100 + loadout.totalLp();
            int maxLpHealedPerFood = p.getLevel("Constitution") * 25;
            if (p.getLevel("Constitution") == 99) {
                maxLpHealedPerFood = 2600;
            }
            int ticks = -1;
            double hpLost = 0;
            int invenUsed = 0;
            int inventorySize = parameters.getInvenSpaces() + loadout.getFamiliar().getInvenSpaces();
            int myMeleeAffinity;
            int myRangedAffinity;
            int myMagicAffinity;
            if (parameters.getCombatStyle().equals("Melee")) {
                myMeleeAffinity = 55;
                myRangedAffinity = 45;
                myMagicAffinity = 65;
            } else if (parameters.getCombatStyle().equals("Ranged")) {
                myMeleeAffinity = 65;
                myRangedAffinity = 55;
                myMagicAffinity = 45;
            } else {
                myMeleeAffinity = 45;
                myRangedAffinity = 65;
                myMagicAffinity = 55;
            }
            CombatStats combatStats = loadout.getCombatStats(p, parameters.getCombatStyle());
            List<CombatStats> previousStatsList = StoredCombatCalcs.getCalculatedCombats().get(new CombatScenario(this, parameters));
            if (previousStatsList != null) {
                boolean doomedToFail = false;
                for (CombatStats previousStats : previousStatsList) {
                    if (combatStats.getAccuracy() <= previousStats.getAccuracy() && combatStats.getArmour() <= previousStats.getArmour() &&
                        combatStats.getArmour() <= previousStats.getDamage() && combatStats.getReduc() <= previousStats.getReduc()) {
                        doomedToFail = true;
                        break;
                    }
                }
                if (doomedToFail) {
                    continue;
                }
            }
            p.setTotalEncounters(p.getTotalEncounters() + 1);
            Map<Ability, Integer> cooldowns = new HashMap<>();
            for (Ability ability : AbilityDatabase.getAbilityDatabase().getAbilities()) {
                if (ability.canUse(loadout.getMainWep(), loadout.getOffWep(),  p))
                    cooldowns.put(ability, 0);
            }
            cooldowns.put(new Ability("Auto-attack", loadout.getMainWep().getWeaponClass(), "Any", "Auto", loadout.getMainWep().getAtkspd(),
                (loadout.getMainWep().getDamage()+ loadout.getMainWep().getMaxAmmo())*0.5/combatStats.getDamage(), 0,
                (loadout.getMainWep().getDamage()+ loadout.getMainWep().getMaxAmmo())*0.5/combatStats.getDamage(), new ArrayList<>()), 0);
            int adren = 0;
            int foodCooldown = 0;
            int kills = 0;
            double nextDrop = 0.0;
            boolean stackableUsed = false;
            while (ticks < TICKS_PER_HOUR) {
                for (List<Enemy> enemyGroup : enemyGroups) {
                    for (Enemy enemy : enemyGroup) {
                        int monsterTicks = -1;
                        int monsterStun = 0;
                        //System.out.println("Began fighting: " + enemy.getName());
                        int affinity;
                        if (loadout.getMainWep().getStyle().equals(enemy.getWeakness())) {
                            affinity = enemy.getAffweakness();
                        } else if (parameters.getCombatStyle().equals("Melee")) {
                            affinity = enemy.getAffmelee();
                        } else if (parameters.getCombatStyle().equals("Ranged")) {
                            affinity = enemy.getAffranged();
                        } else {
                            affinity = enemy.getAffmage();
                        }
                        double enemyArmour = (0.0008 * Math.pow(enemy.getDef(), 3) + 4 * enemy.getDef() + 40) + enemy.getArmor();
                        double myHitChance = Math.min(1, (affinity * combatStats.getAccuracy()) / (enemyArmour * 100.0));
                        int enemyAttackStyles = 0;
                        double enemyMeleeDamage = 0;
                        double enemyRangedDamage = 0;
                        double enemyMagicDamage = 0;
                        if (enemy.getAccmelee() > 0) {
                            enemyAttackStyles++;
                            enemyMeleeDamage = Math.min(1, (myMeleeAffinity * (enemy.getAccmelee() + (0.0008 * Math.pow(enemy.getAttack(), 3) + 4 * enemy.getAttack() + 40))
                                / combatStats.getArmour()) / 100) * enemy.getMaxhitmelee() / 2.0;
                        }
                        if (enemy.getAccranged() > 0) {
                            enemyAttackStyles++;
                            enemyRangedDamage = Math.min(1, (myRangedAffinity * (enemy.getAccranged() + (0.0008 * Math.pow(enemy.getRanged(), 3) + 4 * enemy.getRanged() + 40))
                                / combatStats.getArmour()) / 100) * enemy.getMaxhitranged() / 2.0;
                        }
                        if (enemy.getAccmage() > 0) {
                            enemyAttackStyles++;
                            enemyMagicDamage = Math.min(1, (myMagicAffinity * (enemy.getAccmage() + (0.0008 * Math.pow(enemy.getMagic(), 3) + 4 * enemy.getMagic() + 40))
                                / combatStats.getArmour()) / 100) * enemy.getMaxhitmagic() / 2.0;
                        }
                        double enemyLp = enemy.getLp() / partySize;
                        while (myLp > 0 && enemyLp > 0) {
                            if (ticks % 2000 == 0 && p.getLevel("Herblore") >= 96) {
                                invenUsed++;
                            }
                            ticks++;
                            monsterTicks++;
                            if (monsterStun > 0) {
                                monsterStun--;
                            }
                            Ability abilityUsedThisTick = null;
                            double maxDamage = 0;
                            if (myLp < Math.max(enemy.getMaxhitmagic(), Math.max(enemy.getMaxhitmelee(), enemy.getMaxhitranged())) && invenUsed < inventorySize) {
                                if (foodCooldown <= 0) {
                                    myLp += maxLpHealedPerFood;
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
                                    if (abilityWithCooldown.getValue() <= 0 && (abilityWithCooldown.getKey().getType().equals("Auto")
                                        || abilityWithCooldown.getKey().getType().equals("Basic")
                                        || (abilityWithCooldown.getKey().getType().equals("Threshold") && adren >= 50)
                                        || (abilityWithCooldown.getKey().getType().equals("Ultimate") && adren == 100))) {
                                        if (monsterStun > 0) {
                                            if (abilityUsedThisTick == null || abilityWithCooldown.getKey().getStunDamage() > maxDamage
                                                || (abilityWithCooldown.getKey().getStunDamage() == maxDamage && abilityWithCooldown.getKey().getCooldown() > abilityUsedThisTick.getCooldown())) {
                                                abilityUsedThisTick = abilityWithCooldown.getKey();
                                                maxDamage = abilityWithCooldown.getKey().getStunDamage();
                                            }
                                        } else {
                                            if (abilityUsedThisTick == null || abilityWithCooldown.getKey().getExpectedDamage() > maxDamage
                                                || (abilityWithCooldown.getKey().getExpectedDamage() == maxDamage && abilityWithCooldown.getKey().getCooldown() > abilityUsedThisTick.getCooldown())) {
                                                abilityUsedThisTick = abilityWithCooldown.getKey();
                                                maxDamage = abilityWithCooldown.getKey().getExpectedDamage();
                                            }
                                        }
                                    }
                                }
                            }
                            if (abilityUsedThisTick != null) {
                                enemyLp -= myHitChance * combatStats.getDamage() * maxDamage;
                                if (!enemy.isStunimmune()) {
                                    monsterStun = Math.max(monsterStun, abilityUsedThisTick.getStunTicks());
                                }
                                //System.out.println("Tick " + ticks + ": Used " + abilityUsedThisTick.getName() + ", Enemy has " + enemyLp + " LP left");
                                cooldowns.put(abilityUsedThisTick, abilityUsedThisTick.getCooldown());
                                if (!abilityUsedThisTick.getType().equals("Auto")) {
                                    for (Map.Entry<Ability, Integer> abilityWithCooldown : cooldowns.entrySet()) {
                                        if (abilityWithCooldown.getValue() < 3)
                                            cooldowns.put(abilityWithCooldown.getKey(), 3);
                                        foodCooldown = 3;
                                    }
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
                            if (monsterTicks % (enemy.getAtkspd() * partySize) == 0 && monsterTicks != 0 && monsterStun == 0) {
                                double enemyDamage;
                                enemyDamage = (enemyMeleeDamage + enemyRangedDamage + enemyMagicDamage) / enemyAttackStyles;
                                myLp -= enemyDamage * (1 - loadout.totalReduc());
                                hpLost += enemyDamage * (1 - (loadout.totalReduc() + p.getLevel("Defence")/1000.0));
                                //System.out.println("Tick " + ticks + ": LP Remaining: " + myLp);
                            }
                        }
                    }
                    //hide in safespot and heal w/regen between enemy groups/waves
                    if (myLp > 0 && safespot) {
                        myLp += (p.getLevel("Constitution") * adren) / 5;
                        adren = 0;
                        //System.out.println("LP Remaining after Regenerate: " + myLp);
                    }
                }
                if (myLp > 0 && ticks < TICKS_PER_HOUR) {
                    kills++;
                    nextDrop += parameters.getDroprate();
                    if (nextDrop > 1.0) {
                        //System.out.println(String.format("Tick %d: Spending 5 ticks to pick up a drop", ticks));
                        nextDrop--;
                        ticks+=5;
                        foodCooldown-=5;
                        for (Map.Entry<Ability, Integer> abilityWithCooldown : cooldowns.entrySet())
                            cooldowns.put(abilityWithCooldown.getKey(), abilityWithCooldown.getValue() - 5);
                        if (!parameters.isStackable() || !stackableUsed) {
                            stackableUsed = true;
                            invenUsed++;
                        }
                    }
                    int minCooldown = cooldowns.values().stream().mapToInt(a -> a).min().orElseThrow(RuntimeException::new);
                    if (minCooldown > 0) {
                        ticks += minCooldown;
                        foodCooldown-=minCooldown;
                        for (Map.Entry<Ability, Integer> abilityWithCooldown : cooldowns.entrySet())
                            cooldowns.put(abilityWithCooldown.getKey(), abilityWithCooldown.getValue() - minCooldown);
                    }
                    //System.out.println("Total kills so far: " + kills);
                }
                if (!parameters.isMultikill() || myLp <= 0) {
                    break;
                }
            }
            if (myLp <= 0 && kills == 0) {
                List<CombatStats> currentFailedStats = StoredCombatCalcs.getCalculatedCombats().get(new CombatScenario(this, parameters));
                List<CombatStats> failedStats;
                if (currentFailedStats == null) {
                    failedStats = new ArrayList<>();
                }
                else {
                    failedStats = new ArrayList<>(currentFailedStats);
                }
                failedStats.add(0, combatStats);
                StoredCombatCalcs.getCalculatedCombats().put(new CombatScenario(this, parameters), failedStats);
                //if one loadout fails, just give up and upgrade your gear. better safe than sorry, also checking every loadout would make the runtime too long to be usable
                break;
            }
            if (kills > maxKills || (kills == maxKills && hpLost < minHpLost)) {
                results = new CombatResults(hpLost, kills, Math.min(ticks, TICKS_PER_HOUR), loadout);
                minHpLost = hpLost;
                maxKills = kills;
            }
        }
        if (results.getHpLost() < 1000000) {
            StoredCombatCalcs.getSuccessfulCombats().put(new CombatScenario(this, parameters), results);
        }
        return results;
    }

    private List<Loadout> generateLoadouts(Player player, String combatStyle) {
        List<Loadout> loadouts = new ArrayList<>();
        List<Weapon> mainWeps = new ArrayList<>();
        List<Weapon> offWeps = new ArrayList<>();
        List<Armour> shields = new ArrayList<>();
        List<Armour> headArmour = new ArrayList<>();
        List<Armour> torsoArmour = new ArrayList<>();
        List<Armour> legArmour = new ArrayList<>();
        List<Armour> handArmour = new ArrayList<>();
        List<Armour> feetArmour = new ArrayList<>();
        List<Armour> capeArmour = new ArrayList<>();
        List<Armour> neckArmour = new ArrayList<>();
        List<Armour> ringArmour = new ArrayList<>();
        Familiar familiar = Familiar.getFamiliarByName("None");
        for (Weapon w : player.getWeapons()) {
            if (w.getWeaponClass().equals(combatStyle) && w.getReqs().stream().allMatch(r -> r.meetsRequirement(player))) {
                if (w.getSlot().equals("Off-hand")) {
                    offWeps.add(w);
                }
                else {
                    mainWeps.add(w);
                }
            }
        }
        for (Armour a : player.getArmour()) {
            if (a.getSlot().equals("Head") && a.getType().equals(combatStyle)) {
                headArmour.add(a);
            } else if (a.getSlot().equals("Torso") && a.getType().equals(combatStyle)) {
                torsoArmour.add(a);
            } else if (a.getSlot().equals("Legs") && a.getType().equals(combatStyle)) {
                legArmour.add(a);
            } else if (a.getSlot().equals("Hands") && a.getType().equals(combatStyle)) {
                handArmour.add(a);
            } else if (a.getSlot().equals("Feet") && a.getType().equals(combatStyle)) {
                feetArmour.add(a);
            } else if (a.getSlot().equals("Cape") && (a.getType().equals(combatStyle) || a.getType().equals("All"))) {
                capeArmour.add(a);
            } else if (a.getSlot().equals("Neck") && (a.getType().equals(combatStyle) || a.getType().equals("All"))) {
                neckArmour.add(a);
            } else if (a.getSlot().equals("Ring") && (a.getType().equals(combatStyle) || a.getType().equals("All"))) {
                ringArmour.add(a);
            } else if (a.getSlot().equals("Shield") && a.getType().equals(combatStyle)) {
                shields.add(a);
            }
        }
        for (Familiar f : FamiliarDatabase.getFamiliarDatabase().getFamiliars()) {
            if (player.getLevel("Summoning") >= f.getSummonReq() && f.getInvenSpaces() > familiar.getInvenSpaces()) {
                familiar = f;
            }
        }
        if (headArmour.size() == 0) {
            headArmour.add(Armour.getArmourByName("None"));
        }
        if (torsoArmour.size() == 0) {
            torsoArmour.add(Armour.getArmourByName("None"));
        }
        if (legArmour.size() == 0) {
            legArmour.add(Armour.getArmourByName("None"));
        }
        if (handArmour.size() == 0) {
            handArmour.add(Armour.getArmourByName("None"));
        }
        if (feetArmour.size() == 0) {
            feetArmour.add(Armour.getArmourByName("None"));
        }
        if (capeArmour.size() == 0) {
            capeArmour.add(Armour.getArmourByName("None"));
        }
        if (neckArmour.size() == 0) {
            neckArmour.add(Armour.getArmourByName("None"));
        }
        if (ringArmour.size() == 0) {
            ringArmour.add(Armour.getArmourByName("None"));
        }
        offWeps.add(Weapon.getWeaponByName("None"));
        shields.add(Armour.getArmourByName("None"));
        for (Weapon w : mainWeps) {
            for (Armour head : headArmour) {
                for (Armour torso : torsoArmour) {
                    for (Armour leg : legArmour) {
                        for (Armour hand : handArmour) {
                            for (Armour foot : feetArmour) {
                                for (Armour cape : capeArmour) {
                                    for (Armour neck : neckArmour) {
                                        for (Armour ring : ringArmour) {
                                            for (Weapon offWep : offWeps) {
                                                for (Armour shield : shields) {
                                                    Loadout loadout = new Loadout(w, offWep, shield, head, torso, leg, hand, foot, cape, neck, ring, familiar, player.getXp());
                                                    if (loadout.checkValid()) {
                                                        loadouts.add(loadout);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        Map<Loadout, CombatStats> loadoutsToStats = new HashMap<>();
        for (Loadout loadout : loadouts) {
            CombatStats combatStats = loadout.getCombatStats(player, combatStyle);
            boolean insertLoadout = true;
            List<Loadout> obsoletedLoadouts = new ArrayList<>();
            for (Map.Entry<Loadout, CombatStats> loadoutToStats : loadoutsToStats.entrySet()) {
                CombatStats previousStats = loadoutToStats.getValue();
                if (combatStats.getDamage() <= previousStats.getDamage() && combatStats.getReduc()  <= previousStats.getReduc()) {
                    insertLoadout = false;
                }
                else if (combatStats.getDamage() >= previousStats.getDamage() && combatStats.getReduc() >= previousStats.getReduc()) {
                    obsoletedLoadouts.add(loadoutToStats.getKey());
                }
            }
            for (Loadout obsoleteLoadout : obsoletedLoadouts) {
                loadoutsToStats.remove(obsoleteLoadout);
            }
            if (insertLoadout) {
                loadoutsToStats.put(loadout, combatStats);
            }
        }
        //System.out.println(loadoutsToStats.keySet().size());
        return new ArrayList<>(loadoutsToStats.keySet());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Encounter)) {
            return false;
        }
        Encounter encounter = (Encounter) obj;
        return enemyGroups.equals(encounter.getEnemyGroups()) && partySize == encounter.getPartySize() && safespot == encounter.isSafespot();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + enemyGroups.hashCode();
        result = 31*result + partySize;
        result = 31*result + (safespot ? 1 : 0);
        return result;
    }
}
