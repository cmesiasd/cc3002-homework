package cc3002.pokemon.lighting;

import cc3002.Trainer;
import cc3002.abilities.Ability;
import cc3002.abilities.Attack;
import cc3002.energy.lighting.LightingEnergy;
import cc3002.energy.psychic.PsychicEnergy;
import cc3002.energyCost.EnergyCost;
import cc3002.pokemon.psychic.BasicPsychicPokemon;
import cc3002.pokemon.psychic.PhaseOnePsychicPokemon;
import cc3002.pokemon.psychic.PhaseTwoPsychicPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LightingPokemonEvolutionTest {
    LightingEnergy lightingEnergy;
    BasicLightingPokemon pichu;
    PhaseOneLightingPokemon pikachu;
    PhaseTwoLightingPokemon raichu;
    EnergyCost At1, At2, At3, At4, FullEnergy;
    Attack attack1, attack2, attack3, attack4;
    List<Ability> LA_pichu, LA_pikachu, LA_raichu;
    Trainer trainer;

    @Before
    public void setUp() throws Exception {
        trainer = new Trainer("Ash");

        lightingEnergy = new LightingEnergy("lighting");
        FullEnergy = new EnergyCost(10,10,10,10,10,10);

        //region pichu
        At1 = new EnergyCost(0,3,0,0,0,0);
        At2 = new EnergyCost(0,3,0,1,0,0);
        attack1 = new Attack("Hidrobomba", 30, "El Pokémon Activo de tu rival pasa a estar Paralizado",At1);
        attack2 = new Attack("Escupir", 10, "Este Pokémon no puede usar Filo Zen durante tu próximo turno",At2);
        LA_pichu = new ArrayList<>();
        LA_pichu.add(attack1);
        LA_pichu.add(attack2);
        pichu = new BasicLightingPokemon("pichu",60,4,FullEnergy,LA_pichu);
        //endregion

        //region Wartortlw
        At3 = new EnergyCost(2,0,0,1,0,0);
        At4 = new EnergyCost(2,0,0,2,0,0);
        attack3 = new Attack("Hidrobomba", 60, "El Pokémon Activo de tu rival pasa a estar Paralizado",At3);
        attack4 = new Attack("Rayo Hielo", 90, "Este ataque hace 20 puntos de daño más por cada Energía Water unida a este Pokémon",At4);
        LA_pikachu = new ArrayList<>();
        LA_pikachu.add(attack3);
        LA_pikachu.add(attack4);
        pikachu = new PhaseOneLightingPokemon("pikachu",150,201,FullEnergy,LA_pikachu,4);
        //endregion

        //region raichu
        LA_raichu = new ArrayList<>();
        LA_raichu.add(attack1);
        LA_raichu.add(attack4);
        raichu = new PhaseTwoLightingPokemon("raichu",200, 502,FullEnergy,LA_raichu,201);
        //endregion
    }

    @Test
    public void evolutionWaterPokemon(){
        trainer.addCardToHand(lightingEnergy);
        trainer.addCardToHand(pichu);
        trainer.addCardToHand(pikachu);
        trainer.addCardToHand(raichu);


        trainer.play(pichu);
        trainer.setSelectedPokemon(pichu);
        trainer.play(lightingEnergy);
        assertEquals(trainer.getActivePokemon().getCountEnergy().getCost(),new EnergyCost(10,10,10,10,11,10).getCost());


        trainer.play(pikachu);
        trainer.addCardToHand(lightingEnergy);
        trainer.setSelectedPokemon(pikachu);
        trainer.play(lightingEnergy);
        assertEquals(trainer.getActivePokemon(),pikachu);
        assertEquals(trainer.getActivePokemon().getCountEnergy().getCost(),new EnergyCost(10,10,10,10,12,10).getCost());


        trainer.play(raichu);
        assertEquals(trainer.getActivePokemon(),raichu);
    }
}
