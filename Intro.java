import java.util.Scanner;

/**
 * Intro Class
 */
public class Intro {
    Scanner input; 
    protected static int Food;
    protected static int Bandages;
    protected static int Health;
    protected static int Water;

    /**
     * Constructor 
     * @param Food
     * @param Bandages
     * @param Health
     * @param Water
     */
    public Intro(int Food, int Bandages, int Health, int Water) {
        this.input = new Scanner(System.in); 
        Intro.Food = Food;
        Intro.Bandages = Bandages;
        Intro.Health = Health;
        Intro.Water = Water;
    }

    /**
     * Introduction: provides worldbuilding and objective of the user
     * @param Food
     * @param Bandages
     * @param Health
     * @param Water
     */
    public void Introduction(int Food, int Bandages, int Health, int Water) {
        System.out.println("What is your name, traveler?");
        String protag = this.input.nextLine();
        System.out.println("Welcome " + protag + "!\n You're right on time to stop the zombie apocalypse.");
        System.out.println("Starting supplies: \nFood: " + Food + " Rations \nBandages: " + Bandages + " Rolls \nWater: " + Water + " Liters");
        System.out.println("Health: " + Health + "%");
        System.out.println("Objective: Make it to Washington, D.C. Zombie Laboratory (WZL) \n Current Location: New York City");
        System.out.println(" Current Distance to WZL: 230 miles "); 
    }
    public static void main (String[] args) {
        Intro newGame = new Intro(100, 50, 100, 2);
        newGame.Introduction(Food, Bandages, Health, Water);
    }
}
