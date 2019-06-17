package cc3002.abilities;

import cc3002.effect.ElectricShockEffect;
import cc3002.effect.IEffect;
import cc3002.energyCost.EnergyCost;

public class ElectricShock extends Attack{

    public ElectricShock(int x) {
        super("Electric Shock", 30, "Lanza una moneda, si sale sello, este Pokémon recibe x de daño.", new EnergyCost(0,0,0,0,0,0), new ElectricShockEffect(x));
    }
}
