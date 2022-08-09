package Characters;
public class Warrior extends Character {
    private int stamina;
    private int strength;

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
        setClassName("Warrior");
    }

    // method attack.
    public int[] attack() {
        int[] damage = new int[2];
        if (getStamina() >= 5) {
            damage[0] = getStrength();
            setStamina(getStamina() - 5);
            damage[1] = 1;
        }
        else {
            damage[0] = getStrength() / 2;
            setStamina(getStamina() + 1);
            damage[1] = 2;
        }
        return damage;
    }
    //Getters & setters
    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }


    public String toString(){
        return "Name: " +getName()  + " Type: Warrior HP: " +
                getHp() + " Stamina: " + getStamina() +" Strength: " + getStrength() + "\n";
    }


}

