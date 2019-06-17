package cc3002.abilities;

import cc3002.effect.NullEffect;
import cc3002.energyCost.EnergyCost;

public class NullAbility extends Ability{
    private int baseDamage;

    public NullAbility() {
        super("", "", new EnergyCost(0,0,0,0,0,0), new NullEffect());
        this.baseDamage = 0;
    }
}
