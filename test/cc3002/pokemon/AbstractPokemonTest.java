package cc3002.pokemon;

import cc3002.Trainer;
import cc3002.abilities.Ability;
import cc3002.abilities.IAbility;
import cc3002.effect.NullEffect;
import cc3002.energyCost.EnergyCost;
import cc3002.pokemon.fighting.BasicFightingPokemon;
import cc3002.abilities.Attack;
import cc3002.energy.fighting.FightingEnergy;
import cc3002.energy.fire.FireEnergy;
import cc3002.pokemon.fire.BasicFirePokemon;
import cc3002.energy.grass.GrassEnergy;
import cc3002.pokemon.grass.BasicGrassPokemon;
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

public class AbstractPokemonTest {
    FightingEnergy fightingEnergy;
    BasicFightingPokemon basicFightingPokemon;
    FireEnergy fireEnergy;
    BasicFirePokemon basicFirePokemon;
    GrassEnergy grassEnergy;
    BasicGrassPokemon basicGrassPokemon;
    LightingEnergy lightingEnergy;
    BasicLightingPokemon basicLightingPokemon;
    PsychicEnergy psychicEnergy;
    BasicPsychicPokemon basicPsychicPokemon;
    WaterEnergy waterEnergy;
    BasicWaterPokemon basicWaterPokemon, basicWaterPokemon2;
    EnergyCost At1, At2, At3, At4, IniEnergy, FullEnergy;
    Attack attack1, attack2, attack3, attack4;
    List<IAbility> LA_Mewtwo, LA_Lapras;
    Trainer trainer;
    NullEffect nullEffect = new NullEffect();

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

        //region Grass Pokemon Mewtwo
        At1 = new EnergyCost(0,3,0,0,0,0);
        At2 = new EnergyCost(0,3,0,1,0,0);
        attack1 = new Attack("Superrayo Psi", 100, "El Pokémon Activo de tu rival pasa a estar Paralizado",At1,nullEffect);
        attack2 = new Attack("Filo Zen", 110, "Este Pokémon no puede usar Filo Zen durante tu próximo turno",At2,nullEffect);
        LA_Mewtwo = new ArrayList<>();
        LA_Mewtwo.add(attack1);
        LA_Mewtwo.add(attack2);
        basicPsychicPokemon = new BasicPsychicPokemon("Mewtwo",120,400,FullEnergy,LA_Mewtwo);
        //endregion

        //region Water Pokemon Lapras
        At3 = new EnergyCost(2,0,0,1,0,0);
        At4 = new EnergyCost(2,0,0,2,0,0);
        attack3 = new Attack("Hidrobomba", 60, "El Pokémon Activo de tu rival pasa a estar Paralizado",At3,nullEffect);
        attack4 = new Attack("Rayo Hielo", 90, "Este ataque hace 20 puntos de daño más por cada Energía Water unida a este Pokémon",At4,nullEffect);
        LA_Lapras = new ArrayList<>();
        LA_Lapras.add(attack3);
        LA_Lapras.add(attack4);
        basicWaterPokemon = new BasicWaterPokemon("Lapras",150,300,FullEnergy,LA_Lapras);
        basicWaterPokemon2 = new BasicWaterPokemon("Lapras",150,300,FullEnergy,LA_Lapras);
        //endregion

        trainer = new Trainer("Ash Ketchup");
    }

    @Test
    public void attack(){
        basicWaterPokemon.attack(basicPsychicPokemon,1);
        basicPsychicPokemon.attack(basicWaterPokemon2,0);
        assertEquals(basicPsychicPokemon.getHP(),30);
        assertEquals(basicWaterPokemon2.getHP(),50);
    }

    @Test
    public void getHP() {
        assertEquals(150, basicWaterPokemon.getHP());
        assertNotEquals(0, basicPsychicPokemon.getHP());
    }

    @Test
    public void getID() {
        assertEquals(300, basicWaterPokemon.getID());
        assertEquals(400, basicPsychicPokemon.getID());
    }

    @Test
    public void getCountEnergy() {
        assertNotEquals(At1, basicWaterPokemon.getCountEnergy());
        assertEquals(new EnergyCost(10,10,10,10,10,10), basicPsychicPokemon.getCountEnergy());
    }

    @Test
    public void getAttacks() {
        assertEquals(LA_Lapras, basicWaterPokemon.getAttacks());
        assertNotEquals(basicWaterPokemon.getAttacks(), basicPsychicPokemon.getAttacks());
    }

    @Test
    public void getCardName() {
        assertEquals("Mewtwo", basicPsychicPokemon.getCardName());
        assertEquals("Lapras", basicWaterPokemon.getCardName());
        assertNotEquals("miutu", basicPsychicPokemon.getCardName());
    }

    @Test
    public void discard(){
        assertEquals(trainer.getDiscardPile().size(),0);
        basicPsychicPokemon.discard(trainer);
        assertEquals(trainer.getDiscardPile().size(),1);
        fightingEnergy.discard(trainer);
        assertEquals(trainer.getDiscardPile().size(),2);
    }

    @Test
    public void equals1() {
        assertFalse(basicPsychicPokemon.equals(basicWaterPokemon));
        assertTrue(basicWaterPokemon2.equals(basicWaterPokemon));
    }
}