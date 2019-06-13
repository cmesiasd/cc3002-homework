package cc3002.energy;

import cc3002.abilities.Attack;
import cc3002.energyCost.energyCost;
import cc3002.energy.fighting.FightingEnergy;
import cc3002.energy.fire.FireEnergy;
import cc3002.energy.grass.GrassEnergy;
import cc3002.energy.lighting.LightingEnergy;
import cc3002.energy.psychic.PsychicEnergy;
import cc3002.pokemon.psychic.PsychicPokemon;
import cc3002.energy.water.WaterEnergy;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AbstractEnergyTest {
    FightingEnergy fightingEnergy;
    FireEnergy fireEnergy;
    GrassEnergy grassEnergy, grassEnergy2;
    LightingEnergy lightingEnergy;
    PsychicEnergy psychicEnergy,psychicEnergy2;
    WaterEnergy waterEnergy;
    PsychicPokemon psychicPokemon;
    energyCost At1, At2, IniEnergy;
    Attack attack1, attack2;
    List<Attack> LA_Mewtwo;


    @Before
    public void setUp() throws Exception {
        //region Energies
        psychicEnergy = new PsychicEnergy("psychic");
        psychicEnergy2 = new PsychicEnergy("psychic");
        waterEnergy = new WaterEnergy("water");
        grassEnergy = new GrassEnergy("grass");
        grassEnergy2 = new GrassEnergy("grass");
        fireEnergy = new FireEnergy("fire");
        lightingEnergy = new LightingEnergy("lighting");
        fightingEnergy = new FightingEnergy("fighting");
        IniEnergy = new energyCost(0,0,0,0,0,0);
        //endregion

        //region Grass Pokemon Mewtwo
        At1 = new energyCost(0,3,0,0,0,0);
        At2 = new energyCost(0,3,0,1,0,0);
        attack1 = new Attack("Superrayo Psi", 100, "El Pokémon Activo de tu rival pasa a estar Paralizado",At1);
        attack2 = new Attack("Filo Zen", 110, "Este Pokémon no puede usar Filo Zen durante tu próximo turno",At2);
        LA_Mewtwo = new ArrayList<>();
        LA_Mewtwo.add(attack1);
        LA_Mewtwo.add(attack2);
        psychicPokemon = new PsychicPokemon("Mewtwo",120,400,IniEnergy,LA_Mewtwo);
        //endregion
    }

    @Test
    public void getType() {
        assertEquals("water",waterEnergy.getType());
        assertEquals("fire",fireEnergy.getType());
        assertEquals("fighting",fightingEnergy.getType());
    }

    @Test
    public void getCardName() {
        assertNotEquals("fighting",lightingEnergy.getCardName());
        assertNotEquals("lighting",fightingEnergy.getCardName());
        assertNotEquals("Water",waterEnergy.getCardName());
    }

    @Test
    public void equals1() {
        assertFalse(waterEnergy.equals(fireEnergy));
        assertTrue(psychicEnergy.equals(psychicEnergy2));
        assertTrue(grassEnergy2.equals(grassEnergy));
    }

    @Test
    public void useEnergyCard(){
        waterEnergy.useEnergyCard(psychicPokemon);
        fightingEnergy.useEnergyCard(psychicPokemon);
        fireEnergy.useEnergyCard(psychicPokemon);
        grassEnergy.useEnergyCard(psychicPokemon);
        psychicEnergy.useEnergyCard(psychicPokemon);
        lightingEnergy.useEnergyCard(psychicPokemon);
        assertEquals(new energyCost(1,1,1,1,1,1),psychicPokemon.getCountEnergy());
        lightingEnergy.useEnergyCard(psychicPokemon);
        assertEquals(new energyCost(1,1,1,1,2,1),psychicPokemon.getCountEnergy());

    }
}