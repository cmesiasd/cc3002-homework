package cc3002.tarea1.energy.fighting;

import cc3002.tarea1.energy.AbstractEnergy;
import cc3002.tarea1.pokemon.IPokemon;

public class FightingEnergy extends AbstractEnergy {
    public FightingEnergy(String type) {
        super(type);
    }

    @Override
    public void useEnergyCard(IPokemon pokemon) {
        pokemon.receiveFightingEnergy(this);
    }
}
