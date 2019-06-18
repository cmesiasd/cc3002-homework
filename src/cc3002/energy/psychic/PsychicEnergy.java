package cc3002.energy.psychic;

import cc3002.energy.AbstractEnergy;
import cc3002.pokemon.IPokemon;

/**
 * Class Psychic Energy
 *
 * @author cmesiasd
 * @version 2.0
 */
public class PsychicEnergy extends AbstractEnergy {

    public PsychicEnergy(String type) {
        super(type);
    }

    @Override
    public void useEnergyCard(IPokemon pokemon) {
        pokemon.receivePsychicEnergy(this);
    }
}
