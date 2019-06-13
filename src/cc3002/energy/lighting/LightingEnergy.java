package cc3002.energy.lighting;

import cc3002.energy.AbstractEnergy;
import cc3002.pokemon.IPokemon;

public class LightingEnergy extends AbstractEnergy {
    public LightingEnergy(String type) {
        super(type);
    }

    @Override
    public void useEnergyCard(IPokemon pokemon) {
        pokemon.receiveLightingEnergy(this);
    }
}
