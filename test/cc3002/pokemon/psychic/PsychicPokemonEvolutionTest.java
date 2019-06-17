package cc3002.pokemon.psychic;

import cc3002.Trainer;
import cc3002.abilities.Ability;
import cc3002.abilities.Attack;
import cc3002.abilities.IAbility;
import cc3002.effect.NullEffect;
import cc3002.energy.psychic.PsychicEnergy;
import cc3002.energyCost.EnergyCost;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PsychicPokemonEvolutionTest {
    PsychicEnergy psychicEnergy;
    BasicPsychicPokemon abra;
    PhaseOnePsychicPokemon kadabra;
    PhaseTwoPsychicPokemon alakazam;
    EnergyCost At1, At2, At3, At4, IniEnergy, FullEnergy;
    Attack attack1, attack2, attack3, attack4;
    List<IAbility> LA_Abra, LA_kadabra, LA_alakazam;
    Trainer trainer;
    NullEffect nullEffect =new NullEffect();

    @Before
    public void setUp() throws Exception {
        trainer = new Trainer("Ash");

        psychicEnergy = new PsychicEnergy("psychic");
        FullEnergy = new EnergyCost(10,10,10,10,10,10);

        //region abra
        At1 = new EnergyCost(0,3,0,0,0,0);
        At2 = new EnergyCost(0,3,0,1,0,0);
        attack1 = new Attack("Hidrobomba", 30, "El Pokémon Activo de tu rival pasa a estar Paralizado",At1,nullEffect);
        attack2 = new Attack("Escupir", 10, "Este Pokémon no puede usar Filo Zen durante tu próximo turno",At2,nullEffect);
        LA_Abra = new ArrayList<>();
        LA_Abra.add(attack1);
        LA_Abra.add(attack2);
        abra = new BasicPsychicPokemon("Abra",60,4,FullEnergy,LA_Abra);
        //endregion

        //region Wartortlw
        At3 = new EnergyCost(2,0,0,1,0,0);
        At4 = new EnergyCost(2,0,0,2,0,0);
        attack3 = new Attack("Hidrobomba", 60, "El Pokémon Activo de tu rival pasa a estar Paralizado",At3,nullEffect);
        attack4 = new Attack("Rayo Hielo", 90, "Este ataque hace 20 puntos de daño más por cada Energía Water unida a este Pokémon",At4,nullEffect);
        LA_kadabra = new ArrayList<>();
        LA_kadabra.add(attack3);
        LA_kadabra.add(attack4);
        kadabra = new PhaseOnePsychicPokemon("kadabra",150,201,FullEnergy,LA_kadabra,4);
        //endregion

        //region alakazam
        LA_alakazam = new ArrayList<>();
        LA_alakazam.add(attack1);
        LA_alakazam.add(attack4);
        alakazam = new PhaseTwoPsychicPokemon("alakazam",200, 502,FullEnergy,LA_alakazam,201);
        //endregion
    }

    @Test
    public void evolutionWaterPokemon(){
        trainer.addCardToHand(psychicEnergy);
        trainer.addCardToHand(abra);
        trainer.addCardToHand(kadabra);
        trainer.addCardToHand(alakazam);


        trainer.play(abra);
        trainer.setSelectedPokemon(abra);
        trainer.play(psychicEnergy);
        assertEquals(trainer.getActivePokemon().getCountEnergy().getCost(),new EnergyCost(10,11,10,10,10,10).getCost());


        trainer.play(kadabra);
        trainer.addCardToHand(psychicEnergy);
        trainer.setSelectedPokemon(kadabra);
        trainer.play(psychicEnergy);
        assertEquals(trainer.getActivePokemon(),kadabra);
        assertEquals(trainer.getActivePokemon().getCountEnergy().getCost(),new EnergyCost(10,12,10,10,10,10).getCost());


        trainer.play(alakazam);
        assertEquals(trainer.getActivePokemon(),alakazam);
    }
}
