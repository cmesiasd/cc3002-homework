package cc3002.pokemon;

import cc3002.abilities.Attack;
import cc3002.Trainer;
import cc3002.energyCost.EnergyCost;
import cc3002.energy.fighting.FightingEnergy;
import cc3002.energy.fire.FireEnergy;
import cc3002.pokemon.fighting.AbstractFightingPokemon;
import cc3002.pokemon.fire.AbstractFirePokemon;
import cc3002.energy.grass.GrassEnergy;
import cc3002.pokemon.grass.AbstractGrassPokemon;
import cc3002.energy.lighting.LightingEnergy;
import cc3002.pokemon.lighting.AbstractLightingPokemon;
import cc3002.energy.psychic.PsychicEnergy;
import cc3002.pokemon.psychic.AbstractPsychicPokemon;
import cc3002.energy.water.WaterEnergy;
import cc3002.pokemon.water.AbstractWaterPokemon;

import java.util.List;
import java.util.Map;

/**
 * Abstract Pokemon
 * Implements IPokemon and ICard
 *
 * @author cmesiasd
 * @version 1.0
 */
public abstract class AbstractPokemon implements IPokemon{
    private String name;
    private int id;
    private int hp;
    private EnergyCost countEnergy;
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
    protected AbstractPokemon(String name, int hp, int id, EnergyCost countEnergy, List<Attack> attackList) {
        this.name = name;
        this.id = id;
        this.hp = hp;
        this.countEnergy = countEnergy;
        this.attackList = attackList;
        for (int i = 0; this.attackList.size()-4>i;i++) {
            if(this.attackList.size()>4)
                this.attackList.remove(4);
        }
    }

    //region Properties
    public String getName() {
        return name;
    }

    public int getHP() {
        return hp;
    }

    public int getID() {
        return id;
    }

    public EnergyCost getCountEnergy() {
        return countEnergy;
    }

    public List<Attack> getAttacks() {
        return attackList;
    }

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


    public void selectAttack(int index) {
        selectedAttack = attackList.get(index);
    }

    public boolean canAttack() {
        for (Map.Entry<String, Integer> entry1 : this.getSelectedAttack().getEnergyCost().getCost().entrySet()) {
            String k = entry1.getKey();
            //Compara los key si son iguales.
            if(this.getCountEnergy().getCost().containsKey(k)) {
                //si son iguales obtiene los valores.
                Integer value1 = entry1.getValue(); //Costo ataque
                Integer value2 = this.getCountEnergy().getCost().get(k); //Energias
                if (value1 > value2) {
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
    public void attackedByWaterPokemon(AbstractWaterPokemon waterPokemon) {
        receiveAttack(waterPokemon);
    }

    @Override
    public void attackedByGrassPokemon(AbstractGrassPokemon grassPokemon) {
        receiveAttack(grassPokemon);
    }

    @Override
    public void attackedByFirePokemon(AbstractFirePokemon firePokemon) {
        receiveAttack(firePokemon);
    }

    @Override
    public void attackedByFightingPokemon(AbstractFightingPokemon fightingPokemon) {
        receiveAttack(fightingPokemon);
    }

    @Override
    public void attackedByPsychicPokemon(AbstractPsychicPokemon psychicPokemon) {
        receiveAttack(psychicPokemon);
    }

    @Override
    public void attackedByLightingPokemon(AbstractLightingPokemon lightingPokemon) {
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
        return this.name;
    }

    @Override
    public void playCard(Trainer aTrainer) {
        aTrainer.playPokemonCard(this);
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
