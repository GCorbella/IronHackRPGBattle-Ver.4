package Characters;
public class Wizard extends Character {


    private int mana;
    private int intelligence;


    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        setMana(mana);
        setIntelligence(intelligence);
        setClassName("Wizard");
    }
    // method attack.

    public int[] attack () {

        int[] damage = new int[2];


        if( getMana() >= 5 ) {
            damage[0] = getIntelligence();
            setMana(getMana() + 1);
            damage[1] = 1;
        }

        else {
            damage[0] = 2;
            setMana(getMana() + 1);
            damage[1] = 2;
        }

        return damage;
    }

    //Getters and setters

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public String toString(){
        return "Name: " +getName()  + " |Type: Wizard |HP: " +
                getHp() + " |Intelligence: " + getIntelligence() +" |Mana: " + getMana();
    }

    public String toCSV(){
        return "Name: " +getName()  + " |Type: Wizard |HP: " +
                getHp() + " |Intelligence: " + getIntelligence() +" |Mana: " + getMana();
    }
}

