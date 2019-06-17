package cc3002.trainerCards;

import cc3002.effect.IEffect;
import cc3002.visitor.IVisitorCard;

public class ObjectCard extends AbstractTrainerCards{
    public ObjectCard(String name, String description, IEffect effect) {
        super(name, description,effect);
    }

    @Override
    public void acceptVisitor(IVisitorCard visitorCard) {
        visitorCard.visitObjectCard(this);
    }
}
