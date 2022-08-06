package Combat;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Combat {
    //functioning variables
    Random random = new Random();
    Scanner sc = new Scanner(System.in);
    //content variables
    ArrayList<Character> team1;
    String team1Name = Menu.getTeam1Name;
    String team2Name = Menu.getTeam2Name;
    ArrayList<Character> team2;
    ArrayList<Character> corpses;
    String graveyard = "The graveyard contains the corpses of the next fighters:\n";

    //principal combat method that implements all the other methods
    public void combat(){
        while (team1.size() != 0 || team2.size() != 0){
            boolean run = false;
            fight(team1.get(random.nextInt(0,team1.size()-1)), team2.get(random.nextInt(0,team2.size()-1)));
            System.out.println("The combat is over.");
            while (run == false) {
                System.out.println("""
                        What do you want to do?
                        1.- Next combat.
                        2.- Visit the graveyard.""");
                String option = sc.nextLine();
                if (option == "1"){
                    run = true;
                }
                else if (option == "2") {
                    showGraveyard();
                }
                else {
                    System.out.println("Insert only 1 or 2, please. =)");
                }
            }
        }
        if(team1.isEmpty()){
            System.out.println("TEAM 2 HAVE WON THE BATTLE!");
            System.out.println("These are the names of the brave survivors:");
            for (int i = 0; i < team2.size(); i++) {
                System.out.println(team2.get(i).getName());
            }
            System.out.println("Farewell fighters and may fortune be with you!");
        } else {
            System.out.println("TEAM 1 HAVE WON THE BATTLE!");
            System.out.println("These are the names of the brave survivors:");
            for (int i = 0; i < team1.size(); i++) {
                System.out.println(team1.get(i).getName());
            }
            System.out.println("Farewell fighters and may fortune be with you!");
        }
    }

    //fight method that confront une fighter vs another
    public void fight(Character fighter1, Character fighter2){
        while (fighter1.getHp() >= 0 || fighter2.getHp() >= 0) {
            int[] damageF1 = fighter1.attack();
            int[] damageF2 = fighter2.attack();
            System.out.println("The fighters attack each other!");
            System.out.println(fighter1.getName() + " deals " + damageF1[0] + "damage.");
            System.out.println(fighter2.getName() + " deals " + damageF2[0] + "damage.");
            fighter1.setHp(fighter1.getHp() - damageF2[0]);
            fighter2.setHp(fighter2.getHp() - damageF1[0]);
            Thread.sleep(2000);
        }
        if (fighter1.getHp <= 0){
            graveyard += kill(fighter1, fighter2);
        }
        else {
            graveyard += kill(fighter2, fighter1);
        }
    }
    public String kill(Character dead, Character killer){
        String death = dead.getName() + ", who was killed by " + killer.getName() + "\n";
        if(team1.contains(dead)){
            team1.remove(dead);
            corpses.add(dead);
            dead.setAlive(false);
        } else {
            team2.remove(dead);
            corpses.add(dead);
            dead.setAlive(false);
        }
        System.out.println(dead.getName() + ", was killed by " + killer.getName());
        System.out.println(killer.getName() + "is the winner!");
        return death;
    }
    public void showGraveyard(){
        System.out.println(graveyard);
    }

    public void setTeam1(ArrayList<Character> team1){
        this.team1 = team1;
    }

    public void setTeam2(ArrayList<Character> team2){
        this.team2 = team2;
    }
}
