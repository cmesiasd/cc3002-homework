package cc3002.tarea1;

import java.util.Objects;

/**
 *
 */
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
    /**
     * @return Attack's base damage
     */
    public int getBaseDamage() {
        return baseDamage;
    }

    /**
     * @return Attack's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return Attack's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return Attack's cost
     */
    public Cost getCost(){
        return cost;
    }
    //endregion


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Attack)) return false;
        Attack attack = (Attack) o;
        return getBaseDamage() == attack.getBaseDamage() &&
                Objects.equals(getName(), attack.getName()) &&
                Objects.equals(getDescription(), attack.getDescription()) &&
                Objects.equals(getCost(), attack.getCost());
    }

}
