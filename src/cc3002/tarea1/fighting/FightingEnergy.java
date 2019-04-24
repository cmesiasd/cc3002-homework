package cc3002.tarea1.fighting;

import cc3002.tarea1.AbstractEnergy;
import cc3002.tarea1.IPokemon;

public class FightingEnergy extends AbstractEnergy {
    public FightingEnergy(String type) {
        super(type);
    }

    @Override
    public void useEnergyCard(IPokemon pokemon) {
        pokemon.receiveFightingEnergy(this);
    }
}
