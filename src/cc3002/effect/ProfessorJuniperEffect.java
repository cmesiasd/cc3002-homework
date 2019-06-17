package cc3002.effect;

import cc3002.ICard;

public class ProfessorJuniperEffect extends AbstractEffect {
    @Override
    public void doEffect() {
        int sizeHand = this.getAssociatedCard().getTrainer().getHand().size();
        for (int i = 0; i < sizeHand; i++) {
            this.getAssociatedCard().getTrainer().getHand().get(0).discard(this.getAssociatedCard().getTrainer());
            this.getAssociatedCard().getTrainer().getHand().remove(0);



        }
        for (int i = 0; i < 7; i++) {
            this.getAssociatedCard().getTrainer().takeACardFromDeck();
        }
    }
}
