package Teams;
import Characters.Character;
import Characters.Warrior;
import Characters.Wizard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static Teams.RandomGenerator.getRandomWarrior;
import static Teams.RandomGenerator.getRandomWizard;

public class Teams {
    public static ArrayList<Character> createNewTeam1(int numb) {
        ArrayList<Character> newTeam = new ArrayList<>();

        for (int i = 0; i <= numb - 1; i++) {
            int dice = (int) (Math.random() * 10);
            if (dice <= 5) {
                newTeam.add(getRandomWarrior());
            }
            if (dice > 5) {
                newTeam.add(getRandomWizard());
            }
            newTeam.get(i).setName(newTeam.get(i).getName() + " of Team 1");
        }
        return newTeam;
    }

    public static ArrayList<Character> createNewTeam2(int numb) {
        ArrayList<Character> newTeam = new ArrayList<>();

        for (int i = 0; i <= numb - 1; i++) {
            int dice = (int) (Math.random() * 10);
            if (dice <= 5) {
                newTeam.add(getRandomWarrior());
            }
            if (dice > 5) {
                newTeam.add(getRandomWizard());
            }
            newTeam.get(i).setName(newTeam.get(i).getName() + " of Team 2");
        }
        return newTeam;
    }


    public static ArrayList<Character> importPartyCsv(File csvFile) {
        try {
            Scanner scannerCsv = new Scanner(csvFile);
            ArrayList<Character> partyArray = new ArrayList<>();
            //Skips the first line of the CSV with the field names
            scannerCsv.nextLine();
            //The following will be repeated for each line of data
            while (scannerCsv.hasNextLine()) {
                //Gets all the Character data and separates them into a String[] for each data
                String stringCharacter = scannerCsv.nextLine();
                String[] dataCharacter = stringCharacter.split(",");

                if (dataCharacter[4].equals("0")) {   //If it's a Warrior
                    //Creates a Warrior with the stats obtained and add them to the Character's Array
                    Warrior warrior = new Warrior(dataCharacter[0], Integer.parseInt(dataCharacter[1]),
                            Integer.parseInt(dataCharacter[2]), Integer.parseInt(dataCharacter[3]));
                    partyArray.add(warrior);
                } else {   //If it's a Wizard
                    //Creates a Wizard with the stats obtained and add them to the Character's Array
                    Wizard wizard = new Wizard(dataCharacter[0], Integer.parseInt(dataCharacter[1]),
                            Integer.parseInt(dataCharacter[2]), Integer.parseInt(dataCharacter[3]));
                    partyArray.add(wizard);
                }
            }
            //Closes the Scanner and returns the Party
            scannerCsv.close();
            return partyArray;

        } catch (FileNotFoundException e) {   //If the file isn't found, it prints an error message and returns null
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }
}


