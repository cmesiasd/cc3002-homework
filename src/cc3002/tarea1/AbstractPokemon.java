package cc3002.tarea1;

import cc3002.tarea1.fighting.FightingPokemon;
import cc3002.tarea1.fire.FirePokemon;
import cc3002.tarea1.grass.GrassPokemon;
import cc3002.tarea1.lighting.LightingPokemon;
import cc3002.tarea1.psychic.PsychicPokemon;
import cc3002.tarea1.water.WaterPokemon;

import java.util.List;

public abstract class AbstractPokemon implements IPokemon {
    private String name;
    private int id;
    private int hp;
    private Cost countEnergy;
    private List<Attack> attackList;
    private Attack selectedAttack;

    /**
     * Creates a new Pokémon.
     *
     * @param name       Pokémon's name.
     * @param hp         Pokémon's hit points.
     * @param id         Pokemon's id.
     * @param countEnergy       Pokemon's attack cost
     * @param attackList Pokémon's attacks.
     */
    protected AbstractPokemon(String name, int hp, int id, Cost countEnergy, List<Attack> attackList) {
        this.name = name;
        this.id = id;
        this.hp = hp;
        this.countEnergy = countEnergy;
        this.attackList = attackList;
    }

    //region Properties
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHP() {
        return hp;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public Cost getCountEnergy() {
        return countEnergy;
    }

    @Override
    public List<Attack> getAttacks() {
        return attackList;
    }

    @Override
    public Attack getSelectedAttack() {
        return selectedAttack;
    }
    //endregion


    //region Attack
    public void attack(IPokemon other, int index) {
        this.selectAttack(index);
        other.receiveAttack(this);
    }

    @Override
    public void selectAttack(int index) {
        selectedAttack = attackList.get(index);
    }

    //endregion

    //region Damages
    /**
     * Receives an attack.
     *
     * @param other Received attack.
     */
    public void receiveAttack(IPokemon other) {
        this.hp -= other.getSelectedAttack().getBaseDamage();
    }

    /**
     * Receives an attack to which this Pokémon is weak.
     *
     * @param other Received attack.
     */
    public void receiveWeaknessAttack(IPokemon other) {
        this.hp -= other.getSelectedAttack().getBaseDamage() * 2;
    }

    /**
     * Receives an attack to which this Pokémon is resistant.
     *
     * @param other Received attack.
     */
    public void receiveResistantAttack(IPokemon other) {
        this.hp -= other.getSelectedAttack().getBaseDamage() - 30;
    }




    @Override
    public void attackedByWaterPokemon(WaterPokemon waterPokemon) {
        receiveAttack(waterPokemon);
    }

    @Override
    public void attackedByGrassPokemon(GrassPokemon grassPokemon) {
        receiveAttack(grassPokemon);
    }

    @Override
    public void attackedByFirePokemon(FirePokemon firePokemon) {
        receiveAttack(firePokemon);
    }

    @Override
    public void attackedByFightingPokemon(FightingPokemon fightingPokemon) {
        receiveAttack(fightingPokemon);
    }

    @Override
    public void attackedByPsychicPokemon(PsychicPokemon psychicPokemon) {
        receiveAttack(psychicPokemon);
    }

    @Override
    public void attackedByLightingPokemon(LightingPokemon lightingPokemon) {
        receiveAttack(lightingPokemon);
    }
    //endregion

}
