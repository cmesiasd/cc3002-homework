package cc3002.effect;

public class LuckyStadiumEffect extends AbstractEffect{
    @Override
    public void doEffect() {
        this.getAssociatedCard().getTrainer().flipCoin();
        if (this.getAssociatedCard().getTrainer().getCoin()) this.getAssociatedCard().getTrainer().takeACardFromDeck();
    }
}
