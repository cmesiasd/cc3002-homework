package cc3002.effect;

import cc3002.ICard;
import cc3002.Trainer;
import cc3002.abilities.IAbility;

public interface IEffect {
    void doEffect();

    IAbility getAbility();

    void setAbility(IAbility ability);

    ICard getAssociatedCard();

    void setAssociatedCard(ICard card);

}

