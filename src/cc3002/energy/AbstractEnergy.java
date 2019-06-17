package cc3002.energy;

import cc3002.AbstractCard;
import cc3002.pokemon.IPokemon;
import cc3002.visitor.IVisitorCard;

import java.util.Objects;

/**
 * Abstract class for Energy
 * Implements IEnergy
 *
 * @author cmesiasd
 * @version 1.0
 */
public abstract class AbstractEnergy extends AbstractCard implements IEnergy{

    /** Constructor for Abstract Energy
     *
     * @param type Type of Energy
     *            Ex: Water, Fire, etc.
     */
    public AbstractEnergy(String type) {
        super(type);
    }


    /** Play the Energy Card to a Pokemon, adding an energy
     *
     * @param pokemon Pokemon
     */
    @Override
    public abstract void useEnergyCard(IPokemon pokemon);


    @Override
    public void acceptVisitor(IVisitorCard visitorCard) {
        visitorCard.visitEnergy(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEnergy)) return false;
        AbstractEnergy that = (AbstractEnergy) o;
        return Objects.equals(getCardName(), that.getCardName());
    }

}


