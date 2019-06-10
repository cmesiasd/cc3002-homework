package cc3002.tarea1.energy.water;

import cc3002.tarea1.energy.AbstractEnergy;
import cc3002.tarea1.pokemon.IPokemon;

public class WaterEnergy extends AbstractEnergy {

    public WaterEnergy(String type) {
        super(type);
    }

    @Override
    public void useEnergyCard(IPokemon pokemon) {
        pokemon.receiveWaterEnergy(this);
    }

}
