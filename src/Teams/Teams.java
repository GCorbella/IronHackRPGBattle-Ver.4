package Teams;
import Characters.Character;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static Teams.RandomGenerator.getRandomWarrior;
import static Teams.RandomGenerator.getRandomWizard;

public class Teams {
    public static ArrayList<Character> createNewTeam(int numb) {
        ArrayList<Character> newTeam = new ArrayList<>();

        for (int i = 0; i <= numb; i++) {
            int dice = (int) (Math.random() * 1) + 1;
            if (dice == 1) {
                newTeam.add(getRandomWarrior());
            } else {
                newTeam.add(getRandomWizard());
            }
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


