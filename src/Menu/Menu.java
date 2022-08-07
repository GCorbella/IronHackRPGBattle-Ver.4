package Menu;
import java.util.Scanner;

public class Menu {

    public void menu(String[] args) {

        Scanner sn = new Scanner(System.in);

        boolean salir = false;

        int opcion; //Guardaremos la opcion del usuario

        while (!salir) {

            System.out.println("1. Jugar con equipos random");
            System.out.println("2. Selecciona tus equipos");
            System.out.println("4. Salir");

            System.out.println("Escribe una de las opciones");
            opcion = sn.nextInt();

            switch (opcion) {
                case 1 -> System.out.println("Jugaras con equipos random");
                case 2 -> System.out.println("Has seleccionado la opcion 2");
                case 3 -> System.out.println("Has seleccionado la opcion 3");
                case 4 -> salir = true;
                default -> System.out.println("Debes seleccionar una opcion");
            }

        }

    }
}
