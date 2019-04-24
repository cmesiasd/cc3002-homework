package cc3002.tarea1.fire;

import cc3002.tarea1.AbstractEnergy;
import cc3002.tarea1.IPokemon;

public class FireEnergy extends AbstractEnergy {
    public FireEnergy(String type) {
        super(type);
    }

    @Override
    public void useEnergyCard(IPokemon pokemon) {
        pokemon.receiveFireEnergy(this);
    }
}
