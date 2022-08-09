package Characters;


public abstract class Character implements Attacks {
    private static int counter = 0;
    private int id;
    private int hp;
    private String name;


    private boolean isAlive = true;
    private String className = null;
    public Character(String name, int hp) {
        counter++;
        setName(name);
        setHp(hp);
        setAlive(isAlive);
        setId(id);
    }
    public abstract int[] attack();

    //Getters & setters

    public int getId() {
        return id;
    }
    public void setId() {
        this.id = counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }



}
