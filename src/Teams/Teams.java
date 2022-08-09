package Teams;
import Characters.Character;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Teams {

public static Character[] createNewTeam(){

    Character[] newTeam = new Character[5];
    for (int i=0; i< newTeam().length;i++){
        newTeam[i]= new Character;

        return createNewTeam(newTeam);
    }

public static  Character[] importATeam(){
        File team = new File("team.csv");
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
    }
  }

}
