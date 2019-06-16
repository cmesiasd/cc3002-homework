package cc3002.pokemon;

import cc3002.AbstractCard;
import cc3002.abilities.Ability;
import cc3002.abilities.Attack;
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
import cc3002.visitor.IVisitorCard;

import java.util.List;
import java.util.Map;

/**
 * Abstract Pokemon
 * Implements IPokemon and ICard
 *
 * @author cmesiasd
 * @version 1.0
 */
public abstract class AbstractPokemon extends AbstractCard implements IPokemon{
    private String cardName;
    private int id;
    private int hp;
    private EnergyCost countEnergy;
    private List<Ability> attackList;
    private Attack selectedAttack;

    /**
     * Creates a new Pokémon.
     *  @param cardName    Pokémon's name.
     * @param hp          Pokémon's hit points.
     * @param id          Pokemon's id.
     * @param countEnergy Pokemon's counter energies
     * @param attackList  Pokémon's attacks list.
     */
    protected AbstractPokemon(String cardName, int hp, int id, EnergyCost countEnergy, List<Ability> attackList) {
        super(cardName);
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

    public int getHP() {
        return hp;
    }

    public int getID() {
        return id;
    }

    public EnergyCost getCountEnergy() {
        return countEnergy;
    }

    @Override
    public void setCountEnergy(EnergyCost countEnergy) {
        this.countEnergy = countEnergy;
    }

    public List<Ability> getAttacks() {
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
        selectedAttack = (Attack) attackList.get(index);
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
        this.countEnergy.getCost().put(waterEnergy.getCardName(), this.countEnergy.getCost().get(waterEnergy.getCardName())+1);
    }

    public void receiveFireEnergy(FireEnergy fireEnergy){
        this.countEnergy.getCost().put(fireEnergy.getCardName(), this.countEnergy.getCost().get(fireEnergy.getCardName())+1);
    }

    public void receiveGrassEnergy(GrassEnergy grassEnergy){
        this.countEnergy.getCost().put(grassEnergy.getCardName(), this.countEnergy.getCost().get(grassEnergy.getCardName())+1);
    }

    public void receiveFightingEnergy(FightingEnergy fightingEnergy){
        this.countEnergy.getCost().put(fightingEnergy.getCardName(), this.countEnergy.getCost().get(fightingEnergy.getCardName())+1);
    }

    public void receiveLightingEnergy(LightingEnergy lightingEnergy){
        this.countEnergy.getCost().put(lightingEnergy.getCardName(), this.countEnergy.getCost().get(lightingEnergy.getCardName())+1);
    }

    public void receivePsychicEnergy(PsychicEnergy psychicEnergy){
        this.countEnergy.getCost().put(psychicEnergy.getCardName(), this.countEnergy.getCost().get(psychicEnergy.getCardName())+1);
    }
    //endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPokemon that = (AbstractPokemon) o;
        return id == that.id &&
                hp == that.hp &&
                getCardName().equals(that.getCardName()) &&
                getCountEnergy().equals(that.getCountEnergy()) &&
                attackList.equals(that.attackList);
    }


}
