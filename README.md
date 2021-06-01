# Description <br>

The ludo Board game is based off of the Board game ludo. It is a game where the user tries to get all of their pieces to the middle of the board. It is kind of played like sorry. Copy and paste the link below to see more of the rules. 

# Ludo Game Set Up
Ever since I switched back to maven some of the system.out text for the initial setup has been showing up late probably because it is buffered in some way or there is some other thread running and it is blocking it. Besides not showing up the console application part reamians the same. The standard input you will need to put in is below in parethesis and the system.output that was supposed to show up is also below.

1) If there is a save available it will ask if you want to resume (Enter Y for yes and N for no)
2) If there wasnt a save or you enetered no it will ask you the following:
3) How many players (Enter a number 1 .. 4)
4) How many tokens for each player (Enter a number 1 .. 4)
5) Now it will loop through each player and ask the following:
6) Is player X a CPU(Enter yes or no)
7) If they ansered yes then it will follow up asking to enter the diffuculty (Enter Easy medium or Hard)

# Playing the Game <br>
Shortly after the Command Line setup a window with the board will appear <br>
In the top you should see which players turn it is <br>
* The player needs to select a piece they want to move * <br>
* The user will gain acces to a roll button to roll the dice. * <br>
** Note: If the player is a CPU one of the local players needs to still click the roll button for the AI However the AI will chose the piece it wants to move** <br>
* This was by design so the player could actually mentally record the AIs movements as apposed to it just rolling right after the previous players turn. *
