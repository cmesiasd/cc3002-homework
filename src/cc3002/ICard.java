package cc3002;

import cc3002.visitor.IVisitorCard;

public interface ICard {
    String getCardName();

    void acceptVisitor(IVisitorCard visitorCard);

    void discard(Trainer trainer);

    void setTrainer(Trainer trainer);

    Trainer getTrainer();
}
