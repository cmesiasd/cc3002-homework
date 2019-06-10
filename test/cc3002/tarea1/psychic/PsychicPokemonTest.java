package cc3002.tarea1.psychic;

import cc3002.tarea1.Attack;
import cc3002.tarea1.cost.Cost;
import cc3002.tarea1.energy.fighting.FightingEnergy;
import cc3002.tarea1.pokemon.fighting.FightingPokemon;
import cc3002.tarea1.energy.fire.FireEnergy;
import cc3002.tarea1.pokemon.fire.FirePokemon;
import cc3002.tarea1.energy.grass.GrassEnergy;
import cc3002.tarea1.pokemon.grass.GrassPokemon;
import cc3002.tarea1.energy.lighting.LightingEnergy;
import cc3002.tarea1.pokemon.lighting.LightingPokemon;
import cc3002.tarea1.energy.psychic.PsychicEnergy;
import cc3002.tarea1.pokemon.psychic.PsychicPokemon;
import cc3002.tarea1.energy.water.WaterEnergy;
import cc3002.tarea1.pokemon.water.WaterPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PsychicPokemonTest {
    FightingEnergy fightingEnergy;
    FightingPokemon fightingPokemon;
    FireEnergy fireEnergy;
    FirePokemon firePokemon;
    GrassEnergy grassEnergy;
    GrassPokemon grassPokemon;
    LightingEnergy lightingEnergy;
    LightingPokemon lightingPokemon;
    PsychicEnergy psychicEnergy;
    PsychicPokemon psychicPokemon, psychicPokemon2;
    WaterEnergy waterEnergy;
    WaterPokemon waterPokemon;
    Cost At1, At2, At3, At4, At5, At6, At7, IniEnergy, FullEnergy;
    Attack attack1, attack2, attack3, attack4, attack5, attack6, attack7;
    List<Attack> LA_Crobat, LA_Espeon, LA_Lucario;

    @Before
    public void setUp() throws Exception {

        //region Energies
        psychicEnergy = new PsychicEnergy("psychic");
        waterEnergy = new WaterEnergy("water");
        grassEnergy = new GrassEnergy("grass");
        fireEnergy = new FireEnergy("fire");
        lightingEnergy = new LightingEnergy("lighting");
        fightingEnergy = new FightingEnergy("fighting");
        IniEnergy = new Cost(0,0,0,0,0,0);
        FullEnergy = new Cost(10,10,10,10,10,10);
        //endregion

        //region Psychic Pokemon Crobat
        At1 = new Cost(0,2,0,1,0,0);
        At2 = new Cost(0,2,1,1,0,0);
        At3 = new Cost(1,3,0,0,0,0);
        attack1 = new Attack("Vista Nocturna", 40, "Permite robar una carta",At1);
        attack2 = new Attack("Colmillo Ultratoxico", 55, "El pokemon danado pasa a estar envenenado",At2);
        attack3 = new Attack("Golpe Sorpresa", 60, "Hace 10 de dano mas por cada energia tipo Psiquica",At3);
        LA_Crobat = new ArrayList<>();
        LA_Crobat.add(attack1);
        LA_Crobat.add(attack2);
        LA_Crobat.add(attack3);
        psychicPokemon = new PsychicPokemon("Crobat",130,51,IniEnergy,LA_Crobat);
        //endregion

        //region Psychic Pokemon Espeon
        At4 = new Cost(0,2,1,0,0,0);
        At5 = new Cost(1,2,1,1,0,0);
        attack4 = new Attack("Psicorrayo", 45, "El Pokemon danado pasa a estar Confundido",At4);
        attack5 = new Attack("Psicocarga", 70, "El daño de este ataque no se ve afectado " +
                "por ningún efecto en el Pokémon Activo de tu rival.",At5);
        LA_Espeon = new ArrayList<>();
        LA_Espeon.add(attack4);
        LA_Espeon.add(attack5);
        psychicPokemon2 = new PsychicPokemon("Espeon",170,50,FullEnergy,LA_Espeon);
        //endregion

        //region Fighting Pokemon Lucario
        At6 = new Cost(0,0,0,2,0,0);
        At7 = new Cost(0,0,1,2,0,0);
        attack6 = new Attack("Derrumbar", 45, "Derrumba al pokemon",At6);
        attack7 = new Attack("Patada magnum", 70, "El pokemon danado queda Aturdido",At7);
        LA_Lucario = new ArrayList<>();
        LA_Lucario.add(attack6);
        LA_Lucario.add(attack7);
        fightingPokemon = new FightingPokemon("Lucario",160,4,FullEnergy,LA_Lucario);
        //endregion


    }

    @Test
    public void attack() {
        psychicPokemon.attack(psychicPokemon2,2);
        psychicPokemon2.attack(fightingPokemon,1);
        assertEquals(130,psychicPokemon.getHP());
        assertEquals(20,fightingPokemon.getHP());
        //El Pokemon recibe energías y puede ejecutar el ataque
        psychicPokemon.receivePsychicEnergy(psychicEnergy);
        psychicPokemon.receivePsychicEnergy(psychicEnergy);
        psychicPokemon.receivePsychicEnergy(psychicEnergy);
        psychicPokemon.receiveWaterEnergy(waterEnergy);
        psychicPokemon.attack(psychicPokemon2,2);
        assertEquals(50,psychicPokemon2.getHP());
    }

    @Test
    public void attackedByFightingPokemon(){
        fightingPokemon.attack(psychicPokemon,0);
        fightingPokemon.attack(psychicPokemon2,1);
        assertEquals(130,psychicPokemon2.getHP());
        assertEquals(115,psychicPokemon.getHP());
    }

    @Test
    public void attackedByPsychicPokemon(){
        psychicPokemon.attack(psychicPokemon2,0);
        psychicPokemon2.attack(psychicPokemon,0);
        assertEquals(170,psychicPokemon2.getHP());
        assertEquals(40,psychicPokemon.getHP());
    }



}