package cc3002.tarea1.water;

import cc3002.tarea1.AbstractEnergy;
import cc3002.tarea1.IPokemon;

public class WaterEnergy extends AbstractEnergy {
    public WaterEnergy() {
        super();
    }

    @Override
    public void useEnergyCard(IPokemon pokemon) {
        WaterEnergy waterEner = new WaterEnergy();
        pokemon.getCountEnergy().getCost().put(waterEner,1);
    }
}
