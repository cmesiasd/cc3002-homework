package cc3002.pokemon.fire;

import cc3002.abilities.Attack;
import cc3002.energyCost.EnergyCost;
import cc3002.pokemon.fighting.BasicFightingPokemon;
import cc3002.pokemon.lighting.BasicLightingPokemon;
import cc3002.pokemon.psychic.BasicPsychicPokemon;
import cc3002.energy.fighting.FightingEnergy;
import cc3002.energy.fire.FireEnergy;
import cc3002.energy.grass.GrassEnergy;
import cc3002.pokemon.grass.BasicGrassPokemon;
import cc3002.energy.lighting.LightingEnergy;
import cc3002.energy.psychic.PsychicEnergy;
import cc3002.energy.water.WaterEnergy;
import cc3002.pokemon.water.BasicWaterPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BasicFirePokemonTest {
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
    List<Attack> LA_Charmander, LA_Squirtle, LA_Crobat;
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

        //region Psychic Pokemon Crobat
        At1 = new EnergyCost(0,2,0,1,0,0);
        At2 = new EnergyCost(0,2,1,1,0,0);
        At3 = new EnergyCost(1,3,0,0,0,0);
        attack1 = new Attack("Vista Nocturna", 40, "Permite robar una carta",At1);
        attack2 = new Attack("Colmillo Ultratoxico", 55, "El pokemon danado pasa a estar envenenado",At2);
        attack3 = new Attack("Golpe Sorpresa", 60, "Hace 10 de dano mas por cada energia tipo Psiquica",At3);
        LA_Crobat = new ArrayList<>();
        LA_Crobat.add(attack1);
        LA_Crobat.add(attack2);
        LA_Crobat.add(attack3);
        basicPsychicPokemon = new BasicPsychicPokemon("Crobat",130,51,IniEnergy,LA_Crobat);
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
        basicFirePokemon.attack(basicPsychicPokemon,0);
        assertEquals(110, basicPsychicPokemon.getHP());
        basicFirePokemon.attack(basicWaterPokemon,1);
        assertNotEquals(10, basicWaterPokemon.getHP());
        assertEquals(30, basicWaterPokemon.getHP());
    }

    @Test
    public void attackedByWaterPokemon() {
        basicWaterPokemon.attack(basicFirePokemon,0);
        assertNotEquals(25, basicFirePokemon.getHP());
        assertEquals(0, basicFirePokemon.getHP());
    }

}