package cc3002.tarea1.water;

import cc3002.tarea1.AbstractPokemon;
import cc3002.tarea1.Attack;
import cc3002.tarea1.Cost;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.fire.FirePokemon;
import cc3002.tarea1.grass.GrassPokemon;
import cc3002.tarea1.lighting.LightingPokemon;

import java.util.ArrayList;
import java.util.List;

public class WaterPokemon extends AbstractPokemon {

    public WaterPokemon(String name, int hp, int id, Cost countEnergy, List<Attack> attackList) {
        super(name, hp, id, countEnergy, attackList);
    }

    @Override
    public void attackedByGrassPokemon(GrassPokemon grassPokemon) {
        receiveResistantAttack(grassPokemon);
    }

    @Override
    public void attackedByLightingPokemon(LightingPokemon lightingPokemon) {
        receiveResistantAttack(lightingPokemon);
    }

    @Override
    public void attackedByFirePokemon(FirePokemon firePokemon) {
        receiveWeaknessAttack(firePokemon);
    }

    public static void main(String[] args) {
        Cost c1 = new Cost();
        Cost c2 = new Cost();
        Attack at1 = new Attack("Surf",50,"Daña a los pkm en banca oponentes con 1 contador",c1);
        Attack at2= new Attack("Cascada",80,"Ataque físico",c2);

        List<Attack> LA_Empoleon = new ArrayList<>();
        LA_Empoleon.add(at1);
        LA_Empoleon.add(at2);
        WaterPokemon Empoleon = new WaterPokemon("Empoleon",100,01,c1,LA_Empoleon);



        Cost c3 = new Cost();
        Cost c4 = new Cost();
        Attack at3 = new Attack("ashgfj",20,"Aaaah",c3);
        Attack at4= new Attack("kjdagh",80,"casi",c4);

        List<Attack> LA_Squir = new ArrayList<>();
        LA_Squir.add(at3);
        LA_Squir.add(at4);
        GrassPokemon Squir = new GrassPokemon("Squirr",100,01,c3,LA_Squir);


       System.out.println(Squir.getAttacks().get(1).getName() );


        System.out.println("Squirtle ataca a Empoleon con Burbujas!");
        Squir.attack(Empoleon,0);
        System.out.println("Empoleon tiene " + Empoleon.getHP() + " HP");
        System.out.println("Empoleon ataca a Squirtle con Surf!");
        Empoleon.attack(Squir,0);
        System.out.println("Squirtle tiene " + Squir.getHP() + " HP");
    }
}
