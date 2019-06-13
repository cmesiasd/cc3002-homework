package cc3002.abilities;

import cc3002.energyCost.energyCost;

import java.util.Objects;

/**
 *
 */
public class Attack {
    private String name;
    private String description;
    private energyCost energyCost;
    private int baseDamage;

    /**
     * Creates a new attack.
     *
     * @param name Attack name
     * @param baseDamage Base damage of the attack
     * @param description Text description of the attack
     * @param energyCost
     */
    public Attack(String name, int baseDamage, String description, energyCost energyCost) {
        this.baseDamage = baseDamage;
        this.name = name;
        this.description = description;
        this.energyCost = energyCost;
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


    public energyCost getEnergyCost(){
        return energyCost;
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
                Objects.equals(getEnergyCost(), attack.getEnergyCost());
    }

}
