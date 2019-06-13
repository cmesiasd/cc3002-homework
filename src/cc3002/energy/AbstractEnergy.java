package cc3002.energy;

import cc3002.Trainer;
import cc3002.pokemon.IPokemon;

import java.util.Objects;

/**
 * Abstract class for Energy
 * Implements IEnergy, ICard
 *
 * @author cmesiasd
 * @version 1.0
 */
public abstract class AbstractEnergy implements IEnergy{
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


    @Override
    public void playCard(Trainer trainer) {
        if(trainer.getHand() != null) this.useEnergyCard(trainer.getActivePokemon());
    }

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


