package cc3002.abilities;

import cc3002.energyCost.EnergyCost;

import java.util.Objects;

/**
 *
 */
public class Attack extends Ability{
    private String name;
    private String description;
    private EnergyCost energyCost;
    private int baseDamage;

    /**
     * Creates a new attack.
     * An Attack is a type of ability.
     *
     * @param name Attack name
     * @param baseDamage Base damage of the attack
     * @param description Text description of the attack
     * @param energyCost Energy cost of the attack
     */
    public Attack(String name, int baseDamage, String description, EnergyCost energyCost) {
        super(name,description,energyCost);
        this.baseDamage = baseDamage;

    }


    //region Properties
    /**
     * @return Attack's base damage
     */
    public int getBaseDamage() {
        return baseDamage;
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
