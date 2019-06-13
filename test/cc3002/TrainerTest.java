package cc3002;

import cc3002.abilities.Attack;
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

    private List<Attack> LA_Pokemon1 = new ArrayList<>();
    private List<Attack> LA_Pokemon2 = new ArrayList<>();
    private List<Attack> LA_Pokemon3 = new ArrayList<>();

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
        attack1 = new Attack("Vista Nocturna", 40, "Permite robar una carta",At1);
        attack2 = new Attack("Colmillo Ultratoxico", 55, "El pokemon danado pasa a estar envenenado",At2);

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
        attack3 = new Attack("Hoja Afilada", 30, "Permite robar una carta",At3);
        attack4 = new Attack("Hiedra adormidera", 35, "El pokemon danado pasa a estar dormido",At4);

        LA_Pokemon2.add(attack3);
        LA_Pokemon2.add(attack4);

        basicGrassPokemon = new BasicGrassPokemon("Bulbasaur",70,1,FullEnergy,LA_Pokemon2);
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
        trainer1.play(grassEnergy);

        Assert.assertEquals(trainer1.getActivePokemon().getCountEnergy().getCost(),new EnergyCost(10,10,10,10,10,11).getCost());
    }


    @Test
    public void attackTrainerAndReceiveAttack() {
        trainer1.addCardToHand(basicPsychicPokemon);
        trainer1.addCardToHand(basicGrassPokemon);

        trainer1.play(trainer1.getHand().get(trainer1.getHand().indexOf(basicGrassPokemon)));
        trainer1.play(trainer1.getHand().get(trainer1.getHand().indexOf(basicPsychicPokemon)));

        trainer2.addCardToHand(basicPsychicPokemon);
        trainer2.addCardToHand(basicGrassPokemon);

        trainer2.play(trainer2.getHand().get(trainer2.getHand().indexOf(basicGrassPokemon)));
        trainer2.play(trainer2.getHand().get(trainer2.getHand().indexOf(basicPsychicPokemon)));

        trainer1.attackTrainer(trainer2,1);
        Assert.assertEquals(trainer2.getActivePokemon().getHP(), 35);

        //El pokemon activo de "trainer1" es Bulbasaur
        Assert.assertEquals(trainer1.getActivePokemon().getName(),"Bulbasaur");

        trainer2.attackTrainer(trainer1,0);
        trainer2.attackTrainer(trainer1,0);

        //Muere el pokemon y cambia al siguiente
        Assert.assertEquals(trainer1.getActivePokemon().getName(),"Crobat");
        Assert.assertEquals(trainer1.getActivePokemon().getHP(), 130);
    }

}