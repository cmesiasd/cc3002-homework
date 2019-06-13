package cc3002.pokemon.grass;

import cc3002.energyCost.EnergyCost;
import cc3002.pokemon.fighting.BasicFightingPokemon;
import cc3002.abilities.Attack;
import cc3002.energy.fighting.FightingEnergy;
import cc3002.energy.fire.FireEnergy;
import cc3002.pokemon.fire.BasicFirePokemon;
import cc3002.energy.grass.GrassEnergy;
import cc3002.energy.lighting.LightingEnergy;
import cc3002.pokemon.lighting.BasicLightingPokemon;
import cc3002.energy.psychic.PsychicEnergy;
import cc3002.pokemon.psychic.BasicPsychicPokemon;
import cc3002.energy.water.WaterEnergy;
import cc3002.pokemon.water.BasicWaterPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BasicGrassPokemonTest {
    FightingEnergy fightingEnergy;
    BasicFightingPokemon basicFightingPokemon;
    FireEnergy fireEnergy;
    BasicFirePokemon basicFirePokemon;
    GrassEnergy grassEnergy;
    BasicGrassPokemon basicGrassPokemon;
    LightingEnergy lightingEnergy;
    BasicLightingPokemon basicLightingPokemon;
    PsychicEnergy psychicEnergy;
    BasicPsychicPokemon basicPsychicPokemon, basicPsychicPokemon2;
    WaterEnergy waterEnergy;
    BasicWaterPokemon basicWaterPokemon;
    EnergyCost At1, At2, At3, At4, At5, At6, At7, IniEnergy, FullEnergy;
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
        IniEnergy = new EnergyCost(0,0,0,0,0,0);
        FullEnergy = new EnergyCost(10,10,10,10,10,10);
        //endregion

        //region Grass Pokemon Bulbasaur
        At1 = new EnergyCost(0,0,0,0,0,2);
        At2 = new EnergyCost(0,0,0,1,0,2);
        At3 = new EnergyCost(0,1,0,0,0,3);
        attack1 = new Attack("Hoja Afilada", 30, "Permite robar una carta",At1);
        attack2 = new Attack("Hiedra adormidera", 35, "El pokemon danado pasa a estar dormido",At2);
        attack3 = new Attack("Polen Nocivo", 40, "Hace 10 de dano mas por cada energia tipo Grass",At3);
        LA_Bulbasaur = new ArrayList<>();
        LA_Bulbasaur.add(attack1);
        LA_Bulbasaur.add(attack2);
        LA_Bulbasaur.add(attack3);
        basicGrassPokemon = new BasicGrassPokemon("Bulbasaur",70,1,IniEnergy,LA_Bulbasaur);
        //endregion

        //region Fire Pokemon Charmander
        At4 = new EnergyCost(0,0,2,0,0,0);
        At5 = new EnergyCost(0,0,3,1,0,0);
        attack4 = new Attack("Ascuas", 20, "El pokemon danado descarga una enrgia",At4);
        attack5 = new Attack("Quemadura de lava", 30, "Quema al rival",At5);
        LA_Charmander = new ArrayList<>();
        LA_Charmander.add(attack4);
        LA_Charmander.add(attack5);
        basicFirePokemon = new BasicFirePokemon("Charmander",70,4,FullEnergy,LA_Charmander);
        //endregion

        //region Water Pokemon Squirtle
        At6 = new EnergyCost(2,0,0,1,0,0);
        At7 = new EnergyCost(2,0,0,2,0,0);
        attack6 = new Attack("Acua Cola", 45, "Vamoh a calmarnoh",At6);
        attack7 = new Attack("Ataque Caparazon", 70, "Atauqe fisico/aqua",At7);
        LA_Squirtle = new ArrayList<>();
        LA_Squirtle.add(attack6);
        LA_Squirtle.add(attack7);
        basicWaterPokemon = new BasicWaterPokemon("Squirtle",60,7,FullEnergy,LA_Squirtle);
        //endregion
    }

    @Test
    public void attack() {
        basicGrassPokemon.attack(basicFirePokemon,0);
        basicGrassPokemon.attack(basicWaterPokemon,1);
        assertEquals(70, basicFirePokemon.getHP());
        assertEquals(60, basicWaterPokemon.getHP());
    }

    @Test
    public void attackedByFirePokemon() {
        basicFirePokemon.attack(basicGrassPokemon,0);
        assertEquals(30, basicGrassPokemon.getHP());
        basicFirePokemon.attack(basicGrassPokemon,1);
        assertEquals(0, basicGrassPokemon.getHP());

    }

    @Test
    public void attackedByWaterPokemon() {
        basicWaterPokemon.attack(basicGrassPokemon,0);
        assertEquals(55, basicGrassPokemon.getHP());
        basicWaterPokemon.attack(basicGrassPokemon,1);
        assertEquals(15, basicGrassPokemon.getHP());
    }
}