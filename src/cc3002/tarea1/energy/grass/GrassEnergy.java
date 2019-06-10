package cc3002.tarea1.energy.grass;

import cc3002.tarea1.energy.AbstractEnergy;
import cc3002.tarea1.pokemon.IPokemon;

public class GrassEnergy extends AbstractEnergy {
    public GrassEnergy(String type) {
        super(type);
    }

    @Override
    public void useEnergyCard(IPokemon pokemon) {
        pokemon.receiveGrassEnergy(this);
    }
}
