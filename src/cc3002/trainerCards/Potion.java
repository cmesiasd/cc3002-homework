package cc3002.trainerCards;

import cc3002.effect.IEffect;
import cc3002.effect.PotionEffect;

public class Potion extends ObjectCard{
    public Potion(int x) {
        super("Potion", "Remueve hasta x contadores de daño de uno de tus Pokémon.", new PotionEffect(x));
    }
}
