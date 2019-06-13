package cc3002.pokemon;

import java.util.List;

import cc3002.abilities.Attack;
import cc3002.ICard;
import cc3002.energyCost.EnergyCost;
import cc3002.energy.water.WaterEnergy;
import cc3002.pokemon.fighting.AbstractFightingPokemon;
import cc3002.pokemon.fire.AbstractFirePokemon;
import cc3002.pokemon.grass.AbstractGrassPokemon;
import cc3002.pokemon.lighting.AbstractLightingPokemon;
import cc3002.pokemon.psychic.AbstractPsychicPokemon;
import cc3002.pokemon.water.AbstractWaterPokemon;
import cc3002.energy.fighting.FightingEnergy;
import cc3002.energy.fire.FireEnergy;
import cc3002.energy.grass.GrassEnergy;
import cc3002.energy.lighting.LightingEnergy;
import cc3002.energy.psychic.PsychicEnergy;


/**
 * Pokemon Interfaces
 *
 * @author cmesiasd
 * @version 1.0
 */

public interface IPokemon extends ICard {
    //region Propierties
    /**
     * @return Pokémon's name.
     */
    String getName();

    /**
     * @return Pokémon's hit points.
     */
    int getHP();

    /**
     * @return Pokémon's id.
     */
    int getID();

    /**
     * @return Pokemon's energy counter.
     */
    EnergyCost getCountEnergy();

    /**
     * @return List with all the Pokémon attacks.
     */
    List<Attack> getAttacks();

    /**
     * @return The current selected attack.
     */
    Attack getSelectedAttack();

    /**
     * @return Pokemon is alive
     */
    boolean isAlive();

    //endregion

    //region Attack
    /**
     * Attacks another Pokémon.
     *
     * @param other Target of the attack.
     * @param index Index of attack.
     */
    void attack(IPokemon other, int index);

    /**
     * Selects an attack.
     *
     * @param index Index of the attack.
     */
    void selectAttack(int index);

    /**
     * @return Can Pokemon attack?
     */
    boolean canAttack();

    //endregion

    //region Damage

    /**
     * Receives an attack.
     *
     * @param other Received attack.
     */
    void receiveAttack(IPokemon other);

    /**
     * Receives an attack to which this Pokémon is weak.
     *
     * @param other Received attack.
     */
    void receiveWeaknessAttack(IPokemon other);

    /**
     * Receives an attack to which this Pokémon is resistant.
     *
     * @param other Received attack.
     */
    void receiveResistantAttack(IPokemon other);

    /**
     * Receives an attack from a water pokemon.
     *
     * @param waterPokemon Received attack.
     */
    void attackedByWaterPokemon(AbstractWaterPokemon waterPokemon);

    /**
     * Receives an attack from a grass pokemon.
     *
     * @param grassPokemon Received attack.
     */
    void attackedByGrassPokemon(AbstractGrassPokemon grassPokemon);

    /**
     * Receives an attack from a fire pokemon.
     *
     * @param firePokemon Received attack.
     */
    void attackedByFirePokemon(AbstractFirePokemon firePokemon);

    /**
     * Receives an attack from a fighting pokemon.
     *
     * @param fightingPokemon Received attack.
     */
    void attackedByFightingPokemon(AbstractFightingPokemon fightingPokemon);

    /**
     * Receives an attack from a psychic pokemon.
     *
     * @param psychicPokemon Received attack.
     */
    void attackedByPsychicPokemon(AbstractPsychicPokemon psychicPokemon);

    /**
     * Receives an attack from a lighting pokemon.
     *
     * @param lightingPokemon Received attack.
     */
    void attackedByLightingPokemon(AbstractLightingPokemon lightingPokemon);
    //endregion


    //region Energy

    /** Pokemon receives an energy of the fire type
     *
     * @param fireEnergy Fire Energy
     */
    void receiveFireEnergy(FireEnergy fireEnergy);

    /** Pokemon receives an energy of the water type
     *
     * @param waterEnergy Water Energy
     */
    void receiveWaterEnergy(WaterEnergy waterEnergy);

    /** Pokemon receives an energy of the grass type
     *
     * @param grassEnergy Grass Energy
     */
    void receiveGrassEnergy(GrassEnergy grassEnergy);

    /** Pokemon receives an energy of the lighting type
     *
     * @param lightingEnergy Lighting Energy
     */
    void receiveLightingEnergy(LightingEnergy lightingEnergy);

    /** Pokemon receives an energy of the fighting type
     *
     * @param fightingEnergy Fighting Energy
     */
    void receiveFightingEnergy(FightingEnergy fightingEnergy);

    /** Pokemon receives an energy of the psychic type
     *
     * @param psychicEnergy Psychic Energy
     */
    void receivePsychicEnergy(PsychicEnergy psychicEnergy);
    //endregion
}


