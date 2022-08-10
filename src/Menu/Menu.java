package Menu;
import Characters.Character;
import Combat.Combat;
import Teams.Teams;


import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static void menu() throws InterruptedException {

        Scanner sn = new Scanner(System.in);

        boolean salir = false;

        int opcion; //Guardaremos la opcion del usuario
        int Equipo1 = 0;
        int Equipo2 = 0;
        int teamSize = 0;
        Combat combat = new Combat();

        while (!salir) {

            System.out.println("1. Play with random teams");
            System.out.println("2. Import teams");
            System.out.println("3. Quit");

            System.out.println("Escribe una de las opciones");
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
                    for (int i = 0; i < team1.size(); i++) {
                        System.out.println(team1.get(i).toString());
                    }
                    System.out.println("*****************************************");
                    for (int i = 0; i < team2.size(); i++) {
                        System.out.println(team2.get(i).toString());
                    }
                    System.out.println("*****************************************");
                    System.out.println("Press Enter if you are ready.");
                    sn.nextInt();
                    combat.battle(team1,team2);
                    break;
                case 2:
                    System.out.println("2. Selecciona tus equipos");

                    while (Equipo1 == 0) {

                        System.out.println("1. XXXX 1");
                        System.out.println("2. XXXX 2");
                        System.out.println("3. XXXX 3");
                        System.out.println("4. XXXX 4");

                        System.out.println("Elige el equipo1");
                        Equipo1 = sn.nextInt();

                    }

                    while (Equipo2 == 0) {

                        System.out.println("1. XXXX 1");
                        System.out.println("2. XXXX 2");
                        System.out.println("3. XXXX 3");
                        System.out.println("4. XXXX 4");

                        System.out.println("Elige el equipo2");
                        Equipo2 = sn.nextInt();
                    }

                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Debes seleccionar una opcion");
            }


        }


    }


}
