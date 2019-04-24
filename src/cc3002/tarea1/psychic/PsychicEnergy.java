package cc3002.tarea1.psychic;

import cc3002.tarea1.AbstractEnergy;
import cc3002.tarea1.IPokemon;

public class PsychicEnergy extends AbstractEnergy {

    public PsychicEnergy(String psychic) {
        super(psychic);
    }

    @Override
    public void useEnergyCard(IPokemon pokemon) {
        pokemon.receivePsychicEnergy(this);
    }
}
