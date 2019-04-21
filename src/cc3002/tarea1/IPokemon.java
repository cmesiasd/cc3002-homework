package cc3002.tarea1;

import java.util.List;
import cc3002.tarea1.electric.ElectricAttack;
import cc3002.tarea1.fighting.FightingAttack;
import cc3002.tarea1.fire.FireAttack;
import cc3002.tarea1.grass.GrassAttack;
import cc3002.tarea1.psychic.PsychicAttack;
import cc3002.tarea1.water.WaterAttack;

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
    int getCountEnergy();

    /**
     * @return List with all the Pokémon attacks.
     */
    List<IAttack> getAttacks();

    /**
     * @return The current selected attack.
     */
    IAttack getSelectedAttack();
    //endregion

    //region Attack
    /**
     * Attacks another Pokémon.
     *
     * @param other Target of the attack.
     */
    void attack(IPokemon other);

    /**
     * Selects an attack.
     *
     * @param index Index of the attack to be selected.
     */
    void selectAttack(int index);

    /**
     * Receives damage from a water attack.
     *
     * @param attack Received attack.
     */
    //endregion

    //region Damage
    void receiveWaterAttack(WaterAttack attack);

    /**
     * Receives damage from a grass attack.
     *
     * @param attack Received attack.
     */
    void receiveGrassAttack(GrassAttack attack);

    /**
     * Receives damage from a fire attack.
     *
     * @param attack Received attack.
     */
    void receiveFireAttack(FireAttack attack);

    /**
     * Receives damage from a fighting attack.
     *
     * @param attack Received attack.
     */
    void receiveFightingAttack(FightingAttack attack);

    /**
     * Receives damage from a psychic attack.
     *
     * @param attack Received attack.
     */
    void receivePsychicAttack(PsychicAttack attack);

    /**
     * Receives damage from a electric attack.
     *
     * @param attack Received attack.
     */
    void receiveElectricAttack(ElectricAttack attack);

    //endregion
}


