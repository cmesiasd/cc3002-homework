package cc3002;

import cc3002.visitor.IVisitorCard;

public abstract class AbstractCard implements ICard {
    private String cardName;
    private Trainer trainer;

    public AbstractCard(String cardName) {
        this.cardName = cardName;
        this.trainer = null;
    }

    @Override
    public String getCardName() {
        return this.cardName;
    }

    @Override
    public Trainer getTrainer() {
        return trainer;
    }

    @Override
    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    @Override
    public void discard(Trainer trainer){
        trainer.getDiscardPile().add(this);
    }

    @Override
    public abstract void acceptVisitor(IVisitorCard visitorCard);

}
