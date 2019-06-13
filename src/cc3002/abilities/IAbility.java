package cc3002.abilities;

import cc3002.energyCost.EnergyCost;

public interface IAbility {
    String getName();
    String getDescription();
    EnergyCost getEnergyCost();
}
