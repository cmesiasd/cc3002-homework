package cc3002.pokemon.grass;

import cc3002.Trainer;
import cc3002.abilities.Ability;
import cc3002.abilities.Attack;
import cc3002.abilities.IAbility;
import cc3002.effect.NullEffect;
import cc3002.energy.grass.GrassEnergy;
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

public class GrassPokemonEvolutionTest {
    GrassEnergy grassEnergy;
    BasicGrassPokemon bulbasaur;
    PhaseOneGrassPokemon ivysaur;
    PhaseTwoGrassPokemon venusaur;
    EnergyCost At1, At2, At3, At4, IniEnergy, FullEnergy;
    Attack attack1, attack2, attack3, attack4;
    List<IAbility> LA_bulbasaur, LA_ivysaur, LA_venusaur;
    Trainer trainer;
    NullEffect nullEffect = new NullEffect();

    @Before
    public void setUp() throws Exception {
        trainer = new Trainer("Ash");

        grassEnergy = new GrassEnergy("grass");
        FullEnergy = new EnergyCost(10,10,10,10,10,10);

        //region bulbasaur
        At1 = new EnergyCost(0,3,0,0,0,0);
        At2 = new EnergyCost(0,3,0,1,0,0);
        attack1 = new Attack("Hidrobomba", 30, "El Pokémon Activo de tu rival pasa a estar Paralizado",At1,nullEffect);
        attack2 = new Attack("Escupir", 10, "Este Pokémon no puede usar Filo Zen durante tu próximo turno",At2,nullEffect);
        LA_bulbasaur = new ArrayList<>();
        LA_bulbasaur.add(attack1);
        LA_bulbasaur.add(attack2);
        bulbasaur = new BasicGrassPokemon("bulbasaur",60,4,FullEnergy,LA_bulbasaur);
        //endregion

        //region Wartortlw
        At3 = new EnergyCost(2,0,0,1,0,0);
        At4 = new EnergyCost(2,0,0,2,0,0);
        attack3 = new Attack("Hidrobomba", 60, "El Pokémon Activo de tu rival pasa a estar Paralizado",At3,nullEffect);
        attack4 = new Attack("Rayo Hielo", 90, "Este ataque hace 20 puntos de daño más por cada Energía Water unida a este Pokémon",At4,nullEffect);
        LA_ivysaur = new ArrayList<>();
        LA_ivysaur.add(attack3);
        LA_ivysaur.add(attack4);
        ivysaur = new PhaseOneGrassPokemon("ivysaur",150,201,FullEnergy,LA_ivysaur,4);
        //endregion

        //region venusaur
        LA_venusaur = new ArrayList<>();
        LA_venusaur.add(attack1);
        LA_venusaur.add(attack4);
        venusaur = new PhaseTwoGrassPokemon("venusaur",200, 502,FullEnergy,LA_venusaur,201);
        //endregion
    }

    @Test
    public void evolutionWaterPokemon(){
        trainer.addCardToHand(grassEnergy);
        trainer.addCardToHand(bulbasaur);
        trainer.addCardToHand(ivysaur);
        trainer.addCardToHand(venusaur);

        trainer.play(bulbasaur);
        trainer.setSelectedPokemon(bulbasaur);
        trainer.play(grassEnergy);
        assertEquals(trainer.getActivePokemon().getCountEnergy().getCost(),new EnergyCost(10,10,10,10,10,11).getCost());

        trainer.play(ivysaur);
        trainer.addCardToHand(grassEnergy);
        trainer.setSelectedPokemon(ivysaur);
        trainer.play(grassEnergy);
        assertEquals(trainer.getActivePokemon(),ivysaur);
        assertEquals(trainer.getActivePokemon().getCountEnergy().getCost(),new EnergyCost(10,10,10,10,10,12).getCost());

        trainer.play(venusaur);
        assertEquals(trainer.getActivePokemon(),venusaur);
    }
}
