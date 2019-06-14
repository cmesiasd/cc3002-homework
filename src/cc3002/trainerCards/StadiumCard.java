package cc3002.trainerCards;

import cc3002.visitor.IVisitorCard;

public class StadiumCard extends AbstractTrainerCards{

    public StadiumCard(String cardName, String description) {
        super(cardName, description);
    }

    @Override
    public void acceptVisitor(IVisitorCard visitorCard) {
        visitorCard.visitStadiumCard(this);
    }
}
