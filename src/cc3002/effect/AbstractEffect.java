package cc3002.effect;

import cc3002.ICard;
import cc3002.Trainer;
import cc3002.abilities.IAbility;

public abstract class AbstractEffect implements IEffect{
    private IAbility associatedAbility;
    private ICard associatedCard;

    @Override
    public abstract void doEffect();

    @Override
    public IAbility getAbility() {
        return associatedAbility;
    }

    @Override
    public void setAbility(IAbility ability) {
        this.associatedAbility = ability;
    }

    @Override
    public ICard getAssociatedCard() {
        return associatedCard;
    }

    @Override
    public void setAssociatedCard(ICard card) {
        this.associatedCard = card;
    }
}
