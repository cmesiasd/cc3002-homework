package cc3002.tarea1;

import java.util.Objects;

/**
 * Abstract class for Energy
 * Implements IEnergy, ICard
 *
 * @author cmesiasd
 * @version 1.0
 */
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

    /**
     * @return Energy's Type
     */
    public String getType(){
        return type;
    }

    /** Play the Energy Card to a Pokemon, adding an energy
     *
     * @param pokemon Pokemon
     */
    @Override
    public abstract void useEnergyCard(IPokemon pokemon);


    /**
     * @return CardName(Energy Type)
     */
    @Override
    public String getCardName() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEnergy)) return false;
        AbstractEnergy that = (AbstractEnergy) o;
        return Objects.equals(getType(), that.getType());
    }

}


