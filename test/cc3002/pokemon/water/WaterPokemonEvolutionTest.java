package cc3002.pokemon.water;

import cc3002.Trainer;
import cc3002.abilities.Ability;
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

public class WaterPokemonEvolutionTest {
    WaterEnergy waterEnergy;
    BasicWaterPokemon squirtle, psyduck;
    PhaseOneWaterPokemon wartortle;
    PhaseTwoWaterPokemon blastoise;
    EnergyCost At1, At2, At3, At4, IniEnergy, FullEnergy;
    Attack attack1, attack2, attack3, attack4;
    List<Ability> LA_Squirtle, LA_Wartortle, LA_Blastoise;
    Trainer trainer;

    @Before
    public void setUp() throws Exception {
        trainer = new Trainer("Ash");

        waterEnergy = new WaterEnergy("water");
        FullEnergy = new EnergyCost(10,10,10,10,10,10);

        //region Squirtle
        At1 = new EnergyCost(0,3,0,0,0,0);
        At2 = new EnergyCost(0,3,0,1,0,0);
        attack1 = new Attack("Hidrobomba", 30, "El Pokémon Activo de tu rival pasa a estar Paralizado",At1);
        attack2 = new Attack("Escupir", 10, "Este Pokémon no puede usar Filo Zen durante tu próximo turno",At2);
        LA_Squirtle = new ArrayList<>();
        LA_Squirtle.add(attack1);
        LA_Squirtle.add(attack2);
        squirtle = new BasicWaterPokemon("Squirtle",60,4,FullEnergy,LA_Squirtle);
        //endregion

        //region Wartortlw
        At3 = new EnergyCost(2,0,0,1,0,0);
        At4 = new EnergyCost(2,0,0,2,0,0);
        attack3 = new Attack("Hidrobomba", 60, "El Pokémon Activo de tu rival pasa a estar Paralizado",At3);
        attack4 = new Attack("Rayo Hielo", 90, "Este ataque hace 20 puntos de daño más por cada Energía Water unida a este Pokémon",At4);
        LA_Wartortle = new ArrayList<>();
        LA_Wartortle.add(attack3);
        LA_Wartortle.add(attack4);
        wartortle = new PhaseOneWaterPokemon("Wartortle",150,201,FullEnergy,LA_Wartortle,4);
        //endregion

        //region Blastoise
        LA_Blastoise = new ArrayList<>();
        LA_Blastoise.add(attack1);
        LA_Blastoise.add(attack4);
        blastoise = new PhaseTwoWaterPokemon("Blastoise",200, 502,FullEnergy,LA_Blastoise,201);
        //endregion

        // Psyduck
        psyduck = new BasicWaterPokemon("Psyduck", 40,30,FullEnergy,LA_Squirtle);
        //endregion
    }

    @Test
    public void evolutionWaterPokemon(){
        trainer.addCardToHand(waterEnergy);
        trainer.addCardToHand(squirtle);
        trainer.addCardToHand(wartortle);
        trainer.addCardToHand(blastoise);
        trainer.addCardToHand(psyduck);

        trainer.play(psyduck);
        trainer.play(squirtle);
        trainer.setSelectedPokemon(squirtle);
        trainer.play(waterEnergy);
        assertEquals(trainer.getSelectedPokemon().getCountEnergy().getCost(),new EnergyCost(11,10,10,10,10,10).getCost());


        trainer.play(wartortle);
        trainer.setSelectedPokemon(wartortle);
        assertEquals(trainer.getActivePokemon(),psyduck);
        assertEquals(trainer.getSelectedPokemon(),wartortle);
        assertEquals(trainer.getSelectedPokemon().getCountEnergy().getCost(),new EnergyCost(11,10,10,10,10,10).getCost());


        trainer.play(blastoise);
        assertEquals(trainer.getBench().size(),1);
        assertEquals(trainer.getBench().get(0),blastoise);
        assertEquals(trainer.getSelectedPokemon(),wartortle);
        assertEquals(trainer.getDiscardPile().get(1),wartortle);
    }
}
