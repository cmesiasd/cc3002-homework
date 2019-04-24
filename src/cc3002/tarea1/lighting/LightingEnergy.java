package cc3002.tarea1.lighting;

import cc3002.tarea1.AbstractEnergy;
import cc3002.tarea1.IPokemon;

public class LightingEnergy extends AbstractEnergy {
    public LightingEnergy(String type) {
        super(type);
    }

    @Override
    public void useEnergyCard(IPokemon pokemon) {
        pokemon.receiveLightingEnergy(this);
    }
}
