package cc3002.tarea1;

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
import java.util.List;

public abstract class AbstractPokemon implements IPokemon, ICard {
    private String name;
    private int id;
    private int hp;
    private int maxHP;
    private Cost countEnergy;
    private List<Attack> attackList;
    private Attack selectedAttack;

    /**
     * Creates a new Pokémon.
     *
     * @param name        Pokémon's name.
     * @param hp          Pokémon's hit points.
     * @param id          Pokemon's id.
     * @param countEnergy Pokemon's attack cost
     * @param attackList  Pokémon's attacks.
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

    public boolean isAlive(){
        return this.hp > 0;
    }
    //endregion


    //region Attack
    @Override
    public abstract void attack(IPokemon other, int index);

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
        if(!isAlive()) {
            this.hp = 0;
            this.changePokemon();
        }
    }

    public void changePokemon() {

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


    //region Energy
    public void receiveWaterEnergy(WaterEnergy waterEnergy){
        this.countEnergy.getCost().put(waterEnergy.getType(), this.countEnergy.getCost().get(waterEnergy.getType())+1);
    }

    public void receiveFireEnergy(FireEnergy fireEnergy){
        this.countEnergy.getCost().put(fireEnergy.getType(), this.countEnergy.getCost().get(fireEnergy.getType())+1);
    }

    public void receiveGrassEnergy(GrassEnergy grassEnergy){
        this.countEnergy.getCost().put(grassEnergy.getType(), this.countEnergy.getCost().get(grassEnergy.getType())+1);
    }

    public void receiveFightingEnergy(FightingEnergy fightingEnergy){
        this.countEnergy.getCost().put(fightingEnergy.getType(), this.countEnergy.getCost().get(fightingEnergy.getType())+1);
    }

    public void receiveLightingEnergy(LightingEnergy lightingEnergy){
        this.countEnergy.getCost().put(lightingEnergy.getType(), this.countEnergy.getCost().get(lightingEnergy.getType())+1);
    }

    public void receivePsychicEnergy(PsychicEnergy psychicEnergy){
        this.countEnergy.getCost().put(psychicEnergy.getType(), this.countEnergy.getCost().get(psychicEnergy.getType())+1);
    }

    //endregion

}
