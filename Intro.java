import java.util.Scanner;

public class Intro {
    Scanner input; 
    protected static int Food;
    protected static int Bandages;
    protected static int Health;
    protected static int Water;

    public Intro(int Food, int Bandages, int Health, int Water) {
        this.input = new Scanner(System.in); 
        this.Food = Food;
        this.Bandages = Bandages;
        this.Health = Health;
        this.Water = Water;
    }

    public void Introduction(int Food, int Bandages, int Health, int Water) {
        System.out.println("What is your name, traveler?");
        String protag = this.input.nextLine();
        System.out.println("Welcome " + protag + "!\n You're right on time to stop the zombie apocalypse.");
        System.out.println("Starting supplies: \n Food: " + Food + " Rations \n Bandages: " + Bandages + " Rolls \n Water: " + Water + " Liters");
        System.out.println("Health: " + Health + "%");
        System.out.println("Objective: Make it to Washington, D.C. Zombie Laboratory (WZL) \n Current Location: Abandoned New York City");
        System.out.println(" Current Distance to WZL: 230 miles ");
        //Add more worldbuilding 
        //pick a car so I can have more realistic gas  

    }

    public static void main (String[] args) {
        Intro newGame = new Intro(100, 50, 100, 2);
        newGame.Introduction(Food, Bandages, Health, Water);
    }
}