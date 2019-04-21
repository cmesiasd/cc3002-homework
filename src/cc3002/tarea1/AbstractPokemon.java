package cc3002.tarea1;

import cc3002.tarea1.electric.ElectricAttack;
import cc3002.tarea1.fighting.FightingAttack;
import cc3002.tarea1.fire.FireAttack;
import cc3002.tarea1.grass.GrassAttack;
import cc3002.tarea1.psychic.PsychicAttack;
import cc3002.tarea1.water.WaterAttack;

import java.util.List;

public abstract class AbstractPokemon implements IPokemon {
    private String name;
    private int id;
    private int hp;
    private int countEnergy;
    private List<IAttack> attackList;
    private IAttack selectedAttack;

    /**
     * Creates a new Pokémon.
     *
     * @param name  Pokémon's name.
     * @param hp  Pokémon's hit points.
     * @param id Pokemon's id.
     * @param attackList  Pokémon's attacks.
     */
    protected AbstractPokemon(String name, int hp, int id, int countEnergy, List<IAttack> attackList) {
        this.name = name;
        this.id = id;
        this.hp = hp;
        this.countEnergy = countEnergy;
        this.attackList = attackList;
    }

    //region Propierties
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
    public int getCountEnergy() {
        return countEnergy;
    }

    @Override
    public List<IAttack> getAttacks() {
        return attackList;
    }

    @Override
    public IAttack getSelectedAttack() {
        return selectedAttack;
    }
    //endregion

    //region Attack
    @Override
    public void attack(IPokemon other) {
        selectedAttack.attack(other);
    }

    @Override
    public void selectAttack(int index) {
        selectedAttack = attackList.get(index);
    }
    //endregion

    //region Damage
    /**
     * Receives an attack.
     * @param attack  Received attack.
     */
    protected void receiveAttack(IAttack attack) {
        this.hp -= attack.getBaseDamage();
    }

    /**
     * Receives an attack to which this Pokémon is weak.
     * @param attack  Received attack.
     */
    protected void receiveWeaknessAttack(IAttack attack) {
        this.hp -= attack.getBaseDamage() * 2;
    }

    /**
     * Receives an attack to which this Pokémon is resistant.
     * @param attack  Received attack.
     */
    protected void receiveResistantAttack(IAttack attack) {
        this.hp -= attack.getBaseDamage() - 30;
    }

    @Override
    public void receiveWaterAttack(WaterAttack attack) {
        receiveAttack(attack);
    }

    @Override
    public void receiveGrassAttack(GrassAttack attack) {
        receiveAttack(attack);
    }

    @Override
    public void receiveFireAttack(FireAttack attack) {
        receiveAttack(attack);
    }

    @Override
    public void receiveFightingAttack(FightingAttack attack) {
        receiveAttack(attack);
    }

    @Override
    public void receivePsychicAttack(PsychicAttack attack) {
        receiveAttack(attack);
    }

    @Override
    public void receiveElectricAttack(ElectricAttack attack) {
        receiveAttack(attack);
    }
    //endregion
}
