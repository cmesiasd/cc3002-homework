package cc3002.energy.fighting;

import cc3002.energy.AbstractEnergy;
import cc3002.pokemon.IPokemon;

/**
 * Class Fighting Energy
 *
 * @author cmesiasd
 * @version 2.0
 */
public class FightingEnergy extends AbstractEnergy {
    public FightingEnergy(String type) {
        super(type);
    }

    @Override
    public void useEnergyCard(IPokemon pokemon) {
        pokemon.receiveFightingEnergy(this);
    }
}
