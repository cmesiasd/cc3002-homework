package cc3002.pokemon.fighting;

import cc3002.abilities.Attack;
import cc3002.energy.water.WaterEnergy;
import cc3002.pokemon.lighting.LightingPokemon;
import cc3002.pokemon.psychic.PsychicPokemon;
import cc3002.energyCost.energyCost;
import cc3002.energy.fighting.FightingEnergy;
import cc3002.energy.fire.FireEnergy;
import cc3002.pokemon.fire.FirePokemon;
import cc3002.energy.grass.GrassEnergy;
import cc3002.pokemon.grass.GrassPokemon;
import cc3002.energy.lighting.LightingEnergy;
import cc3002.energy.psychic.PsychicEnergy;
import cc3002.pokemon.water.WaterPokemon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FightingPokemonTest {
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
    energyCost At1, At2, At3, At4, At5, At6, At7, IniEnergy, FullEnergy;
    Attack attack1, attack2, attack3, attack4, attack5, attack6, attack7;
    List<Attack> LA_Crobat, LA_Bulbasaur, LA_Lucario;

    @Before
    public void setUp() throws Exception {
        //region Energies
        psychicEnergy = new PsychicEnergy("psychic");
        waterEnergy = new WaterEnergy("water");
        grassEnergy = new GrassEnergy("grass");
        fireEnergy = new FireEnergy("fire");
        lightingEnergy = new LightingEnergy("lighting");
        fightingEnergy = new FightingEnergy("fighting");
        IniEnergy = new energyCost(0,0,0,0,0,0);
        FullEnergy = new energyCost(10,10,10,10,10,10);
        //endregion

        //region Psychic Pokemon Crobat
        At1 = new energyCost(0,2,0,1,0,0);
        At2 = new energyCost(0,2,1,1,0,0);
        attack1 = new Attack("Vista Nocturna", 40, "Permite robar una carta",At1);
        attack2 = new Attack("Colmillo Ultratoxico", 55, "El pokemon danado pasa a estar envenenado",At2);
        LA_Crobat = new ArrayList<>();
        LA_Crobat.add(attack1);
        LA_Crobat.add(attack2);
        psychicPokemon = new PsychicPokemon("Crobat",130,51,IniEnergy,LA_Crobat);
        //endregion

        //region Grass Pokemon Bulbasaur
        At3 = new energyCost(0,0,0,0,0,2);
        At4 = new energyCost(0,0,0,1,0,2);
        At5 = new energyCost(0,1,0,0,0,3);
        attack3 = new Attack("Hoja Afilada", 30, "Permite robar una carta",At3);
        attack4 = new Attack("Hiedra adormidera", 35, "El pokemon danado pasa a estar dormido",At4);
        attack5 = new Attack("Polen Nocivo", 40, "Hace 10 de dano mas por cada energia tipo Grass",At5);
        LA_Bulbasaur = new ArrayList<>();
        LA_Bulbasaur.add(attack3);
        LA_Bulbasaur.add(attack4);
        LA_Bulbasaur.add(attack5);
        grassPokemon = new GrassPokemon("Bulbasaur",70,1,FullEnergy,LA_Bulbasaur);
        //endregion

        //region Fighting Pokemon Lucario
        At6 = new energyCost(0,0,0,2,0,0);
        At7 = new energyCost(0,0,1,2,0,0);
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
        fightingPokemon.attack(psychicPokemon,1);
        Assert.assertEquals(90,psychicPokemon.getHP());
        fightingPokemon.attack(grassPokemon,0);
        assertEquals(25,grassPokemon.getHP());
    }

    @Test
    public void attackedByPsychicPokemon() {
        psychicPokemon.attack(fightingPokemon,0);
        Assert.assertEquals(160,fightingPokemon.getHP());
    }

    @Test
    public void attackedByGrassPokemon() {
        grassPokemon.attack(fightingPokemon,0);
        Assert.assertEquals(100,fightingPokemon.getHP());
    }
}