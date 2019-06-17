package cc3002.trainerCards;

import cc3002.ICard;
import cc3002.effect.IEffect;

public interface ITrainerCards extends ICard {

    String getDescription();

    void useTrainerCardEffect();

    IEffect getEffect();
}
