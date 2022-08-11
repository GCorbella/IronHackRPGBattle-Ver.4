package Combat;

import Characters.Character;
import Characters.Warrior;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Combat {
    //functioning variables
    Random random = new Random();
    Scanner sc = new Scanner(System.in);
    //content variables
    ArrayList<Character> team1;
    ArrayList<Character> savedTeam1;
    //String team1Name = Menu.getTeam1Name;
    ArrayList<Character> team2;
    ArrayList<Character> savedTeam2;
    //String team2Name = Menu.getTeam2Name;
    ArrayList<Character> corpses = new ArrayList<>();
    String graveyard = "THE GRAVEYARD CONTAINS THE CORPSES OF THE NEXT FIGHTERS:\n";

    //principal combat method that implements all the other methods
    public void battle(ArrayList<Character> team1, ArrayList<Character> team2) throws InterruptedException {
        boolean noWinner = true;
        while (noWinner){
            boolean run = false;
            fight(team1.get(random.nextInt(0,team1.size())), team2.get(random.nextInt(0,team2.size())));
            System.out.println("The combat is over.");
            while (run == false) {
                System.out.println("""
                        ----------------------------------------------
                        What do you want to do?
                        1.- Next combat.
                        2.- Show teams state.
                        3.- Visit the graveyard.
                        ----------------------------------------------""");
                String option = sc.nextLine();
                switch (option) {
                    case "1" -> run = true;
                    case "2" -> {
                        System.out.println("*****************************************");
                        for (Character character : team1) {
                            System.out.println(character.toString());
                        }
                        System.out.println("*****************************************");
                        for (Character character : team2) {
                            System.out.println(character.toString());
                        }
                        System.out.println("*****************************************");
                    }
                    case "3" -> showGraveyard();
                    default -> System.out.println("Insert only 1 or 2, please. =)");
                }
            }
            if (team1.isEmpty()){
                noWinner = false;
            } else if (team2.isEmpty()) {
                noWinner = false;
            }
        }
        if(team1.isEmpty()){
           victory(team2, savedTeam2);
        } else {
            victory(team1, savedTeam1);
        }
    }

    public void fastBattle(ArrayList<Character> team1, ArrayList<Character> team2) throws InterruptedException {
        boolean noWinner = true;
        while (noWinner){
            fastFight(team1.get(random.nextInt(0,team1.size())), team2.get(random.nextInt(0,team2.size())));
            System.out.println("The combat is over.");
            if (team1.isEmpty()){
                noWinner = false;
            } else if (team2.isEmpty()) {
                noWinner = false;
            }
        }
        if(team1.isEmpty()){
            showGraveyard();
            victory(team2, savedTeam2);
        } else {
            showGraveyard();
            victory(team1, savedTeam1);
        }
    }

    //fight method that confront une fighter vs another
    public void fight(Character fighter1, Character fighter2) throws InterruptedException {
        boolean noDeads = false;
        while (noDeads == false) {
            int[] damageF1 = fighter1.attack();
            int[] damageF2 = fighter2.attack();
            System.out.println("The fighters attack each other!");
            System.out.println("----------------------------------------------");
            System.out.println(fighter1.getName() + " deals " + damageF1[0] + " damage.");
            System.out.println(fighter2.getName() + " deals " + damageF2[0] + " damage.");
            fighter1.setHp(fighter1.getHp() - damageF2[0]);
            fighter2.setHp(fighter2.getHp() - damageF1[0]);
            System.out.println("==============================================");
            Thread.sleep(1000);
            if (fighter1.getHp() <= 0){
                noDeads = true;
                kill(fighter1, fighter2);
            }
            if (fighter2.getHp() <= 0) {
                noDeads = true;
                kill(fighter2, fighter1);
            }
        }
    }

    public void fastFight(Character fighter1, Character fighter2) throws InterruptedException {
        boolean noDeads = false;
        while (noDeads == false) {
            int[] damageF1 = fighter1.attack();
            int[] damageF2 = fighter2.attack();
            System.out.println("The fighters attack each other!");
            System.out.println("----------------------------------------------");
            System.out.println(fighter1.getName() + " deals " + damageF1[0] + " damage.");
            System.out.println(fighter2.getName() + " deals " + damageF2[0] + " damage.");
            fighter1.setHp(fighter1.getHp() - damageF2[0]);
            fighter2.setHp(fighter2.getHp() - damageF1[0]);
            System.out.println("==============================================");
            if (fighter1.getHp() <= 0){
                noDeads = true;
                kill(fighter1, fighter2);
            }
            if (fighter2.getHp() <= 0) {
                noDeads = true;
                kill(fighter2, fighter1);
            }
        }
    }

    public void kill(Character dead, Character killer){
        graveyard += dead.getName() + ", who was killed by " + killer.getName() + "\n";
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
    }
    public void showGraveyard(){
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("""
                      ,-=-.       ______     _
                     /  +  \\     />----->  _|1|_
                     | ~~~ |    // -/- /  |_ H _|
                     |R.I.P|   //  /  /     |S|
                \\vV,,|_____|V,//_____/VvV,v,|_|/,,vhjwv/,""");
        System.out.println(graveyard);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
    }

    public void victory(ArrayList<Character> winners, ArrayList<Character> winnersFullTeam){
        System.out.println("*****************************************");
        System.out.println("THE BATTLE IS OVER!");
        System.out.println("*****************************************");
        System.out.println("These are the names of the brave survivors:");
        System.out.println("-------------------------------------------");
        for (int i = 0; i < winners.size(); i++) {
            System.out.println(winners.get(i).getName());
        }
        System.out.println("*****************************************");
        //System.out.println("Do you want to save this fighters team? y/n");
        //String option = sc.nextLine();
        System.out.println("Farewell fighters and may fortune be with you!");
        System.out.println("""
                                                 /\\
                                                /  \\
                                               |    |
                                             --:'''':--
                                               :'_' :
                                               _:"":\\___
                                ' '      ____.' :::     '._
                               . *=====<<=)           \\    :
                                .  '      '-'-'\\_      /'._.'
                                                 \\====:_ ""
                                                .'     \\\\
                                               :       :
                                              /   :    \\
                                             :   .      '.
                             ,. _            :  : :      :
                          '-'    ).          :__:-:__.;--'
                        (        '  )        '-'   '-'
                     ( -   .00.   - _
                    (    .'  _ )     )
                    '-  ()_.\\,\\,   -
                    ===========================================================
                    ___________________________________________________________""");
        System.out.println("Press Enter to return to the menu.");
        sc.nextLine();
    }

    public void setTeam1(ArrayList<Character> team1){
        this.team1 = team1;
        this.savedTeam1 = team1;
    }

    public void setTeam2(ArrayList<Character> team2){
        this.team2 = team2;
        this.savedTeam2 = team2;
    }

    //Method in progress, unfinished
    /*public void exportTeamCSV(ArrayList<Character> exportedTeam, String exportedTeamName) throws IOException {
        FileWriter writer = new FileWriter(exportedTeamName + ".csv", true);

        writer.write("Exported winner team");
        for (int i = 0; i < exportedTeam.size(); i++) {
            if (exportedTeam.get(i).getClassName() == Warrior)
            exportedTeam.get(i).toCSV();
            writer.write("Age: " + employees[i].getAge() + ", ");
            writer.write("Salary: " + employees[i].getSalary() + "\n");
        }
        writer.close();
    }*/
}
