package cc3002.tarea1.fighting;

import cc3002.tarea1.AbstractAttack;
import cc3002.tarea1.IPokemon;

public class FightingAttack extends AbstractAttack {
    /**
     * Creates a new attack.
     *
     * @param name        Attack name
     * @param baseDamage  Base damage of the attack
     * @param description Text description of the attack
     */
    protected FightingAttack(String name, int baseDamage, String description) {
        super(name, baseDamage, description);
    }

    /**
     * An attack damages a Pokémon based on the attack's base damage, it's type and the type of the
     * Pokémon that receives the attack.
     *
     * @param other Pokémon that receives the attack.
     */
    @Override
    public void attack(IPokemon other) {

    }
}
