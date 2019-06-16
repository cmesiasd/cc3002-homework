package cc3002.pokemon.fire;

import cc3002.Trainer;
import cc3002.abilities.Ability;
import cc3002.abilities.Attack;
import cc3002.energy.fire.FireEnergy;
import cc3002.energy.grass.GrassEnergy;
import cc3002.energyCost.EnergyCost;
import cc3002.pokemon.grass.BasicGrassPokemon;
import cc3002.pokemon.grass.PhaseOneGrassPokemon;
import cc3002.pokemon.grass.PhaseTwoGrassPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FirePokemonEvolutionTest {
    FireEnergy fireEnergy;
    BasicFirePokemon charmander;
    PhaseOneFirePokemon charmeleon;
    PhaseTwoFirePokemon charizard;
    EnergyCost At1, At2, At3, At4, IniEnergy, FullEnergy;
    Attack attack1, attack2, attack3, attack4;
    List<Ability> LA_charmander, LA_charmeleon, LA_charizard;
    Trainer trainer;

    @Before
    public void setUp() throws Exception {
        trainer = new Trainer("Ash");

        fireEnergy = new FireEnergy("fire");
        FullEnergy = new EnergyCost(10,10,10,10,10,10);

        //region charmander
        At1 = new EnergyCost(0,3,0,0,0,0);
        At2 = new EnergyCost(0,3,0,1,0,0);
        attack1 = new Attack("Hidrobomba", 30, "El Pokémon Activo de tu rival pasa a estar Paralizado",At1);
        attack2 = new Attack("Escupir", 10, "Este Pokémon no puede usar Filo Zen durante tu próximo turno",At2);
        LA_charmander = new ArrayList<>();
        LA_charmander.add(attack1);
        LA_charmander.add(attack2);
        charmander = new BasicFirePokemon("charmander",60,4,FullEnergy,LA_charmander);
        //endregion

        //region Wartortlw
        At3 = new EnergyCost(2,0,0,1,0,0);
        At4 = new EnergyCost(2,0,0,2,0,0);
        attack3 = new Attack("Hidrobomba", 60, "El Pokémon Activo de tu rival pasa a estar Paralizado",At3);
        attack4 = new Attack("Rayo Hielo", 90, "Este ataque hace 20 puntos de daño más por cada Energía Water unida a este Pokémon",At4);
        LA_charmeleon = new ArrayList<>();
        LA_charmeleon.add(attack3);
        LA_charmeleon.add(attack4);
        charmeleon = new PhaseOneFirePokemon("charmeleon",150,201,FullEnergy,LA_charmeleon,4);
        //endregion

        //region charizard
        LA_charizard = new ArrayList<>();
        LA_charizard.add(attack1);
        LA_charizard.add(attack4);
        charizard = new PhaseTwoFirePokemon("charizard",200, 502,FullEnergy,LA_charizard,201);
        //endregion
    }

    @Test
    public void evolutionWaterPokemon(){
        trainer.addCardToHand(fireEnergy);
        trainer.addCardToHand(charmander);
        trainer.addCardToHand(charmeleon);
        trainer.addCardToHand(charizard);

        trainer.play(charmander);
        trainer.setSelectedPokemon(charmander);
        trainer.play(fireEnergy);
        assertEquals(trainer.getActivePokemon().getCountEnergy().getCost(),new EnergyCost(10,10,11,10,10,10).getCost());

        trainer.play(charmeleon);
        trainer.addCardToHand(fireEnergy);
        trainer.setSelectedPokemon(charmeleon);
        trainer.play(fireEnergy);
        assertEquals(trainer.getActivePokemon(),charmeleon);
        assertEquals(trainer.getActivePokemon().getCountEnergy().getCost(),new EnergyCost(10,10,12,10,10,10).getCost());

        trainer.play(charizard);
        assertEquals(trainer.getActivePokemon(),charizard);
    }
}
