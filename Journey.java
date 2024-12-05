import java.lang.Math;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Hashtable; 

public class Journey extends Intro {
    //Add items to pick up
    //Add NPCs?
    private int Gas;
    private int distanceTraveled;
    private int hoursTraveled;
    private static int distanceNeeded;
    private Scanner input; 
    private int zombieAttack;
    private int rightTurn; 
    private static ArrayList<String> essentials = new ArrayList<String>();
    private Hashtable<String, Boolean> collections = new Hashtable<String, Boolean>();

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
    }

    //seperate method for wrong turn? 

    public int drive() { //break up this method? make it able to return turn? 
        System.out.println("You're now driving!");
        if (Gas > 0) {
            distanceTraveled ++;
            hoursTraveled ++;
            Gas --;
            System.out.println("Distance Traveled: " + distanceTraveled + "\n Hours Traveled: " + hoursTraveled + "\nGas: " + Gas);
            System.out.println("You have reached a fork in the road: left or right?"); //randomize the amount of distance needed added, go through drive again and let them choose again until they're back on the right track
            rightTurn = (int)(Math.random() * 2);
            int turn = this.input.nextInt();
            this.input.nextLine();
            if (turn == rightTurn) {
                System.out.println("Please pick a number between 1 and 100. What you choose will be your fate.");
                zombieAttack = (int)(Math.random() * (100 - 1)) + 1;
                int user_number = this.input.nextInt();
                this.input.nextLine(); 
                if (user_number == zombieAttack) {
                    System.out.println("You've been attacked by zombies! Try to save yourself!");
                    return user_number;
                }
                if (user_number % 2 == 0 && user_number != zombieAttack) {
                    System.out.println("You've reached a restock station!");
                    return user_number; 
                }
                if (user_number % 2 == 1 && user_number != zombieAttack) {
                    System.out.println("You've reached a rest station!");
                    return user_number; 
                }  
                else {
                    throw new RuntimeException("You need to pick a number between 1 and 100. Please do so.");
                }
            } 
            else {
                //add a different method for wrong turn? add the return turn to the main method to call with an additional loop through drive? then wrong turn 
            }
    }
        else {
            System.out.println("You're out of gas. You have walk until you reach a restock station. Good luck.");
            System.out.println("Please pick a number between 1 and 100. What you choose will be your fate.");
            int user_number = this.input.nextInt();
            this.input.nextLine(); 
        }
        //Add grabbing objects after reaching specific distances, and whether they are on the right track
    }

    public void restock(String item) { //Randomized stops at abandoned gas stations 
        System.out.println(essentials);
        for (int i = 0; i < essentials.size(); i++) {
            System.out.println(essentials.get(i));
        }
        System.out.println("Which items would you like to restock?");
        if (essentials.contains(item)) {
            if (item == "Food"){
                Food += 20;
                System.out.println("Food restocked! \nFood: " + Food);
            }
            if (item == "Water"){
                Water += 2;
                System.out.println("Water restocked! \nWater: " + Water);
            }
            if (item == "Gas"){
                Gas += 20; 
                System.out.println("Gas restocked! \nGas: " + Gas);
            }
            if (item == "Bandages"){
                Bandages += 20;
                System.out.println("Bandages restocked! \nBandages: " + Bandages);
            }
        }
        else {
            throw new RuntimeException("You cannot restock on this item. Check your essentials.");
        }
    }

    public void rest() { 
        System.out.println("How long would you like to rest? Choose either 1 hour or 5 hours. \n If you choose 1 hour, your health will not increase as much, but you will get back on the road sooner. \n If you choose 5 hours, your health will increase more, but you will stay longer.");
        int rest_hours = this.input.nextInt();
        this.input.nextLine();
        if (rest_hours == 1) {
            hoursTraveled ++; 
            if (Health < 95) {
                Health += 5; 
                System.out.println("Health: " + Health + "\n Hours Traveled: " + hoursTraveled);
            }
            else {
                System.out.println("You cannot exceed 100% health! Automatically restoring health to 100% \n Health: "+ Health + "\nHours Traveled: " + hoursTraveled);
            } 
        } 
        if (rest_hours == 5) {
            hoursTraveled += 5; 
            if (Health < 85) {
                Health += 15; 
                System.out.println("Health: " + Health + "\n Hours Traveled: " + hoursTraveled);
            }
            else {
                System.out.println("You cannot exceed 100% health! Automatically restoring health to 100% \n Health: "+ Health + "\nHours Traveled: " + hoursTraveled);
            } 
        }
        else {
            throw new RuntimeException("Please choose either 1 or 5 hours of rest.");
        }
    }

    public void wrongTurn(){
        System.out.println("You took a wrong turn! You added 5 miles to your distance needed. Keep playing to return to the right track!");
        distanceNeeded += 5; 
        System.out.println("Distance Needed: " + distanceNeeded);
    }

    //add zombieAttack method, decreases health and bandages, randomize impact either 10%, 30% or 50% delpletion of health

    //add outro: if health is depleted and didn't make it to location; if did make to location w/o objects, and made it to location w/ objects 

    public void goodEnding(){
        System.out.println("Congrats! You made it to the end, let's check your credentials.");
        //add checking the objects gathered: loop? 
    }

    public void badEnding() {
        System.out.println("You're out of health! Zombies close in and devour you. Better luck next time.");
        System.out.println("Stats: \n Hours Traveled: " + hoursTraveled + "\n Distance Traveled: " + distanceTraveled + "\n Distance Needed: " + distanceNeeded);
    }

    public int getGas() {  //should i get rid of these? print out attributes at the beginning of drive 
        return Gas; 
    }

    public int getDistanceTraveled() {
        return distanceTraveled; 
    }

    public int getDistanceNeeded(){
        return distanceNeeded;
    }

    public int getHoursTraveled(){
        return hoursTraveled;
    }

    public static void main(String[] args) {
    //loop that has the condition of health 
        Journey newJourney = new Journey (25);
        while (Health > 0 || distanceNeeded > 0) {
            newJourney.drive();
        }
        if (Health > 0 && distanceNeeded == 0) {

        }
        else if (Health == 0 && distanceNeeded > 0){

        }
        
        //do/while loop through drive, call restock/rest whenever possible through the returned user_number 
       
        //Remember to add JavaDoc comments!!!

        //add scanner prompts to ask user what they want to do, maybe they want to keep driving instead of restocking/resting or check reserves 

        //add when health ends 
    }
}