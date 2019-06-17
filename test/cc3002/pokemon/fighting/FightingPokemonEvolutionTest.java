package cc3002.pokemon.fighting;

import cc3002.Trainer;
import cc3002.abilities.Ability;
import cc3002.abilities.Attack;
import cc3002.abilities.IAbility;
import cc3002.effect.NullEffect;
import cc3002.energy.fighting.FightingEnergy;
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

public class FightingPokemonEvolutionTest {
    FightingEnergy fightingEnergy;
    BasicFightingPokemon machop;
    PhaseOneFightingPokemon machoke;
    PhaseTwoFightingPokemon machamp;
    EnergyCost At1, At2, At3, At4, IniEnergy, FullEnergy;
    Attack attack1, attack2, attack3, attack4;
    List<IAbility> LA_machop, LA_machoke, LA_machamp;
    Trainer trainer;
    NullEffect nullEffect = new NullEffect();

    @Before
    public void setUp() throws Exception {
        trainer = new Trainer("Ash");

        fightingEnergy = new FightingEnergy("fighting");
        FullEnergy = new EnergyCost(10,10,10,10,10,10);

        //region machop
        At1 = new EnergyCost(0,3,0,0,0,0);
        At2 = new EnergyCost(0,3,0,1,0,0);
        attack1 = new Attack("Hidrobomba", 30, "El Pokémon Activo de tu rival pasa a estar Paralizado",At1,nullEffect);
        attack2 = new Attack("Escupir", 10, "Este Pokémon no puede usar Filo Zen durante tu próximo turno",At2,nullEffect);
        LA_machop = new ArrayList<>();
        LA_machop.add(attack1);
        LA_machop.add(attack2);
        machop = new BasicFightingPokemon("machop",60,4,FullEnergy,LA_machop);
        //endregion

        //region Wartortlw
        At3 = new EnergyCost(2,0,0,1,0,0);
        At4 = new EnergyCost(2,0,0,2,0,0);
        attack3 = new Attack("Hidrobomba", 60, "El Pokémon Activo de tu rival pasa a estar Paralizado",At3,nullEffect);
        attack4 = new Attack("Rayo Hielo", 90, "Este ataque hace 20 puntos de daño más por cada Energía Water unida a este Pokémon",At4,nullEffect);
        LA_machoke = new ArrayList<>();
        LA_machoke.add(attack3);
        LA_machoke.add(attack4);
        machoke = new PhaseOneFightingPokemon("machoke",150,201,FullEnergy,LA_machoke,4);
        //endregion

        //region machamp
        LA_machamp = new ArrayList<>();
        LA_machamp.add(attack1);
        LA_machamp.add(attack4);
        machamp = new PhaseTwoFightingPokemon("machamp",200, 502,FullEnergy,LA_machamp,201);
        //endregion
    }

    @Test
    public void evolutionWaterPokemon(){
        trainer.addCardToHand(fightingEnergy);
        trainer.addCardToHand(machop);
        trainer.addCardToHand(machoke);
        trainer.addCardToHand(machamp);


        trainer.play(machop);
        trainer.setSelectedPokemon(machop);
        trainer.play(fightingEnergy);
        assertEquals(trainer.getActivePokemon().getCountEnergy().getCost(),new EnergyCost(10,10,10,11,10,10).getCost());

        trainer.play(machoke);
        trainer.addCardToHand(fightingEnergy);
        trainer.setSelectedPokemon(machoke);
        trainer.play(fightingEnergy);
        assertEquals(trainer.getActivePokemon(),machoke);
        assertEquals(trainer.getActivePokemon().getCountEnergy().getCost(),new EnergyCost(10,10,10,12,10,10).getCost());


        trainer.play(machamp);
        assertEquals(trainer.getActivePokemon(),machamp);
    }
}
