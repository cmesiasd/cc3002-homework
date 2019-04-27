package cc3002.tarea1.psychic;

import cc3002.tarea1.AbstractEnergy;
import cc3002.tarea1.IPokemon;

public class PsychicEnergy extends AbstractEnergy {

    public PsychicEnergy(String type) {
        super(type);
    }

    @Override
    public void useEnergyCard(IPokemon pokemon) {
        pokemon.receivePsychicEnergy(this);
    }
}
