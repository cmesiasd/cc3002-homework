package cc3002.tarea1;

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
import cc3002.tarea1.water.WaterEnergy;
import cc3002.tarea1.water.WaterPokemon;
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
    PsychicPokemon psychicPokemon, psychicPokemon2;
    WaterEnergy waterEnergy;
    WaterPokemon waterPokemon;
    Cost At1, At2, At3, At4, At5, At6, At7, IniEnergy, FullEnergy;
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
        //endregion
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
    public void getSelectedAttack() {
    }

    @Test
    public void isAlive() {
    }

    @Test
    public void selectAttack() {
    }

    @Test
    public void canAttack() {
    }

    @Test
    public void receiveAttack() {
    }

    @Test
    public void receiveWeaknessAttack() {
    }

    @Test
    public void receiveResistantAttack() {
    }

    @Test
    public void attackedByWaterPokemon() {
    }

    @Test
    public void attackedByGrassPokemon() {
    }

    @Test
    public void attackedByFirePokemon() {
    }

    @Test
    public void attackedByFightingPokemon() {
    }

    @Test
    public void attackedByPsychicPokemon() {
    }

    @Test
    public void attackedByLightingPokemon() {
    }

    @Test
    public void receiveWaterEnergy() {
    }

    @Test
    public void receiveFireEnergy() {
    }

    @Test
    public void receiveGrassEnergy() {
    }

    @Test
    public void receiveFightingEnergy() {
    }

    @Test
    public void receiveLightingEnergy() {
    }

    @Test
    public void receivePsychicEnergy() {
    }

    @Test
    public void getCardName() {
    }
}