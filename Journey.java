import java.lang.Math;
import java.util.Scanner;
import java.util.ArrayList; 

public class Journey extends Intro {
    //Add wrong turns/randomize --> add miles to distanceNeeded
    //Add items to pick up
    //Add NPCs?
    int Gas;
    int distanceTraveled;
    int hoursTraveled;
    int distanceNeeded;
    Scanner input; 
    int zombieAttack;
    int rightTurn; 
    boolean onTrack; 
    static ArrayList<String> essentials = new ArrayList<String>();

    public Journey(int Gas) {
        super(100, 50, 100, 2);
        this.Gas = Gas;
        distanceTraveled = 0;
        distanceNeeded = 230;
        hoursTraveled = 0;
        this.input = new Scanner(System.in);
        zombieAttack = (int)(Math.random() * 100);
        rightTurn = (int)(Math.random() * 2);
        onTrack = true; 
        essentials.add("Food");
        essentials.add("Gas");
        essentials.add("Water");
        essentials.add("Bandages"); //make this a Hashtable instead? 
    }

    public int drive() { 
        System.out.println("You're now driving!");
        if (Gas > 0) {
            distanceTraveled ++;
            hoursTraveled ++;
            Gas --;
            System.out.println("Distance Traveled: " + distanceTraveled + "\n Hours Traveled: " + hoursTraveled + "\nGas: " + Gas);
        } 
        else {
            throw new RuntimeException("You're out of gas. You have walk until you reach a restock station. Good luck.");
        }
        System.out.println("You have reached a fork in the road: left or right?"); //randomize the right answer, randomize the amount of distance needed added, go through drive again and let them choose again until they're back on the right track
        System.out.println("Please pick a number between 1 and 100. What you choose will be your fate.");
        int user_number = this.input.nextInt();
        this.input.nextLine(); 
        if (user_number == zombieAttack) {
            System.out.println("You've been attacked by zombies! Try to save yourself!");

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

        //Add grabbing objects after reaching specific distances, and whether they are on the right track
        
    }

    public void restock(String item) { //Randomized stops at abandoned gas stations 
        System.out.println(essentials);
        //Print out Food, Water, Gas, and Bandages attributes 
        System.out.println("Which items would you like to restock?");
        if (essentials.contains(item)) {

        }
        else {
            throw new RuntimeException("You cannot restock on this item. Check your essentials.");
        }
    }

    public void rest() { //Restores health, decreases bandages reserves if injured 
        System.out.println("How long would you like to rest? Choose either 1 hour or 5 hours. \n If you choose 1 hour, your health will not increase as much, but you will get back on the road sooner. \n If you choose 5 hours, your health will increase more, but you will stay longer.");
        int rest_hours = this.input.nextInt();
        this.input.nextLine();
        if (rest_hours == 1) {
            //add health + hours traveled
        } 
        if (rest_hours == 5) {
            //add health + hours traveled
        }
        else {
            throw new RuntimeException("Please choose either 1 or 5 hours of rest.");
        }
    }

    public int getGas() {
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
        while (Health > 0) {
            newJourney.drive();
        }
        
        //do/while loop through drive, call restock/rest whenever possible through the returned user_number 
       
        //Remember to add JavaDoc comments!!!
    }


}
