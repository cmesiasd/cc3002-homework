package cc3002.energy.fire;

import cc3002.energy.AbstractEnergy;
import cc3002.pokemon.IPokemon;

public class FireEnergy extends AbstractEnergy {
    public FireEnergy(String type) {
        super(type);
    }

    @Override
    public void useEnergyCard(IPokemon pokemon) {
        pokemon.receiveFireEnergy(this);
    }
}
