package Teams;
import Characters.Character;

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
            }if (dice > 5) {
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
            }if (dice > 5) {
                newTeam.add(getRandomWizard());
            }
            newTeam.get(i).setName(newTeam.get(i).getName() + " of Team 2");
        }
        return newTeam;
    }


public static  Character[] importATeam(String teamName){
        File team = new File(teamName + ".csv");
        Character [] importedTeam = new Character[5];
        try{
            Scanner inputFile = new Scanner(team);
            inputFile.useDelimiter(",");
            while (inputFile.hasNext()){

            }
            inputFile.close();
        }catch (FileNotFoundException e){
            System.out.println("Check file");
        }
    return importedTeam;
    }
}


