# Big Text Adventure
### CSE 237 Project - Jeffrey Su, Ryan Miller, Jonathan Feehan

This is a text-based adventure game that follows the main character through a perilous journey to find a hidden treasure. The game is played purely in the command line and is entirely text. Fight monsters, acquire loot, and more, in Big Text Adventure.

## Iteration 3
### What user stories were completed this iteration?
For this iteration, we rearranged the structure of our repository so that the Game does not have static methods and so that it launches through the Launcher.java file. Additionally, the Game file now reads in the chapters through text files rather than print statements. In terms of the game, we fully implemented battles to allow for weapons, items, spells, and attacks. We finalized the inventory system and made sure to write tests before implementation of the code for this iteration.
### Is there anything that you implemented but doesn't currently work?
Everything in the game should work. The Dragon class is not used, but it does not impact the gameplay.
### What commands are needed to compile and run your code from the command line?
First, navigate to the correct space:
```
cd project-big-text-adventure/big-text-adventure/src
```
and then run our script:
```
./play.sh
```

## Iteration 2
### What user stories were completed this iteration?
For this iteration, we updated many of the existing classes like Game, Player, and Weapon, along with adding a new Enemy class and a class to handle battles. More specifically, we added several new chapters to the Game, allow players to choose a class in the beginning of the story, created enemies for players to fight, and added turn-by-turn combat. We also wrote tests, some of them relatively basic (we plan to add on to the tests as we learn more about writing more detailed tests), for most of the main classes. We're also working on more detailed weapons, enemies, and adding in functionality for spells/items (although it might not be worth it, we'll see).
### What user stories do you intend to complete next iteration?
We intend to expand the weapons to be more detailed. This means weapons that work for specific classes that have different abilities, stats, and more. Additionally, we want to add more enemies and 2-3 boss fights that have slightly different battle mechanics than the turn-based combat that is currently in the game. Within battles, we'd potentially like to make enemies do more than just attack. We'd also like to add the ability for players to use spells/items during battles. Prof Shook also mentioned in feedback that our static Game class could present an issue, we looked into this and will potentially restructure things so that Game methods are not static in this next iteration. We also plan on writing more detailed tests near the beginning of the next iteration.
### Is there anything that you implemented but doesn't currently work?
Everything that is playable from the main branch should work. There is work being done on separate branches that is not fully developed yet and may not be functional. Additionally, there are a few files that are present in the main branch, such as Dragon or Weapons, that are not functional as of yet.
### What commands are needed to compile and run your code from the command line?
First, navigate to the correct space:
```
cd project-big-text-adventure/big-text-adventure/src
```
and then run our script:
```
./play.sh
```

## Iteration 1
### What user stories were completed this iteration?
For this iteration, we created Game, Player, and Weapon classes and worked on features within those classes. This work took up most of the user stories in this iteration. Additionally, we began to work on some of the tests (which also included 1 user story).
### What user stories do you intend to complete next iteration?
There is a lot more detail that can be added relative to each of the classes. Additionally, we want to start breaking "chapters" of the game into user stories so that we can write out a lot of the game's content prior to development (so that we know what to program). These will encompass most of the user stories for this iteration.
### Is there anything that you implemented but doesn't currently work?
Everything that exists on the main branch should work. There is work being done on separate branches that is not fully developed yet and may not be functional.
### What commands are needed to compile and run your code from the command line?
First we will navigate to the correct space:
```
cd project-big-text-adventure/big-text-adventure/src
```
and then run:
```
java Game
```

