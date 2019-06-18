package cc3002.trainerCards;

import cc3002.effect.IEffect;
import cc3002.visitor.IVisitorCard;

/**
 * Class Object Card
 *
 * These cards have an effect on some of the Pokémon in play
 *
 * @author cmesiasd
 * @version 1.0
 */
public class ObjectCard extends AbstractTrainerCards{
    public ObjectCard(String name, String description, IEffect effect) {
        super(name, description,effect);
    }

    @Override
    public void acceptVisitor(IVisitorCard visitorCard) {
        visitorCard.visitObjectCard(this);
    }
}
