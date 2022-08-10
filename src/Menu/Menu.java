package Menu;
import java.util.Scanner;

public class Menu {

    public static void menu(String[] args) {

        Scanner sn = new Scanner(System.in);

        boolean salir = false;

        int opcion; //Guardaremos la opcion del usuario
        int Equipo1 = 0;
        int Equipo2 = 0;

        while (!salir) {

            System.out.println("1. Jugar con equipos random");
            System.out.println("2. Selecciona tus equipos");
            System.out.println("3. Salir");

            System.out.println("Escribe una de las opciones");
            opcion = sn.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("1. Jugar con equipos random");
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
