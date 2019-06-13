package cc3002.abilities;

import cc3002.energyCost.EnergyCost;

public class Ability implements IAbility{
    private String name;
    private String description;
    private EnergyCost energyCost;

    /**
     * Create a new ability
     *
     * @param name Ability name
     * @param description Text description of the ability
     * @param energyCost Energy cost of the ability
     */
    public Ability(String name, String description, EnergyCost energyCost) {
        this.name = name;
        this.description = description;
        this.energyCost = energyCost;
    }

    //region Propierties

    /**
     * @return Ability's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return Ability's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return Ability's EnergyCost
     */
    public EnergyCost getEnergyCost() {
        return energyCost;
    }
    //endregion
}
