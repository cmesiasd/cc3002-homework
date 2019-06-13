package cc3002.pokemon.lighting;

import cc3002.pokemon.fighting.FightingPokemon;
import cc3002.Attack;
import cc3002.cost.Cost;
import cc3002.energy.fighting.FightingEnergy;
import cc3002.energy.fire.FireEnergy;
import cc3002.pokemon.fire.FirePokemon;
import cc3002.energy.grass.GrassEnergy;
import cc3002.pokemon.grass.GrassPokemon;
import cc3002.energy.lighting.LightingEnergy;
import cc3002.energy.psychic.PsychicEnergy;
import cc3002.pokemon.psychic.PsychicPokemon;
import cc3002.energy.water.WaterEnergy;
import cc3002.pokemon.water.WaterPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LightingPokemonTest {
    FightingEnergy fightingEnergy;
    FightingPokemon fightingPokemon;
    FireEnergy fireEnergy;
    FirePokemon firePokemon;
    GrassEnergy grassEnergy;
    GrassPokemon grassPokemon;
    LightingEnergy lightingEnergy;
    LightingPokemon lightingPokemon, lightingPokemon2;
    PsychicEnergy psychicEnergy;
    PsychicPokemon psychicPokemon;
    WaterEnergy waterEnergy;
    WaterPokemon waterPokemon;
    Cost At1, At2, At3, At4, At5, At6, At7, IniEnergy, FullEnergy;
    Attack attack1, attack2, attack3, attack4, attack5, attack6, attack7;
    List<Attack> LA_Pikachu, LA_Espeon, LA_Lucario;

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

        //region Lighting Pokemon Pikachu
        At1 = new Cost(0,0,0,1,1,0);
        At2 = new Cost(0,0,0,1,2,0);
        At3 = new Cost(0,0,0,0,3,0);
        attack1 = new Attack("Ataque Rápido", 30, "Si el pokemon no es de tipo electrico duplica el dano",At1);
        attack2 = new Attack("Impact Trueno", 45, "El pokemon danado pasa a estar Paralizado",At2);
        attack3 = new Attack("Bola Voltio", 50, "Hace 10 de dano mas por cada energia tipo Electrico",At3);
        LA_Pikachu = new ArrayList<>();
        LA_Pikachu.add(attack1);
        LA_Pikachu.add(attack2);
        LA_Pikachu.add(attack3);
        lightingPokemon = new LightingPokemon("Pikachu",70,76,FullEnergy,LA_Pikachu);
        //endregion

        //region Lighting Pokemon Electrode
        At4 = new Cost(0,2,1,0,0,0);
        At5 = new Cost(1,2,1,1,0,0);
        attack4 = new Attack("Electrorrayo", 45, "El Pokemon danado pasa a estar Confundido",At4);
        attack5 = new Attack("Pistola Electrica", 70, "Ataque electrico paralizador",At5);
        LA_Espeon = new ArrayList<>();
        LA_Espeon.add(attack4);
        LA_Espeon.add(attack5);
        lightingPokemon2 = new LightingPokemon("Electrode",100,200,FullEnergy,LA_Espeon);
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
        lightingPokemon.attack(lightingPokemon2,1);
        lightingPokemon2.attack(fightingPokemon,0);
        assertEquals(55,lightingPokemon2.getHP());
        assertEquals(115,fightingPokemon.getHP());
    }

    @Test
    public void attackedByFightingPokemon() {
        fightingPokemon.attack(lightingPokemon,0);
        fightingPokemon.attack(lightingPokemon2,1);
        assertEquals(0,lightingPokemon2.getHP());
        assertEquals(0,lightingPokemon.getHP());
    }
}