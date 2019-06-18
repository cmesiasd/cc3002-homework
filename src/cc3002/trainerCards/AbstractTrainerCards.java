package cc3002.trainerCards;

import cc3002.AbstractCard;
import cc3002.effect.IEffect;
import cc3002.visitor.IVisitorCard;

/**
 * Abstract Trainer Card
 * Implements ITrainerCards
 * Extends AbstractCard
 *
 * @author cmesiasd
 * @version 2.0
 */
public abstract class AbstractTrainerCards extends AbstractCard implements ITrainerCards{
    private String description;
    private IEffect effect;


    public AbstractTrainerCards(String cardName, String description, IEffect effect) {
        super(cardName);
        this.description = description;
        this.effect = effect;
    }


    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public IEffect getEffect() {
        return this.effect;
    }

    @Override
    public void useTrainerCardEffect() {
        effect.doEffect();
    }

    @Override
    public abstract void acceptVisitor(IVisitorCard visitorCard);

}
