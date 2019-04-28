package cc3002.tarea1.water;

import cc3002.tarea1.Attack;
import cc3002.tarea1.Cost;
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
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WaterPokemonTest {
    FightingEnergy fightingEnergy;
    FightingPokemon fightingPokemon;
    FireEnergy fireEnergy;
    FirePokemon firePokemon;
    GrassEnergy grassEnergy;
    GrassPokemon grassPokemon;
    LightingEnergy lightingEnergy;
    LightingPokemon lightingPokemon;
    PsychicEnergy psychicEnergy;
    PsychicPokemon psychicPokemon;
    WaterEnergy waterEnergy;
    WaterPokemon waterPokemon;
    Cost At1, At2, At3, At4, At5, At6, At7, At8,At9, IniEnergy, FullEnergy;
    Attack attack1, attack2, attack3, attack4, attack5, attack6, attack7,attack8,attack9;
    List<Attack> LA_Squirtle, LA_Bulbasaur, LA_Lucario, LA_Pikachu;

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

        //region Water Pokemon Squirtle
        At1 = new Cost(2,0,0,1,0,0);
        At2 = new Cost(2,0,0,2,0,0);
        attack1 = new Attack("Acua Cola", 45, "Vamoh a calmarnoh",At1);
        attack2 = new Attack("Ataque Caparazon", 70, "Ataque fisico/aqua",At2);
        LA_Squirtle = new ArrayList<>();
        LA_Squirtle.add(attack1);
        LA_Squirtle.add(attack2);
        waterPokemon = new WaterPokemon("Squirtle",60,7,FullEnergy,LA_Squirtle);
        //endregion

        //region Grass Pokemon Bulbasaur
        At3 = new Cost(0,0,0,0,0,2);
        At4 = new Cost(0,0,0,1,0,2);
        At5 = new Cost(0,1,0,0,0,3);
        attack3 = new Attack("Hoja Afilada", 30, "Permite robar una carta",At3);
        attack4 = new Attack("Hiedra adormidera", 35, "El pokemon danado pasa a estar dormido",At4);
        attack5 = new Attack("Polen Nocivo", 40, "Hace 10 de dano mas por cada energia tipo Grass",At5);
        LA_Bulbasaur = new ArrayList<>();
        LA_Bulbasaur.add(attack3);
        LA_Bulbasaur.add(attack4);
        LA_Bulbasaur.add(attack5);
        grassPokemon = new GrassPokemon("Bulbasaur",70,1,FullEnergy,LA_Bulbasaur);
        //endregion

        //region Lighting Pokemon Pikachu
        At6 = new Cost(0,0,0,1,1,0);
        At7 = new Cost(0,0,0,1,2,0);
        attack6 = new Attack("Ataque Rápido", 30, "Si el pokemon no es de tipo electrico duplica el dano",At6);
        attack7 = new Attack("Impact Trueno", 45, "El pokemon danado pasa a estar Paralizado",At7);
        LA_Pikachu = new ArrayList<>();
        LA_Pikachu.add(attack6);
        LA_Pikachu.add(attack7);
        lightingPokemon = new LightingPokemon("Pikachu",70,76,FullEnergy,LA_Pikachu);
        //endregion

        //region Fighting Pokemon Lucario
        At8 = new Cost(0,0,0,2,0,0);
        At9 = new Cost(0,0,1,2,0,0);
        attack8 = new Attack("Derrumbar", 45, "Derrumba al pokemon",At8);
        attack9 = new Attack("Patada magnum", 70, "El pokemon danado queda Aturdido",At9);
        LA_Lucario = new ArrayList<>();
        LA_Lucario.add(attack8);
        LA_Lucario.add(attack9);
        fightingPokemon = new FightingPokemon("Lucario",160,4,FullEnergy,LA_Lucario);
        //endregion

    }

    @Test
    public void attack() {
        waterPokemon.attack(grassPokemon,0);
        assertEquals(55,grassPokemon.getHP());
        waterPokemon.attack(grassPokemon,1);
        waterPokemon.attack(grassPokemon,1);
        assertEquals(0,grassPokemon.getHP());
        waterPokemon.attack(fightingPokemon,0);
        assertEquals(115,fightingPokemon.getHP());
    }

    @Test
    public void attackedByGrassPokemon() {
        grassPokemon.attack(waterPokemon,1);
        assertEquals(0,waterPokemon.getHP());
    }

    @Test
    public void attackedByLightingPokemon() {
        lightingPokemon.attack(waterPokemon,1);
        assertEquals(0,waterPokemon.getHP());
    }

    @Test
    public void attackedByFightingPokemon() {
        fightingPokemon.attack(waterPokemon,0);
        assertEquals(45,waterPokemon.getHP());
    }
}