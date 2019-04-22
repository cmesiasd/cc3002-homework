package cc3002.tarea1;

import java.util.Objects;

public abstract class AbstractEnergy implements IEnergy {

    public AbstractEnergy() {

    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public abstract void useEnergyCard(IPokemon pokemon);
}


