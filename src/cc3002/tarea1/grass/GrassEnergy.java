package cc3002.tarea1.grass;

import cc3002.tarea1.AbstractEnergy;
import cc3002.tarea1.IPokemon;

public class GrassEnergy extends AbstractEnergy {
    public GrassEnergy(String type) {
        super(type);
    }

    @Override
    public void useEnergyCard(IPokemon pokemon) {
        pokemon.receiveGrassEnergy(this);
    }
}
