package cc3002.tarea1;

public class Attack {
    private int baseDamage;
    private String name;
    private String description;
    private Cost cost;

    /**
     * Creates a new attack.
     *
     * @param name Attack name
     * @param baseDamage Base damage of the attack
     * @param description Text description of the attack
     */
    public Attack(String name, int baseDamage, String description, Cost cost) {
        this.baseDamage = baseDamage;
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    //region Properties
    public int getBaseDamage() {
        return baseDamage;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Cost getCost(){
        return cost;
    }
    //endregion

}
