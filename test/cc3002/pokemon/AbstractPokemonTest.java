package cc3002.pokemon;

import cc3002.pokemon.fighting.FightingPokemon;
import cc3002.Attack;
import cc3002.cost.Cost;
import cc3002.energy.fighting.FightingEnergy;
import cc3002.energy.fire.FireEnergy;
import cc3002.pokemon.fire.FirePokemon;
import cc3002.energy.grass.GrassEnergy;
import cc3002.pokemon.grass.GrassPokemon;
import cc3002.energy.lighting.LightingEnergy;
import cc3002.pokemon.lighting.LightingPokemon;
import cc3002.energy.psychic.PsychicEnergy;
import cc3002.pokemon.psychic.PsychicPokemon;
import cc3002.energy.water.WaterEnergy;
import cc3002.pokemon.water.WaterPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AbstractPokemonTest {
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
    WaterPokemon waterPokemon, waterPokemon2;
    Cost At1, At2, At3, At4, IniEnergy, FullEnergy;
    Attack attack1, attack2, attack3, attack4;
    List<Attack> LA_Mewtwo, LA_Lapras;

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

        //region Grass Pokemon Mewtwo
        At1 = new Cost(0,3,0,0,0,0);
        At2 = new Cost(0,3,0,1,0,0);
        attack1 = new Attack("Superrayo Psi", 100, "El Pokémon Activo de tu rival pasa a estar Paralizado",At1);
        attack2 = new Attack("Filo Zen", 110, "Este Pokémon no puede usar Filo Zen durante tu próximo turno",At2);
        LA_Mewtwo = new ArrayList<>();
        LA_Mewtwo.add(attack1);
        LA_Mewtwo.add(attack2);
        psychicPokemon = new PsychicPokemon("Mewtwo",120,400,FullEnergy,LA_Mewtwo);
        //endregion

        //region Water Pokemon Lapras
        At3 = new Cost(2,0,0,1,0,0);
        At4 = new Cost(2,0,0,2,0,0);
        attack3 = new Attack("Hidrobomba", 60, "El Pokémon Activo de tu rival pasa a estar Paralizado",At3);
        attack4 = new Attack("Rayo Hielo", 90, "Este ataque hace 20 puntos de daño más por cada Energía Water unida a este Pokémon",At4);
        LA_Lapras = new ArrayList<>();
        LA_Lapras.add(attack3);
        LA_Lapras.add(attack4);
        waterPokemon = new WaterPokemon("Lapras",150,300,FullEnergy,LA_Lapras);
        waterPokemon2 = new WaterPokemon("Lapras",150,300,FullEnergy,LA_Lapras);
        //endregion
    }

    @Test
    public void attack(){
        waterPokemon.attack(psychicPokemon,1);
        psychicPokemon.attack(waterPokemon2,0);
    }

    @Test
    public void getName() {
        assertEquals("Mewtwo",psychicPokemon.getName());
        assertNotEquals("Pikachu",waterPokemon.getName());
    }

    @Test
    public void getHP() {
        assertEquals(150,waterPokemon.getHP());
        assertNotEquals(0,psychicPokemon.getHP());
    }

    @Test
    public void getID() {
        assertEquals(300,waterPokemon.getID());
        assertEquals(400,psychicPokemon.getID());
    }

    @Test
    public void getCountEnergy() {
        assertNotEquals(At1,waterPokemon.getCountEnergy());
        assertEquals(new Cost(10,10,10,10,10,10),psychicPokemon.getCountEnergy());
    }

    @Test
    public void getAttacks() {
        assertEquals(LA_Lapras,waterPokemon.getAttacks());
        assertNotEquals(waterPokemon.getAttacks(),psychicPokemon.getAttacks());
    }

    @Test
    public void getCardName() {
        assertEquals("Mewtwo",psychicPokemon.getCardName());
        assertEquals("Lapras",waterPokemon.getCardName());
        assertNotEquals("miutu",psychicPokemon.getCardName());
    }

    @Test
    public void equals1() {
        assertFalse(psychicPokemon.equals(waterPokemon));
        assertTrue(waterPokemon2.equals(waterPokemon));
    }
}