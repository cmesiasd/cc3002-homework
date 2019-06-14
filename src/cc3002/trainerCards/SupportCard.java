package cc3002.trainerCards;

import cc3002.visitor.IVisitorCard;

public class SupportCard extends AbstractTrainerCards {

    public SupportCard(String cardName, String description) {
        super(cardName, description);
    }

    @Override
    public void acceptVisitor(IVisitorCard visitorCard) {
        visitorCard.visitSupportCard(this);
    }
}
