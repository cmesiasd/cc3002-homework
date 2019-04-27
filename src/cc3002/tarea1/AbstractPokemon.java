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
import cc3002.tarea1.Trainer;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Abstract Pokemon
 * Implements IPokemon and ICard
 *
 * @author cmesiasd
 * @version 1.0
 */
public abstract class AbstractPokemon implements IPokemon, ICard {
    private String name;
    private int id;
    private int hp;
    private Cost countEnergy;
    private List<Attack> attackList;
    private Attack selectedAttack;

    /**
     * Creates a new Pokémon.
     *
     * @param name        Pokémon's name.
     * @param hp          Pokémon's hit points.
     * @param id          Pokemon's id.
     * @param countEnergy Pokemon's counter energies
     * @param attackList  Pokémon's attacks list.
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

    public boolean canAttack() {
        for (Map.Entry<String, Integer> entry1 : this.getSelectedAttack().getCost().getCost().entrySet()) {
            String k = entry1.getKey();
            //Compara los key si son iguales.
            if(this.getCountEnergy().getCost().containsKey(k)){
                //si son iguales obtiene los valores.
                Integer value1 = entry1.getValue(); //Costo ataque
                Integer value2 = this.getCountEnergy().getCost().get(k); //Energias
                if (value1 > value2){
                    return false;
                }
            }
        }
        return true;
    }

    //endregion


    //region Damages

    public void receiveAttack(IPokemon other) {
        if (other.canAttack()) {
            this.hp -= other.getSelectedAttack().getBaseDamage();
        }
        if(!isAlive()) {
            this.hp = 0;
        }
    }

    public void receiveWeaknessAttack(IPokemon other) {
        if(other.canAttack()) {
            this.hp -= other.getSelectedAttack().getBaseDamage() * 2;
        }
        if(!isAlive()) {
            this.hp = 0;
        }
    }

    public void receiveResistantAttack(IPokemon other) {
        if (other.getSelectedAttack().getBaseDamage() - 30 > 0 && other.canAttack()){
            this.hp -= other.getSelectedAttack().getBaseDamage() - 30;
        }
        if(!isAlive()) {
            this.hp = 0;
        }
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

    @Override
    public String getCardName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPokemon that = (AbstractPokemon) o;
        return id == that.id &&
                hp == that.hp &&
                getName().equals(that.getName()) &&
                getCountEnergy().equals(that.getCountEnergy()) &&
                attackList.equals(that.attackList);
    }
    //endregion

}
