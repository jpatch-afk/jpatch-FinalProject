import java.lang.Math;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Hashtable; 
import java.util.Random; 

public class Journey extends Intro {
    //Add items to pick up: a key, an ID (drivers license?), 
    private int Gas;
    private int distanceTraveled;
    private int hoursTraveled;
    private static int distanceNeeded;
    private Scanner input; 
    private static ArrayList<String> essentials = new ArrayList<String>();
    private Hashtable<String, Boolean> collections = new Hashtable<String, Boolean>();
    private static ArrayList<Integer> healthIncrements = new ArrayList<Integer>(); 

    public Journey(int Gas) {
        super(100, 50, 100, 2);
        this.Gas = Gas;
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

    public int walk() {
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
            System.out.println("You have found a driver's license!")
            collections.out("Driver's License", true); 
        }
        else if (distanceNeeded == 10){
            System.out.println("You have found a journal!")
            collections.put("Journal", true); 
        }
        int turn = this.input.nextInt();
        this.input.nextLine();
        return turn;
    }

    public int drive() { 
        System.out.println("You're now driving!");
        distanceTraveled += 10;
        hoursTraveled ++;
        Gas -= 5;
        distanceNeeded = distanceNeeded - distanceTraveled; 
        System.out.println("Distance Traveled: " + distanceTraveled + " miles \n Hours Traveled: " + hoursTraveled + "\nGas: " + Gas + "Distance Needed: " + distanceNeeded + " miles");
        System.out.println("You have reached a fork in the road: left or right? Pick 1 for left and 2 for right.");
        if (distanceNeeded == 200){
            System.out.println("You have found a key!");
            collections.put("Key", true); 
        } 
        else if (distanceNeeded == 100){
            System.out.println("You have found a driver's license!")
            collections.out("Driver's License", true); 
        }
        else if (distanceNeeded == 10){
            System.out.println("You have found a journal!")
            collections.put("Journal", true); 
        }
        int turn = this.input.nextInt();
        this.input.nextLine();
        return turn;
    }

    public int userActions(){ 
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

    public void restock() { 
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

    public void rest() { 
        System.out.println("Choose either 0 hours, 1 hour, or 5 hours. \nIf you do not want to rest, pick 0 hours. \nIf you choose 1 hour, your health will not increase as much, but you will get back on the road sooner. \nIf you choose 5 hours, your health will increase more, but you will stay longer.");
        int rest_hours; 
        do {
            System.out.println("How long would you like to rest?")
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

    public void zombieAttack() {
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

    public int zombieNumber() {
        int zombies = (int)(Math.random() * (100 - 1)) + 1;
        return zombies; 
    }

    public int rightTurnNumber() {
        int rightTurn = (int)(Math.random() * (2 - 1)) + 1;
        return rightTurn; 
    }

    public void wrongTurn(){
        System.out.println("You took a wrong turn! You added 5 miles to your distance needed. Keep playing to return to the right track!"); 
        distanceNeeded += 5; 
        System.out.println("Distance Needed: " + distanceNeeded + " miles");
    }

    public void goodEnding(){
        System.out.println("Congrats! You made it to the end, welcome to Washington D.C. Let's check your credentials.");
        int credentials = 0;
        for (String i: collections.values()) {
            if (collection.containsKey(i) && collections.containsValue(true)) {
                credentials ++; 

            }
        }
        if (credentials == 3) {
            System.out.println("Congratulations! You win! You escaped the zombies and helped create a cure!");
        }
        else {
            System.out.println("Oh no! You do not have all the credentials. Unfortunately, you die. Hope you had a fun game!");
        }
    }

    public void badEnding() {
        System.out.println("You're out of health! Zombies close in and you die :( Better luck next time.");
        System.out.println("Stats: \n Hours Traveled: " + hoursTraveled + "\n Distance Traveled: " + distanceTraveled + " miles \n Distance Needed: " + distanceNeeded + " miles");
    }

    public static void main(String[] args) { 
        Journey newJourney = new Journey (25); 
        while (Health > 0 || distanceNeeded > 0) {
            if (Gas > 0) {
                int user_turn = newJourney.drive(); //kept track of the original distance: originalDistance = distanceNeeded;
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
                else {
                    newJourney.wrongTurn(); 
                }
            }
            else {
                System.out.println("You're out of gas. You have to walk until you reach a restock station. Good luck.");
                int user_turn = newJourney.walk();
                if (user_turn == rightTurn) {
                    int zombies = newJourney.zombieNumber(); 
                    int rightTurn = newJourney.rightTurnNumber();
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
        //Remember to add JavaDoc comments!!!
    }
}
