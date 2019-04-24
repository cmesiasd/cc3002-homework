package cc3002.tarea1;

import java.util.List;

import cc3002.tarea1.fighting.FightingEnergy;
import cc3002.tarea1.fighting.FightingPokemon;
import cc3002.tarea1.fire.FireEnergy;
import cc3002.tarea1.fire.FirePokemon;
import cc3002.tarea1.grass.GrassEnergy;
import cc3002.tarea1.grass.GrassPokemon;
import cc3002.tarea1.lighting.LightingEnergy;
import cc3002.tarea1.lighting.LightingPokemon;
import cc3002.tarea1.psychic.PsychicEnergy;
import cc3002.tarea1.psychic.PsychicPokemon;
import cc3002.tarea1.water.WaterEnergy;
import cc3002.tarea1.water.WaterPokemon;


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
    //endregion

    //region Attack
    /**
     * Attacks another Pokémon.
     *
     * @param other Target of the attack.
     */
    void attack(IPokemon other, int index);

    /**
     * Selects an attack.
     *
     * @param index Index of the attack to be selected.
     */
    void selectAttack(int index);

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
     * @param firePokemon attackedByd attack.
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
    void receiveFireEnergy(FireEnergy fireEnergy);

    void receiveWaterEnergy(WaterEnergy waterEnergy);

    void receiveGrassEnergy(GrassEnergy grassEnergy);

    void receiveLightingEnergy(LightingEnergy lightingEnergy);

    void receiveFightingEnergy(FightingEnergy fightingEnergy);

    void receivePsychicEnergy(PsychicEnergy psychicEnergy);


    //endregion
}


