package cc3002.trainerCards;

import cc3002.ICard;
import cc3002.effect.IEffect;

/**
 * Trainer Cards Interfaces
 *
 * These cards alter
 * the state of the game at the time of being played
 *
 * @author cmesiasd
 * @version 2.0
 */
public interface ITrainerCards extends ICard {

    String getDescription();

    /**
     * Use the trainer card's effect
     */
    void useTrainerCardEffect();


    /**
     * @return IEffect
     */
    IEffect getEffect();
}
