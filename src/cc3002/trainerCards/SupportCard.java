package cc3002.trainerCards;

import cc3002.effect.IEffect;
import cc3002.visitor.IVisitorCard;

/**
 * Support Card
 * All these cards have an instantaneous effect, when they are played, their
 * effect and then discarded
 *
 * @author cmesiasd
 * @version 2.0
 */
public class SupportCard extends AbstractTrainerCards {

    public SupportCard(String cardName, String description, IEffect effect) {
        super(cardName, description, effect);
    }

    @Override
    public void acceptVisitor(IVisitorCard visitorCard) {
        visitorCard.visitSupportCard(this);
    }
}
