package cc3002.tarea1.water;

import cc3002.tarea1.AbstractAttack;
import cc3002.tarea1.IPokemon;

public class WaterAttack extends AbstractAttack {
    protected WaterAttack(String name, int baseDamage, String description) {
        super(name, baseDamage, description);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof WaterAttack && super.equals(obj);
    }

    /**
     * An attack damages a Pokémon based on the attack's base damage, it's type and the type of the
     * Pokémon that receives the attack.
     *
     * @param other Pokémon that receives the attack.
     */
    @Override
    public void attack(IPokemon other) {
        other.receiveWaterAttack(this);
    }
}
