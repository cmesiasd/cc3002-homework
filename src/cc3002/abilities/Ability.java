package cc3002.abilities;

import cc3002.energyCost.energyCost;

public class Ability {
    private String name;
    private String description;
    private energyCost energyCost;

    /**
     * Create a new ability
     *
     * @param name Ability name
     * @param description Text description of the ability
     * @param energyCost Energy cost of the ability
     */
    public Ability(String name, String description, energyCost energyCost) {
        this.name = name;
        this.description = description;
        this.energyCost = energyCost;
    }

    //region Propierties
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    /**
     * @return Ability's energyCost
     */
    public energyCost getEnergyCost() {
        return energyCost;
    }
    //endregion
}
