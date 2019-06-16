package cc3002.energy;

import cc3002.abilities.Ability;
import cc3002.abilities.Attack;
import cc3002.energyCost.EnergyCost;
import cc3002.energy.fighting.FightingEnergy;
import cc3002.energy.fire.FireEnergy;
import cc3002.energy.grass.GrassEnergy;
import cc3002.energy.lighting.LightingEnergy;
import cc3002.energy.psychic.PsychicEnergy;
import cc3002.pokemon.psychic.BasicPsychicPokemon;
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
    BasicPsychicPokemon basicPsychicPokemon;
    EnergyCost At1, At2, IniEnergy;
    Attack attack1, attack2;
    List<Ability> LA_Mewtwo;


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
        IniEnergy = new EnergyCost(0,0,0,0,0,0);
        //endregion

        //region Grass Pokemon Mewtwo
        At1 = new EnergyCost(0,3,0,0,0,0);
        At2 = new EnergyCost(0,3,0,1,0,0);
        attack1 = new Attack("Superrayo Psi", 100, "El Pokémon Activo de tu rival pasa a estar Paralizado",At1);
        attack2 = new Attack("Filo Zen", 110, "Este Pokémon no puede usar Filo Zen durante tu próximo turno",At2);
        LA_Mewtwo = new ArrayList<>();
        LA_Mewtwo.add(attack1);
        LA_Mewtwo.add(attack2);
        basicPsychicPokemon = new BasicPsychicPokemon("Mewtwo",120,400,IniEnergy,LA_Mewtwo);
        //endregion
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
        waterEnergy.useEnergyCard(basicPsychicPokemon);
        fightingEnergy.useEnergyCard(basicPsychicPokemon);
        fireEnergy.useEnergyCard(basicPsychicPokemon);
        grassEnergy.useEnergyCard(basicPsychicPokemon);
        psychicEnergy.useEnergyCard(basicPsychicPokemon);
        lightingEnergy.useEnergyCard(basicPsychicPokemon);
        assertEquals(new EnergyCost(1,1,1,1,1,1), basicPsychicPokemon.getCountEnergy());
        lightingEnergy.useEnergyCard(basicPsychicPokemon);
        assertEquals(new EnergyCost(1,1,1,1,2,1), basicPsychicPokemon.getCountEnergy());

    }
}