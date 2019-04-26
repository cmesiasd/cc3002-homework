package cc3002.tarea1;

import java.util.Objects;

public abstract class AbstractEnergy implements IEnergy, ICard {
    private String type;

    /** Constructor for Abstract Energy
     *
     * @param type Type of Energy
     *            Ex: Water, Fire, etc.
     */
    public AbstractEnergy(String type) {
        this.type = type;
    }

    public String getType(){
        return type;
    }

    /** Play the Energy Card to a Pokemon, adding an energy
     *
     * @param pokemon Pokemon
     */
    @Override
    public abstract void useEnergyCard(IPokemon pokemon);


}


