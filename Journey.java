import java.lang.Math;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Hashtable; 
import java.util.Random; 

/**
 * Journey Class: Game class
 */
public class Journey extends Intro {
    private static int Gas;
    private int distanceTraveled;
    private int hoursTraveled;
    private static int distanceNeeded;
    private Scanner input; 
    private static ArrayList<String> essentials = new ArrayList<String>();
    private Hashtable<String, Boolean> collections = new Hashtable<String, Boolean>();
    private static ArrayList<Integer> healthIncrements = new ArrayList<Integer>(); 
    
    /**
     * Constructor/Initializes all of the variables, ArrayLists, and lone Hashtable
     * @param Gas
     */
     public Journey(int Gas) {
        super(100, 50, 100, 2);
        Journey.Gas = Gas;
        distanceTraveled = 0;
        distanceNeeded = 230;
        hoursTraveled = 0;
        this.input = new Scanner(System.in);
        essentials.add("Food");
        essentials.add("Gas");
        essentials.add("Water");
        essentials.add("Bandages"); 
        healthIncrements.add(10);
        healthIncrements.add(30);
        healthIncrements.add(50); 
        collections.put("Key", false);
        collections.put("Driver's License", false);
        collections.put("Journal", false); 
        }
    
    /**
     * If the user runs out of gas, then they must walk until they reach a restock station. Returns a right or wrong turn. Collect objects along the way.
     * @return turn 
     */
    public int walk() {
        System.out.println();
        System.out.println("You're now walking!"); 
        distanceTraveled += 3;
        hoursTraveled ++; 
        distanceNeeded = distanceNeeded - distanceTraveled; 
        System.out.println("Distance Traveled: " + distanceTraveled + "\n Hours Traveled: " + hoursTraveled);
        System.out.println("You have reached a fork in the road: left or right? Pick 1 for left and 2 for right."); 
        if (distanceNeeded == 200){
            System.out.println("You have found a key!");
            collections.put("Key", true); 
        } 
        else if (distanceNeeded == 100){
            System.out.println("You have found a driver's license!");
            collections.put("Driver's License", true); 
        }
        else if (distanceNeeded == 10){
            System.out.println("You have found a journal!");
            collections.put("Journal", true); 
        }
        int turn = this.input.nextInt();
        this.input.nextLine();
        return turn;
    }
    /**
     * Moves the user forward if they have gas. Returns right or wrong turns. Collects objects along the way.
     * @return turn 
     */
    public int drive() { 
        System.out.println();
        System.out.println("You're now driving!");
        distanceTraveled += 10;
        hoursTraveled ++;
        Gas -= 5;
        distanceNeeded = distanceNeeded - distanceTraveled; 
        System.out.println("Distance Traveled: " + distanceTraveled + " miles \nHours Traveled: " + hoursTraveled + "\nGas: " + Gas + "\nDistance Needed: " + distanceNeeded + " miles");
        System.out.println("You have reached a fork in the road: left or right? Pick 1 for left and 2 for right.");
        if (distanceNeeded == 200){
            System.out.println("You have found a key!");
            collections.put("Key", true); 
        } 
        else if (distanceNeeded == 100){
            System.out.println("You have found a driver's license!");
            collections.put("Driver's License", true); 
        }
        else if (distanceNeeded == 10){
            System.out.println("You have found a journal!");
            collections.put("Journal", true); 
        }
        int turn = this.input.nextInt();
        this.input.nextLine();
        return turn;
    }
    
    /**
     * If the user decides to choose their fate, this is where they decide. Returns their decision for rest, restock, or zombies
     * @return user_number
     */
    public int userActions(){ 
        System.out.println();
        System.out.println("What do you want to do?");
        System.out.println("Food: " + Food + "\n Water: " + Water + " \n Gas: " + Gas + " \n Bandages: " + Bandages);
        System.out.println("Pick 1 for keep driving/walking or pick 2 to try your luck at restocking, resting, or zombies. It's your funeral. Literally."); 
        int user_action = this.input.nextInt();
        this.input.nextLine(); 
        if (user_action == 1) {
            int user_number = 0;
            return user_number;
        }   
        else {
            System.out.println("Please pick a number between 1 and 100. What you choose will be your fate.");
            int user_number = this.input.nextInt();
            this.input.nextLine(); 
            return user_number; 
        }   
    }
    
    /**
     * Restock method, if the user chooses to. Can only restock one item at a time. 
     */
    public void restock() { 
        System.out.println();
        System.out.println("You've reached a restock station!");
        do {
            System.out.println("Which items would you like to restock?");
            String item = this.input.nextLine(); 
            if (essentials.contains(item)) {
                if (item == "Food"){
                    Food += 20;
                    System.out.println("Food restocked! \nFood: " + Food);
                    break;
                }
                if (item == "Water"){
                    Water += 2;
                    System.out.println("Water restocked! \nWater: " + Water);
                    break;
                }
                if (item == "Gas"){
                    Gas += 20; 
                    System.out.println("Gas restocked! \nGas: " + Gas);
                    break;
                }
                if (item == "Bandages"){
                    Bandages += 20;
                    System.out.println("Bandages restocked! \nBandages: " + Bandages);
                    break;
                }
            }
            else {
                System.out.println("You cannot restock on this item. Check your essentials.");
            }
        } while (true); 
    }
    
    /**
     * Rest method, if the user chooses to. Choose 0, 1, or 5 hours of rest. Increases health. 
     */
    public void rest() { 
        System.out.println();
        System.out.println("You've reached a rest station!");
        System.out.println("Choose either 0 hours, 1 hour, or 5 hours. \nIf you do not want to rest, pick 0 hours. \nIf you choose 1 hour, your health will not increase as much, but you will get back on the road sooner. \nIf you choose 5 hours, your health will increase more, but you will stay longer.");
        int rest_hours; 
        do {
            System.out.println("How long would you like to rest?");
            rest_hours = this.input.nextInt();
            this.input.nextLine();
            if (rest_hours == 0) {
                System.out.println("You chose to move on without resting. Good luck.");
                break;
            }
            if (rest_hours == 1) {
                hoursTraveled ++; 
                if (Health < 95) {
                    Health += 5; 
                    System.out.println("Health: " + Health + "\nHours Traveled: " + hoursTraveled);
                }
                else {
                    Health = 100; 
                    System.out.println("You cannot exceed 100% health! Automatically restoring health to 100% \n Health: "+ Health + "% \nHours Traveled: " + hoursTraveled);
                } 
                break;
            } 
            if (rest_hours == 5) {
                hoursTraveled += 5; 
                if (Health < 85) {
                    Health += 15; 
                    System.out.println("Health: " + Health + "\n Hours Traveled: " + hoursTraveled);
                }
                else {
                    Health = 100; 
                    System.out.println("You cannot exceed 100% health! Automatically restoring health to 100% \n Health: "+ Health + "% \nHours Traveled: " + hoursTraveled);
                } 
                break;
            }
            else {
                System.out.println("Please choose either 0, 1, or 5 hours of rest.");
            }
        }  while (true);
    }
    
    /**
     * If the user unfortunately chooses zombie attack, their health decreases by a random amount. Then, they can decide if they want to use bandages to increase health or not. 
     */
    public void zombieAttack() {
        System.out.println();
        System.out.println("You've been attacked by zombies! Try to save yourself!");
        Random rand = new Random();
        int healthDecrease = healthIncrements.get(rand.nextInt(healthIncrements.size()));
        Health -= healthDecrease; 
        do {
            System.out.println("Health: " + Health + "\n Do you want to use bandages to increase your health? Pick yes or no.");
            String useBandages = this.input.nextLine();
            if (useBandages == "yes") {
                if (Bandages > 10) {
                    Bandages -= 10;
                    Health += 10; 
                    System.out.println("Health increased by 10%! Be careful next time. \nHealth: " + Health + "\nBandages: " + Bandages);
                    break;
                }
                else {
                    System.out.println("You do not have enough bandages to heal! Try restocking next time you can.");
                    break;
                }
            }
            else if (useBandages == "no") {
                System.out.println("Alright, it's your funeral. Carry on. \n Health:" + Health);
                break;
            }
            else {
                System.out.println("Please enter yes or no.");
            }
        } while(true);
    }
    
    /**
     * Returns the random zombie number for the user to potenially choose
     * @return zombies
     */
    public int zombieNumber() {
        int zombies = (int)(Math.random() * (100 - 1)) + 1;
        return zombies; 
    }
    
    /**
     * Returns the random right or wrong turn number for the user to potentially choose
     * @return rightTurn
     */
    public int rightTurnNumber() {
        int rightTurn = (int)(Math.random() * (2 - 1)) + 1;
        return rightTurn; 
    }
    
    /**
     * If the user accidentally chooses wrong turn, then the distance needed increases by 5 miles. 
     */
    public void wrongTurn(){
        System.out.println("You took a wrong turn! You added 5 miles to your distance needed. Keep playing to return to the right track!"); 
        distanceNeeded += 5; 
        System.out.println("Distance Needed: " + distanceNeeded + " miles");
    }
    
    /**
     * If the user makes it to the end (distanceNeeded = 0) and their health isn't 0, then they reach the good ending. Their credentials are checked and they win if they have them all. 
     */
    public void goodEnding(){
        System.out.println();
        System.out.println("Congrats! You made it to the end, welcome to Washington D.C. Let's check your credentials:");
        int credentials = 0;
        for (String i: collections.keySet()) {
            System.out.println("Checking credentials...");
            if (collections.get(i) == true) {
                credentials ++; 
            }
        }
        if (credentials == 3) {
            System.out.println("Congratulations! You win! You escaped the zombies and helped create a cure!");
            System.out.println("Stats: \nHours Traveled: " + hoursTraveled + "\nDistance Traveled: " + distanceTraveled + " miles");
        }
        else {
            System.out.println("Oh no! You do not have all the credentials. Unfortunately, you die. Hope you had a fun game!");
            System.out.println("Stats: \nHours Traveled: " + hoursTraveled + "\nDistance Traveled: " + distanceTraveled + " miles");
        }
    }
    
    /**
     * If the user doesn't make it to the end and their health reaches 0, then they die and reach the bad ending. 
     */
    public void badEnding() {
        System.out.println();
        System.out.println("You're out of health! Zombies close in and you die :( Better luck next time.");
        System.out.println("Stats: \nHours Traveled: " + hoursTraveled + "\nDistance Traveled: " + distanceTraveled + " miles \nDistance Needed: " + distanceNeeded + " miles");
    }
    public static void main(String[] args) { 
        Journey newJourney = new Journey (25); 
        while (Health > 0 || distanceNeeded > 0) {
            if (Gas > 0) {
                int user_turn = newJourney.drive(); 
                int zombies = newJourney.zombieNumber(); 
                int rightTurn = newJourney.rightTurnNumber();
                if (user_turn == rightTurn) {
                    do {
                    int user_number  = newJourney.userActions(); 
                    if (user_number == zombies) {
                        newJourney.zombieAttack(); 
                        break;
                    }
                    if (user_number % 2 == 0 && user_number != zombies) {
                        newJourney.restock(); 
                        break;
                    }   
                    if (user_number % 2 == 1 && user_number != zombies) {
                        newJourney.rest(); 
                        break;
                    }  
                    if (user_number == 0) {
                        System.out.println("You chose to keep driving/walking. Good luck.");
                        break;
                    }
                    else {
                        System.out.println("You need to pick a number between 1 and 100. Please do so.");
                    }
                    } while (true);
                } 
                else {
                    newJourney.wrongTurn(); 
                }
            }
            else {
                System.out.println("You're out of gas. You have to walk until you reach a restock station. Good luck.");
                int user_turn = newJourney.walk();
                int zombies = newJourney.zombieNumber(); 
                int rightTurn = newJourney.rightTurnNumber();
                if (user_turn == rightTurn) {
                    do {
                    int user_number  = newJourney.userActions(); 
                    if (user_number == zombies) {
                        newJourney.zombieAttack(); 
                        break;
                    }
                    if (user_number % 2 == 0 && user_number != zombies) {
                        newJourney.restock(); 
                        break;
                    }   
                    if (user_number % 2 == 1 && user_number != zombies) {
                        newJourney.rest(); 
                        break;
                    }  
                    if (user_number == 0) {
                        System.out.println("You chose to keep driving/walking. Good luck.");
                        break;
                    }
                    else {
                        System.out.println("You need to pick a number between 1 and 100. Please do so.");
                    }
                    } while (true); 
                } 
                else {
                    newJourney.wrongTurn(); 
                }
            }
        }
        if (Health > 0 && distanceNeeded == 0) {
            newJourney.goodEnding();
        }
        else if (Health == 0 && distanceNeeded > 0){
            newJourney.badEnding();
        }
    }
}
