package cc3002.trainerCards;

import cc3002.Trainer;
import cc3002.abilities.Attack;
import cc3002.abilities.IAbility;
import cc3002.effect.NullEffect;
import cc3002.energy.fighting.FightingEnergy;
import cc3002.energy.fire.FireEnergy;
import cc3002.energy.grass.GrassEnergy;
import cc3002.energy.lighting.LightingEnergy;
import cc3002.energy.psychic.PsychicEnergy;
import cc3002.energy.water.WaterEnergy;
import cc3002.energyCost.EnergyCost;
import cc3002.pokemon.fighting.BasicFightingPokemon;
import cc3002.pokemon.fire.BasicFirePokemon;
import cc3002.pokemon.grass.BasicGrassPokemon;
import cc3002.pokemon.lighting.BasicLightingPokemon;
import cc3002.pokemon.psychic.BasicPsychicPokemon;
import cc3002.pokemon.water.BasicWaterPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProfessorJuniperTest {
    private FightingEnergy fightingEnergy;
    private FireEnergy fireEnergy;
    private GrassEnergy grassEnergy;
    private LightingEnergy lightingEnergy;
    private PsychicEnergy psychicEnergy;
    private WaterEnergy waterEnergy;

    private BasicFightingPokemon basicFightingPokemon;
    private BasicFirePokemon basicFirePokemon;
    private BasicGrassPokemon basicGrassPokemon;
    private BasicLightingPokemon basicLightingPokemon;
    private BasicPsychicPokemon basicPsychicPokemon;
    private BasicWaterPokemon basicWaterPokemon;

    private Trainer trainer1, trainer2;

    private EnergyCost At1, At2, At3, At4, IniEnergy, FullEnergy;

    private Attack attack1, attack2, attack3, attack4;

    private List<IAbility> LA_Pokemon1 = new ArrayList<>();
    private List<IAbility> LA_Pokemon2 = new ArrayList<>();
    private List<IAbility> LA_Pokemon3 = new ArrayList<>();

    private NullEffect nullEffect = new NullEffect();

    private ProfessorJuniper professorJuniper = new ProfessorJuniper();

    @Before
    public void setUp() throws Exception {
        //region Trainer
        trainer1 = new Trainer("Ash");
        trainer2 = new Trainer("Ketchup");
        //endregion

        //region Energies
        psychicEnergy = new PsychicEnergy("psychic");
        waterEnergy = new WaterEnergy("water");
        grassEnergy = new GrassEnergy("grass");
        fireEnergy = new FireEnergy("fire");
        lightingEnergy = new LightingEnergy("lighting");
        fightingEnergy = new FightingEnergy("fighting");

        IniEnergy = new EnergyCost(0, 0, 0, 0, 0, 0);
        FullEnergy = new EnergyCost(10, 10, 10, 10, 10, 10);
        //endregion

        //region Pokemon 1
        At1 = new EnergyCost(0, 2, 0, 1, 0, 0);
        At2 = new EnergyCost(0, 2, 1, 1, 0, 0);
        attack1 = new Attack("Vista Nocturna", 40, "Permite robar una carta", At1, nullEffect);
        attack2 = new Attack("Colmillo Ultratoxico", 55, "El pokemon danado pasa a estar envenenado", At2, nullEffect);

        LA_Pokemon1.add(attack1);
        LA_Pokemon1.add(attack2);

        basicPsychicPokemon = new BasicPsychicPokemon("Crobat", 130, 51, IniEnergy, LA_Pokemon1);
        //endregion

        //region Pokemon 2
        At3 = new EnergyCost(0, 0, 0, 0, 0, 2);
        At4 = new EnergyCost(0, 0, 0, 1, 0, 2);
        attack3 = new Attack("Hoja Afilada", 30, "Permite robar una carta", At3, nullEffect);
        attack4 = new Attack("Hiedra adormidera", 35, "El pokemon danado pasa a estar dormido", At4, nullEffect);

        LA_Pokemon2.add(attack3);
        LA_Pokemon2.add(attack4);

        basicGrassPokemon = new BasicGrassPokemon("Bulbasaur", 70, 1, FullEnergy, LA_Pokemon2);

        basicFirePokemon = new BasicFirePokemon("Charmander", 100, 3, FullEnergy, LA_Pokemon2);
        basicFightingPokemon = new BasicFightingPokemon("Machop", 150, 2, FullEnergy, LA_Pokemon1);
        basicLightingPokemon = new BasicLightingPokemon("Pikachu", 60, 21, FullEnergy, LA_Pokemon1);
        basicWaterPokemon = new BasicWaterPokemon("Squirtle", 65, 14, FullEnergy, LA_Pokemon2);
        //endregion

    }

    @Test
    public void playProfessorJuniper() {

        trainer1.addCardToHand(basicFightingPokemon);
        trainer1.addCardToHand(basicFirePokemon);
        trainer1.addCardToHand(psychicEnergy);
        trainer1.addCardToHand(professorJuniper);
        assertEquals(trainer1.getHand().size(),4);

        for (int i = 0; i < 100; i++) {
            trainer1.setDeck(waterEnergy);
        }

        trainer1.play(professorJuniper);
        assertEquals(trainer1.getHand().size(),7);
    }

}