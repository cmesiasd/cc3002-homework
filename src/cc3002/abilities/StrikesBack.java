package cc3002.abilities;

import cc3002.effect.IEffect;
import cc3002.effect.StrikeBackEffect;
import cc3002.energyCost.EnergyCost;

public class StrikesBack extends Ability{
    public StrikesBack() {
        super("Strikes Back", "Cuando el ataque de un oponente dañe a este Pokémon, el Pokémon atacante\n" +
                "recibe x de daño.", new EnergyCost(0,0,0,0,0,0), new StrikeBackEffect());
    }
}
