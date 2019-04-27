package cc3002.tarea1.water;

import cc3002.tarea1.AbstractEnergy;
import cc3002.tarea1.IPokemon;

public class WaterEnergy extends AbstractEnergy {

    public WaterEnergy(String type) {
        super(type);
    }

    @Override
    public void useEnergyCard(IPokemon pokemon) {
        pokemon.receiveWaterEnergy(this);
    }

}
