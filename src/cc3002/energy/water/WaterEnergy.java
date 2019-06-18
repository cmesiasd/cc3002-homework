package cc3002.energy.water;

import cc3002.energy.AbstractEnergy;
import cc3002.pokemon.IPokemon;

/**
 * Class Water Energy
 *
 * @author cmesiasd
 * @version 2.0
 */
public class WaterEnergy extends AbstractEnergy {

    public WaterEnergy(String type) {
        super(type);
    }

    @Override
    public void useEnergyCard(IPokemon pokemon) {
        pokemon.receiveWaterEnergy(this);
    }

}
