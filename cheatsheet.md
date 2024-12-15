The layout of the game is simple: the user starts in abandoned New York City and must make it down to Washington, D.C. Along the way, they gather objects to prove their identity and make it to safety. I looked it up, and New York is approximately 230 miles away from D.C., so that is the distance needed. I didn't include a time limit, so their health is the other parameter to potentially end the game. 

The commands are numbers that the user picks when prompted: 

- Wrong Turns: 
With each run through of the drive or walk method, the game prompts the user to turn either left or right, by choosing 1 or 2, respectively. The wrong turn number is randomized with each run through of the game loop. If the user picks the wrong turn, they add 5 miles to the distance needed to travel to reach the end of the game. They have the opportunity to reach their original distance by continuing driving on the right path, but only if they choose wisely.

- Keep Driving:
With each run through of the drive or walk method, the user has the opportunity to keep driving, rest, restock, or be attacked by zombies. If they are on the right path, the game prompts whether they choose 1 for keep driving or walking or choose 2 for a chance to rest, restock, or be attacked by zombies. This gives the user a chance to choose if they do not need to rest or restock or if they desperately need to. 

- Rest, Restock, or Zombies:
If the user chooses 2, they enter a new number between 1 and 100. This new number decides their fate. If they choose the zombie number, then they are attacked by zombies. The decrease to the user's health is random. If the choose a rest number, the user chooses 0, 1, or 5 hours of rest. Their health increases if they choose to rest, but lose hours on the road. If they choose a restock number, then the user can only restock one item at a time that they choose. 

- Use Bandages: 
When the user chooses zombies, they have the opportunity to use their bandages to gain back some health. If they have enough and they decide to use them, then their health increases by little. If they do not have enough or they choose to not use bandages, then their health stays the same. 
