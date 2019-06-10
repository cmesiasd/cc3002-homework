package cc3002.tarea1.pokemon;

import java.util.List;

import cc3002.tarea1.Attack;
import cc3002.tarea1.cost.Cost;
import cc3002.tarea1.energy.fighting.FightingEnergy;
import cc3002.tarea1.pokemon.fighting.FightingPokemon;
import cc3002.tarea1.energy.fire.FireEnergy;
import cc3002.tarea1.pokemon.fire.FirePokemon;
import cc3002.tarea1.energy.grass.GrassEnergy;
import cc3002.tarea1.pokemon.grass.GrassPokemon;
import cc3002.tarea1.energy.lighting.LightingEnergy;
import cc3002.tarea1.pokemon.lighting.LightingPokemon;
import cc3002.tarea1.energy.psychic.PsychicEnergy;
import cc3002.tarea1.pokemon.psychic.PsychicPokemon;
import cc3002.tarea1.energy.water.WaterEnergy;
import cc3002.tarea1.pokemon.water.WaterPokemon;


/**
 * Pokemon Interfaces
 *
 * @author cmesiasd
 * @version 1.0
 */

public interface IPokemon {
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
    Cost getCountEnergy();

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
    void attackedByWaterPokemon(WaterPokemon waterPokemon);

    /**
     * Receives an attack from a grass pokemon.
     *
     * @param grassPokemon Received attack.
     */
    void attackedByGrassPokemon(GrassPokemon grassPokemon);

    /**
     * Receives an attack from a fire pokemon.
     *
     * @param firePokemon Received attack.
     */
    void attackedByFirePokemon(FirePokemon firePokemon);

    /**
     * Receives an attack from a fighting pokemon.
     *
     * @param fightingPokemon Received attack.
     */
    void attackedByFightingPokemon(FightingPokemon fightingPokemon);

    /**
     * Receives an attack from a psychic pokemon.
     *
     * @param psychicPokemon Received attack.
     */
    void attackedByPsychicPokemon(PsychicPokemon psychicPokemon);

    /**
     * Receives an attack from a lighting pokemon.
     *
     * @param lightingPokemon Received attack.
     */
    void attackedByLightingPokemon(LightingPokemon lightingPokemon);
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


