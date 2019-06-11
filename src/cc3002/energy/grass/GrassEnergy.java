package cc3002.energy.grass;

import cc3002.energy.AbstractEnergy;
import cc3002.pokemon.IPokemon;

public class GrassEnergy extends AbstractEnergy {
    public GrassEnergy(String type) {
        super(type);
    }

    @Override
    public void useEnergyCard(IPokemon pokemon) {
        pokemon.receiveGrassEnergy(this);
    }
}
