package cc3002.tarea1.grass;

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

public class GrassPokemonTest {
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
    List<Attack> LA_Bulbasaur, LA_Charmander, LA_Squirtle;

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

        //region Grass Pokemon Bulbasaur
        At1 = new Cost(0,0,0,0,0,2);
        At2 = new Cost(0,0,0,1,0,2);
        At3 = new Cost(0,1,0,0,0,3);
        attack1 = new Attack("Hoja Afilada", 30, "Permite robar una carta",At1);
        attack2 = new Attack("Hiedra adormidera", 35, "El pokemon danado pasa a estar dormido",At2);
        attack3 = new Attack("Polen Nocivo", 40, "Hace 10 de dano mas por cada energia tipo Grass",At3);
        LA_Bulbasaur = new ArrayList<>();
        LA_Bulbasaur.add(attack1);
        LA_Bulbasaur.add(attack2);
        LA_Bulbasaur.add(attack3);
        grassPokemon = new GrassPokemon("Bulbasaur",70,1,IniEnergy,LA_Bulbasaur);
        //endregion

        //region Fire Pokemon Charmander
        At4 = new Cost(0,0,2,0,0,0);
        At5 = new Cost(0,0,3,1,0,0);
        attack4 = new Attack("Ascuas", 20, "El pokemon danado descarga una enrgia",At4);
        attack5 = new Attack("Quemadura de lava", 30, "Quema al rival",At5);
        LA_Charmander = new ArrayList<>();
        LA_Charmander.add(attack4);
        LA_Charmander.add(attack5);
        firePokemon = new FirePokemon("Charmander",70,4,FullEnergy,LA_Charmander);
        //endregion

        //region Water Pokemon Squirtle
        At6 = new Cost(2,0,0,1,0,0);
        At7 = new Cost(2,0,0,2,0,0);
        attack6 = new Attack("Acua Cola", 45, "Vamoh a calmarnoh",At6);
        attack7 = new Attack("Ataque Caparazon", 70, "Atauqe fisico/aqua",At7);
        LA_Squirtle = new ArrayList<>();
        LA_Squirtle.add(attack6);
        LA_Squirtle.add(attack7);
        waterPokemon = new WaterPokemon("Squirtle",60,7,FullEnergy,LA_Squirtle);
        //endregion
    }

    @Test
    public void attack() {
        grassPokemon.attack(firePokemon,0);
        grassPokemon.attack(waterPokemon,1);
        assertEquals(70,firePokemon.getHP());
        assertEquals(60,waterPokemon.getHP());
    }

    @Test
    public void attackedByFirePokemon() {
        firePokemon.attack(grassPokemon,0);
        assertEquals(30,grassPokemon.getHP());
        firePokemon.attack(grassPokemon,1);
        assertEquals(0,grassPokemon.getHP());

    }

    @Test
    public void attackedByWaterPokemon() {
        waterPokemon.attack(grassPokemon,0);
        assertEquals(55,grassPokemon.getHP());
        waterPokemon.attack(grassPokemon,1);
        assertEquals(15,grassPokemon.getHP());
    }
}