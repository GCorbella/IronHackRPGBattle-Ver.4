package Combat;

import Characters.Warrior;
import Characters.Wizard;

import java.util.Random;


public class RandomGenerator {

    //Stat restrictions for Characters
    private static final int HP_WARRIOR_MIN = 100;
    private static final int HP_WARRIOR_MAX = 200;
    private static final int HP_WIZARD_MIN = 50;
    private static final int HP_WIZARD_MAX = 100;
    private static final int STAMINA_MIN = 10;
    private static final int STAMINA_MAX = 50;
    private static final int STRENGTH_MIN = 1;
    private static final int MANA_MIN = 10;
    private static final int MANA_MAX = 50;
    private static final int STRENGTH_MAX = 10;
    private static final int INTELLIGENCE_MIN = 1;
    private static final int INTELLIGENCE_MAX = 50;


    private static final String[] WARRIOR_NAME = {"The Boulder",
            "Ragnar Lodbrok",
            "Aquiles",
            "Aragon",
            "Lurtz",
            "El cid",
            "Juana de arco",
            "Théoden",
            "Faramir",
            "Éomer",
            "Éowyn",


    };
    private static final String[] WIZARD_NAME = {
            "Madame curie",
            "Merlin",
            "Gandalf",
            "Sauron",
            "Voldemor",
            "Ragadast",
            "Alatar",
            "Pallando",
            "Rey Brujo",
            "Yavanna",

    };



    public static Warrior getRandomWarrior() {
        return new Warrior(WARRIOR_NAME[new Random().nextInt(WARRIOR_NAME.length)],
                new Random().nextInt(HP_WARRIOR_MIN + 1) + HP_WARRIOR_MAX - HP_WARRIOR_MIN,
                new Random().nextInt(STAMINA_MIN + 1) + STAMINA_MAX - STAMINA_MIN,
                new Random().nextInt(STRENGTH_MIN + 1) + STRENGTH_MAX - STRENGTH_MIN);
    }

    public static Wizard getRandomWizard() {
        return new Wizard(WIZARD_NAME[new Random().nextInt(WARRIOR_NAME.length)],
                new Random().nextInt(HP_WIZARD_MIN + 1) + HP_WIZARD_MAX - HP_WIZARD_MIN,
                new Random().nextInt(MANA_MIN + 1) + MANA_MAX - MANA_MIN,
                new Random().nextInt(INTELLIGENCE_MIN + 1) + INTELLIGENCE_MAX - INTELLIGENCE_MIN);

    }
    public static int getHpWarriorMin() {
        return HP_WARRIOR_MIN;
    }

    public static int getHpWarriorMax() {
        return HP_WARRIOR_MAX;
    }

    public static int getStaminaMin() {
        return STAMINA_MIN;
    }

    public static int getStaminaMax() {
        return STAMINA_MAX;
    }

    public static int getStrengthMin() {
        return STRENGTH_MIN;
    }
    public static int getStrengthMax() {
        return STRENGTH_MAX;
    }
    public static int getHpWizardMin() {
        return HP_WIZARD_MIN;
    }

    public static int getHpWizardMax() {
        return HP_WIZARD_MAX;
    }

    public static int getManaMin() {
        return MANA_MIN;
    }

    public static int getManaMax() {
        return MANA_MAX;
    }


}