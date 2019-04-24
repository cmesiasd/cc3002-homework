package cc3002.tarea1;

import java.util.Objects;

public abstract class AbstractEnergy implements IEnergy {
    private String type;

    public AbstractEnergy(String type) {
        this.type = type;
    }

    @Override
    public abstract void useEnergyCard(IPokemon pokemon);

    public String getType(){
        return type;
    }
}


