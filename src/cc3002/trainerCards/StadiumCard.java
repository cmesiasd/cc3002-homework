package cc3002.trainerCards;

import cc3002.effect.IEffect;
import cc3002.visitor.IVisitorCard;

/**
 * Stadium Card
 * This type of cards has an effect on the playing field
 *
 * @author cmesiasd
 * @version 2.0
 */
public class StadiumCard extends AbstractTrainerCards{

    public StadiumCard(String cardName, String description, IEffect effect) {
        super(cardName, description,effect);
    }

    @Override
    public void acceptVisitor(IVisitorCard visitorCard) {
        visitorCard.visitStadiumCard(this);
    }
}
