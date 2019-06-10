package cc3002.tarea1.energy.psychic;

import cc3002.tarea1.energy.AbstractEnergy;
import cc3002.tarea1.pokemon.IPokemon;

public class PsychicEnergy extends AbstractEnergy {

    public PsychicEnergy(String type) {
        super(type);
    }

    @Override
    public void useEnergyCard(IPokemon pokemon) {
        pokemon.receivePsychicEnergy(this);
    }
}
