package cc3002.tarea1.water;

import cc3002.tarea1.AbstractPokemon;
import cc3002.tarea1.Attack;
import cc3002.tarea1.Cost;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.fighting.FightingPokemon;
import cc3002.tarea1.grass.GrassPokemon;
import cc3002.tarea1.lighting.LightingPokemon;

import java.util.ArrayList;
import java.util.List;

public class WaterPokemon extends AbstractPokemon {

    public WaterPokemon(String name, int hp, int id, Cost countEnergy, List<Attack> attackList) {
        super(name, hp, id, countEnergy, attackList);
    }

    @Override
    public void attack(IPokemon other, int index) {
        this.selectAttack(index);
        other.attackedByWaterPokemon(this);
    }

    @Override
    public void attackedByGrassPokemon(GrassPokemon grassPokemon) {
        receiveWeaknessAttack(grassPokemon);
    }

    @Override
    public void attackedByLightingPokemon(LightingPokemon lightingPokemon) {
        receiveWeaknessAttack(lightingPokemon);
    }

    @Override
    public void attackedByFightingPokemon(FightingPokemon fightingPokemon) {
        receiveResistantAttack(fightingPokemon);
    }

    public static void main(String[] args) {
        Cost c1 = new Cost();
        Cost c2 = new Cost();

        c1.getKeys(c1);

        Attack at1 = new Attack("Surf",50,"Daña a los pkm en banca oponentes con 1 contador",c1);
        Attack at2= new Attack("Cascada",50,"Ataque físico",c2);

        List<Attack> LA_Empoleon = new ArrayList<>();
        LA_Empoleon.add(at1);
        LA_Empoleon.add(at2);
        WaterPokemon Empoleon = new WaterPokemon("Empoleon",100,01,c1,LA_Empoleon);



        Cost c3 = new Cost();
        Cost c4 = new Cost();
        Attack at3 = new Attack("PlantaMala",50,"Aaaah",c3);
        Attack at4= new Attack("Marihuana",50,"casi",c4);

        List<Attack> LA_Squir = new ArrayList<>();
        LA_Squir.add(at3);
        LA_Squir.add(at4);
        GrassPokemon Balbausur = new GrassPokemon("Balbausur",100,01,c3,LA_Squir);



        Balbausur.attack(Empoleon,1);
        System.out.println(Balbausur.getName() + " ataca a Empoleon con " + Balbausur.getSelectedAttack().getName());
        System.out.println("Empoleon tiene " + Empoleon.getHP() + " HP");

        Empoleon.attack(Balbausur,1);
        System.out.println(Empoleon.getName() + " ataca a Balbausur con " + Empoleon.getSelectedAttack().getName());
        System.out.println("Balbausur tiene " + Balbausur.getHP() + " HP");
    }
}
