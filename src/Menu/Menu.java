package Menu;
import Characters.Character;
import Combat.Combat;
import Teams.Teams;


import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static void menu() throws InterruptedException {

        Scanner sn = new Scanner(System.in);

        boolean salir = false;

        int opcion; //Will save the user option
        int teamSize = 0;
        Combat combat = new Combat();

        while (!salir) {
            System.out.println("***************************************************************************************************");
            System.out.println("""
                     ____  ____   ____   ____        _   _   _        ____  _                 _       _            \s
                    |  _ \\|  _ \\ / ___| | __ )  __ _| |_| |_| | ___  / ___|(_)_ __ ___  _   _| | __ _| |_ ___  _ __\s
                    | |_) | |_) | |  _  |  _ \\ / _` | __| __| |/ _ \\ \\___ \\| | '_ ` _ \\| | | | |/ _` | __/ _ \\| '__|
                    |  _ <|  __/| |_| | | |_) | (_| | |_| |_| |  __/  ___) | | | | | | | |_| | | (_| | || (_) | |  \s
                    |_| \\_\\_|    \\____| |____/ \\__,_|\\__|\\__|_|\\___| |____/|_|_| |_| |_|\\__,_|_|\\__,_|\\__\\___/|_|  \s
                                                                                                                   \s""");
            System.out.println("***************************************************************************************************");
            System.out.println("1. Play with random teams");
            System.out.println("2. Import teams");
            System.out.println("3. Quit");
            System.out.println("__________________________________________");
            System.out.println("Select one of the options above.");
            opcion = sn.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("PLAYING WITH RANDOM TEAMS");
                    System.out.println("Which size should be the teams?");
                    teamSize = sn.nextInt();
                    ArrayList<Character> team1 = Teams.createNewTeam1(teamSize);
                    ArrayList<Character> team2 = Teams.createNewTeam2(teamSize);
                    combat.setTeam1(team1);
                    combat.setTeam2(team2);
                    System.out.println("*****************************************");
                    for (Character value : team1) {
                        System.out.println(value.toString());
                    }
                    System.out.println("*****************************************");
                    for (Character character : team2) {
                        System.out.println(character.toString());
                    }
                    System.out.println("*****************************************");
                    System.out.println("""
                            Do you want to make a:
                            1.- Fast battle.
                            2.- Normal battle""");
                    int election = sn.nextInt();
                    boolean nocombat = true;
                    while (nocombat) {
                        if (election == 1) {
                            nocombat = false;
                            combat.fastBattle(team1, team2);
                        } else if (election == 2) {
                            nocombat = false;
                            combat.battle(team1, team2);
                        } else {
                            System.out.println("Enter only f (fast battle) or n (normal battle).");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Write team 1 rute.");
                    sn.nextLine();
                    File rute1 = new File(sn.nextLine());
                    team1 = Teams.importPartyCsv(rute1);
                    combat.setTeam1(team1);
                    System.out.println("Which size should be the other team?");
                    teamSize = sn.nextInt();
                    team2 = Teams.createNewTeam2(teamSize);
                    combat.setTeam1(team1);
                    combat.setTeam2(team2);
                    System.out.println("*****************************************");
                    for (Character value : team1) {
                        System.out.println(value.toString());
                    }
                    System.out.println("*****************************************");
                    for (Character character : team2) {
                        System.out.println(character.toString());
                    }
                    System.out.println("*****************************************");
                    System.out.println("""
                            Do you want to make a:
                            1.- Fast battle.
                            2.- Normal battle""");
                    int electionCsv = sn.nextInt();
                    boolean noCombat = true;
                    while (noCombat) {
                        if (electionCsv == 1) {
                            noCombat = false;
                            combat.fastBattle(team1, team2);
                        } else if (electionCsv == 2) {
                            noCombat = false;
                            combat.battle(team1, team2);
                        } else {
                            System.out.println("Enter only f (fast battle) or n (normal battle).");
                        }
                    }
                    break;

                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("You must select a valid option.");
            }
        }
    }
}
