package cc3002;

import cc3002.abilities.Ability;
import cc3002.abilities.Attack;
import cc3002.abilities.IAbility;
import cc3002.effect.NullEffect;
import cc3002.energyCost.EnergyCost;
import cc3002.energy.fire.FireEnergy;
import cc3002.energy.grass.GrassEnergy;
import cc3002.energy.psychic.PsychicEnergy;
import cc3002.energy.water.WaterEnergy;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.fighting.BasicFightingPokemon;
import cc3002.pokemon.fire.BasicFirePokemon;
import cc3002.pokemon.grass.BasicGrassPokemon;
import cc3002.pokemon.lighting.BasicLightingPokemon;
import cc3002.pokemon.psychic.BasicPsychicPokemon;
import cc3002.pokemon.water.BasicWaterPokemon;
import cc3002.energy.fighting.FightingEnergy;
import cc3002.energy.lighting.LightingEnergy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TrainerTest {
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

        IniEnergy = new EnergyCost(0,0,0,0,0,0);
        FullEnergy = new EnergyCost(10,10,10,10,10,10);
        //endregion

        //region Pokemon 1
        At1 = new EnergyCost(0,2,0,1,0,0);
        At2 = new EnergyCost(0,2,1,1,0,0);
        attack1 = new Attack("Vista Nocturna", 40, "Permite robar una carta",At1,nullEffect);
        attack2 = new Attack("Colmillo Ultratoxico", 55, "El pokemon danado pasa a estar envenenado",At2,nullEffect);

        LA_Pokemon1.add(attack1);
        LA_Pokemon1.add(attack2);
        LA_Pokemon1.add(attack1);
        LA_Pokemon1.add(attack2);
        LA_Pokemon1.add(attack1);
        LA_Pokemon1.add(attack2);

        basicPsychicPokemon = new BasicPsychicPokemon("Crobat",130,51,IniEnergy,LA_Pokemon1);
        //endregion

        //region Pokemon 2
        At3 = new EnergyCost(0,0,0,0,0,2);
        At4 = new EnergyCost(0,0,0,1,0,2);
        attack3 = new Attack("Hoja Afilada", 30, "Permite robar una carta",At3,nullEffect);
        attack4 = new Attack("Hiedra adormidera", 35, "El pokemon danado pasa a estar dormido",At4,nullEffect);

        LA_Pokemon2.add(attack3);
        LA_Pokemon2.add(attack4);

        basicGrassPokemon = new BasicGrassPokemon("Bulbasaur",70,1,FullEnergy,LA_Pokemon2);

        basicFirePokemon = new BasicFirePokemon("Charmander",100,3,FullEnergy,LA_Pokemon2);
        basicFightingPokemon = new BasicFightingPokemon("Machop",150,2,FullEnergy,LA_Pokemon1);
        basicLightingPokemon = new BasicLightingPokemon("Pikachu", 60,21,FullEnergy,LA_Pokemon1);
        basicWaterPokemon = new BasicWaterPokemon("Squirtle", 65,14,FullEnergy,LA_Pokemon2);
        //endregion

    }

    @Test
    public void getBench() {
        trainer1.addCardToHand(basicPsychicPokemon);
        trainer1.addCardToHand(basicGrassPokemon);

        trainer1.play(trainer1.getHand().get(trainer1.getHand().indexOf(basicGrassPokemon)));
        trainer1.play(trainer1.getHand().get(trainer1.getHand().indexOf(basicPsychicPokemon)));

        ArrayList<IPokemon> bench = new ArrayList<>();
        bench.add(basicPsychicPokemon);

        assertEquals(bench, trainer1.getBench());
    }

    @Test
    public void getActivePokemon() {
        trainer1.addCardToHand(basicPsychicPokemon);
        trainer2.addCardToHand(basicGrassPokemon);
        trainer1.play(trainer1.getHand().get(trainer1.getHand().indexOf(basicPsychicPokemon)));
        trainer2.play(trainer2.getHand().get(trainer2.getHand().indexOf(basicGrassPokemon)));
        Assert.assertEquals(trainer1.getActivePokemon(), basicPsychicPokemon);
        Assert.assertEquals(trainer2.getActivePokemon(), basicGrassPokemon);
    }

    @Test
    public void getName() {
        assertEquals(trainer1.getName(),"Ash");
        assertNotEquals(trainer2.getName(),"Katsup");
        assertEquals(trainer2.getName(),"Ketchup");
    }



    @Test
    public void play() {
        trainer1.addCardToHand(grassEnergy);
        trainer1.addCardToHand(basicGrassPokemon);

        trainer1.play(basicGrassPokemon);
        trainer1.setSelectedPokemon(basicGrassPokemon);
        trainer1.play(grassEnergy);

        assertEquals(trainer1.getActivePokemon().getCountEnergy().getCost(),new EnergyCost(10,10,10,10,10,11).getCost());

        //Se juegan 7 pokemon, queda el primero como activo y 5 a la banca, el ultimo no se juega
        trainer2.play(basicFirePokemon);
        trainer2.play(basicLightingPokemon);
        trainer2.play(basicWaterPokemon);
        trainer2.play(basicFightingPokemon);
        trainer2.play(basicGrassPokemon);
        trainer2.play(basicPsychicPokemon);
        trainer2.play(basicFightingPokemon);

        assertEquals(trainer2.getBench().size(),5);
        assertEquals(trainer2.getBench().get(4),basicPsychicPokemon);
        assertEquals(trainer2.getActivePokemon().getCardName(),"Charmander");
    }


    @Test
    public void attackTrainerAndReceiveAttack() {
        trainer1.setOpponent(trainer2);
        trainer2.setOpponent(trainer1);

        assertEquals(trainer1.getOpponent(),trainer2);
        assertEquals(trainer2.getOpponent(),trainer1);

        trainer1.addCardToHand(basicPsychicPokemon);
        trainer1.addCardToHand(basicGrassPokemon);

        trainer1.play(trainer1.getHand().get(trainer1.getHand().indexOf(basicGrassPokemon)));
        trainer1.play(trainer1.getHand().get(trainer1.getHand().indexOf(basicPsychicPokemon)));

        trainer2.addCardToHand(basicLightingPokemon);
        trainer2.addCardToHand(basicFirePokemon);

        trainer2.play(trainer2.getHand().get(trainer2.getHand().indexOf(basicLightingPokemon)));
        trainer2.play(trainer2.getHand().get(trainer2.getHand().indexOf(basicFirePokemon)));

        //HP Pokemon Trainer 1 y 2
        assertEquals(trainer1.getActivePokemon().getHP(), 70);
        assertEquals(trainer1.getActivePokemon().getCardName(),"Bulbasaur");
        assertEquals(trainer2.getActivePokemon().getHP(), 60);
        assertEquals(trainer2.getActivePokemon().getCardName(),"Pikachu");


        trainer1.attackTrainer(trainer2,1);
        assertEquals(trainer2.getActivePokemon().getHP(), 25);
        trainer1.attackTrainer(trainer2,0);

        //Mata al pokemon y lo cambia
        assertEquals(trainer1.getActivePokemon().getCardName(),"Crobat");
        assertEquals(trainer1.getActivePokemon().getHP(), 130);

        trainer1.addCardToHand(waterEnergy);
        trainer1.setSelectedPokemon(basicPsychicPokemon);
        trainer1.play(waterEnergy);
    }

    @Test
    public void deck(){
        assertEquals(trainer1.getDeck().size(),0);
        //Agrego 100 cartas al mazo
        for (int i = 0; i < 100; i++) {
            trainer1.setDeck(waterEnergy);
        }
        //El máximo que agrega son 60
        assertEquals(trainer1.getDeck().size(),60);

        trainer1.takeACardFromDeck();
        assertEquals(trainer1.getHand().size(),1);
    }

    @Test
    public void sixPrize(){
        assertEquals(trainer1.getSixPrize().size(),0);
        //Agrego 10 cartas a las 6 cartas premios
        for (int i = 0; i < 10; i++) {
            trainer1.setSixPrize(waterEnergy);
        }
        //El máximo que agrega son 60
        assertEquals(trainer1.getSixPrize().size(),6);

    }

}