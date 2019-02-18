# About Project Tenacity
Project Tenacity is a dynamic account pathing system for RuneScape 3. Its goal is to provide RS3 players with a powerful, easy-to-use tool to determine the optimal method to progress their account. This tool serves as a replacement and upgrade to my former attempts at making this type of guide, namely my "Level 3 to Quest Cape" and "Level 3 to All Capes" Reddit guides from several years ago.

# How to run
Project Tenacity requires Java 8 (or higher) to run. If you do not have this, you can download the latest version [here.](https://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html)

Once you have Java 8, download Project Tenacity by clicking on the "releases" button above. Select the most recent version and download the .jar file.

Finally, run the .jar.

# How to use
To create a new player profile, select "New Profile" and input a player name to use. If you use a valid RSN and have a public RuneMetrics profile, this will also pull your stats and completed quests from RuneMetrics. Currently, only mainscape profile creation is supported, not Ironman or HCIM. (Sorry. I tried. But adding Ironman and HCIM support would probably take another 3 years to complete.) To load a previously created profile, input the name of the profile you wish to load, and select "Load Profile."

It is important to note that if this is your first time using Project Tenacity, the tool must gather Grand Exchange data on all of the items in its item database. This takes approximately 5-7 minutes. Also, every time a profile is created or loaded, the tool will calculate the optimal path for the profile, which will take up to a minute depending on player progress.

Once your profile is created or loaded, you will be on the main pathing screen. This screen consists of two tables: an achievement table that contains every achievement in RuneScape that your character has not yet completed, and a player table that includes details about your player, such as your player's skill levels, bank, gear, and the achievements they have completed.

The achievement table will provide an estimate of the amount of time that it will take you to complete each achievement in the game. This estimate is determined through three parts: the time taken to fulfill all the requirements for the achievement, the time taken to actually complete the achievement itself, and the time saved by the rewards the achievement gives (this time is deducted from the previous two.) As such, if an achievement provides a lot of reward for little cost, it will be ranked higher on the table than a task that provides no rewards for the same cost.

When you click on an achievement in the table, it will provide more details about the achievement in question, such as the total time to complete the achievement (without rewards factored in), the requirements that must be fulfilled before the achievement can be completed, the recommended actions that should be taken to complete the achievement (such as how to train skills for skill requirements), and what skills lamps should be used on (if the achievement provides any lamps.) To mark an achievement as completed, select the achievement and click the "Complete Achievement/Recalc" button. Note that this will automatically perform a recalculation. If you have selected an achievement but wish to perform a recalc without marking it as completed, you can deselect it by right-clicking anywhere on the table. If you have marked an achievement as completed and wish to unmark it (make it not completed again), you can do this by going to the qualities tab of the player table, removing the row that corresponds to that achievement, and performing a recalc.

The player table consists of five subsections: skills, bank, weapons, armour, and qualities. The skills section displays your character's experience in each skill, the bank section displays the items that are in your character's bank, the weapons section displays the current weapons your character can use, the armour section displays the current armour your character can use, and the qualities section is for anything that doesn't fit into the other four sections (mainly used for completed achievements.)

Note that the bank, weapons, and armour sections are user-managed, since there is no RuneMetrics API that can get them from your RuneScape profile. Entries in tables other than skills can be added or removed with the text fields and buttons at the bottom-right corner of the screen. Quantities can be edited for any section with a quantity (including skills) by double-clicking on the quantity field and inputting the desired quantity.

A few things to note on the player table: 

 -If you input a weapon or a piece of armour into the weapons/armour section that is superior in every way to an existing piece of armour, it will automatically remove the inferior weapon or piece of armour. For this reason, it is NOT recommended to input weaponry or armour into the table that you do not currently have the requirements for, as this will produce undefined behavior.
 
 -The bank section is meant only for tradeable items, and will reject untradeable items. Additionaly, since Project Tenacity treats the bank as items that can be sold at any time without loss of progress (since they can simply be bought back if needed), it is not recommended to input items into the bank that you do not want to sell, such as your best weapons or armour.
 
 -Changes to the player table will not take effect until you perform a recalc with the "Complete Achievement/Recalc" button.
 
The final point of note is the "Save Player Data" button. In order to save your data, you must click this button. This will automatically generate a player data file, which can be loaded with the "Load Profile" button the next time you start up Project Tenacity. Note that saving ONLY occurs with this button--there is no "auto-saving" feature in Project Tenacity. Backing up your save files is highly recommended.

# How to report an error
**There is absolutely nothing wrong with Project Tenacity. How DARE you-- (SMACK)**

Ahem. If you find something that you think (or know) is wrong, click the "issues" tab above and create a new issue. Include as much detail as possible about the issue, including but not limited to what the issue actually is, what steps you took to cause the issue, if the issue is reproducible, if there is a way you can work around the issue, a screenshot of the issue occurring, and your player data file (if applicable.) After ain issue is created, I will tag it with the appropriate severity label:

T99 - crash or other technical error (that makes it impossible to use Project Tenacity at all)

T90 - information that is definitely incorrect (such as a missed requirement on an achievement)

T80 - a visual error or mistake (such as a typo)

T70 - information that is possibly incorrect (perhaps Project Tenacity tells you a fight is winnable with your current gear, but you can't manage to do it)

T60 - feature request (everything is working, but something could be improved)

Creating an issue in this manner is the only 100% surefire way to ensure that I will see your report. Other contact methods such as Reddit, Discord, and in-game RS can be used, but are less certain. And if you flag your feature request as T99, I will NOT be happy.

That should be everything. Thanks for using Project Tenacity!
