package cc3002.tarea1;

public interface IAttack {

    /**
     * An attack damages a Pokémon based on the attack's base damage, it's type and the type of the
     * Pokémon that receives the attack.
     *
     * @param other Pokémon that receives the attack.
     */
    void attack(IPokemon other);

    //region Propierties
    /**
     * Getter for the base damage.
     *
     * @return Base damage of the attack.
     */
    int getBaseDamage();

    /**
     * Getter for the attack's name.
     *
     * @return Name of the attack.
     */
    String getName();

    /**
     * Getter for the text that describes the attack.
     *
     * @return Description of the attack.
     */
    String getDescription();
    //endregion
}


