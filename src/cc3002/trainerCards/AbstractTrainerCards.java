package cc3002.trainerCards;

import cc3002.AbstractCard;
import cc3002.visitor.IVisitorCard;

public abstract class AbstractTrainerCards extends AbstractCard implements ITrainerCards{
    private String cardName;
    private String description;


    public AbstractTrainerCards(String cardName, String description) {
        super(cardName);
        this.description = description;
    }


    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void useTrainerCardEffect() {

    }

    @Override
    public void acceptVisitor(IVisitorCard visitorCard){

    }
}
