package cc3002;

import cc3002.cost.Cost;
import cc3002.energy.fire.FireEnergy;
import cc3002.energy.grass.GrassEnergy;
import cc3002.energy.psychic.PsychicEnergy;
import cc3002.energy.water.WaterEnergy;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.fighting.FightingPokemon;
import cc3002.pokemon.fire.FirePokemon;
import cc3002.pokemon.grass.GrassPokemon;
import cc3002.pokemon.lighting.LightingPokemon;
import cc3002.pokemon.psychic.PsychicPokemon;
import cc3002.pokemon.water.WaterPokemon;
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

    private FightingPokemon fightingPokemon;
    private FirePokemon firePokemon;
    private GrassPokemon grassPokemon;
    private LightingPokemon lightingPokemon;
    private PsychicPokemon psychicPokemon;
    private WaterPokemon waterPokemon;

    private Trainer trainer1, trainer2;

    private Cost At1, At2, At3, At4, IniEnergy, FullEnergy;

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

        IniEnergy = new Cost(0,0,0,0,0,0);
        FullEnergy = new Cost(10,10,10,10,10,10);
        //endregion

        //region Pokemon 1
        At1 = new Cost(0,2,0,1,0,0);
        At2 = new Cost(0,2,1,1,0,0);
        attack1 = new Attack("Vista Nocturna", 40, "Permite robar una carta",At1);
        attack2 = new Attack("Colmillo Ultratoxico", 55, "El pokemon danado pasa a estar envenenado",At2);

        LA_Pokemon1.add(attack1);
        LA_Pokemon1.add(attack2);
        LA_Pokemon1.add(attack1);
        LA_Pokemon1.add(attack2);
        LA_Pokemon1.add(attack1);
        LA_Pokemon1.add(attack2);

        psychicPokemon = new PsychicPokemon("Crobat",130,51,IniEnergy,LA_Pokemon1);
        //endregion

        //region Pokemon 2
        At3 = new Cost(0,0,0,0,0,2);
        At4 = new Cost(0,0,0,1,0,2);
        attack3 = new Attack("Hoja Afilada", 30, "Permite robar una carta",At3);
        attack4 = new Attack("Hiedra adormidera", 35, "El pokemon danado pasa a estar dormido",At4);

        LA_Pokemon2.add(attack3);
        LA_Pokemon2.add(attack4);

        grassPokemon = new GrassPokemon("Bulbasaur",70,1,FullEnergy,LA_Pokemon2);
        //endregion

    }

    @Test
    public void getBench() {
        trainer1.addCardToHand(psychicPokemon);
        trainer1.addCardToHand(grassPokemon);

        trainer1.play(trainer1.getHand().get(trainer1.getHand().indexOf(grassPokemon)));
        trainer1.play(trainer1.getHand().get(trainer1.getHand().indexOf(psychicPokemon)));

        ArrayList<IPokemon> bench = new ArrayList<>();
        bench.add(psychicPokemon);

        assertEquals(bench, trainer1.getBench());
    }

    @Test
    public void getActivePokemon() {
        trainer1.addCardToHand(psychicPokemon);
        trainer2.addCardToHand(grassPokemon);
        trainer1.play(trainer1.getHand().get(trainer1.getHand().indexOf(psychicPokemon)));
        trainer2.play(trainer2.getHand().get(trainer2.getHand().indexOf(grassPokemon)));
        Assert.assertEquals(trainer1.getActivePokemon(),psychicPokemon);
        Assert.assertEquals(trainer2.getActivePokemon(),grassPokemon);
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
        trainer1.addCardToHand(grassPokemon);

        trainer1.play(grassPokemon);
        trainer1.play(grassEnergy);

        Assert.assertEquals(trainer1.getActivePokemon().getCountEnergy().getCost(),new Cost(10,10,10,10,10,11).getCost());
    }


    @Test
    public void attackTrainerAndReceiveAttack() {
        trainer1.addCardToHand(psychicPokemon);
        trainer1.addCardToHand(grassPokemon);

        trainer1.play(trainer1.getHand().get(trainer1.getHand().indexOf(grassPokemon)));
        trainer1.play(trainer1.getHand().get(trainer1.getHand().indexOf(psychicPokemon)));

        trainer2.addCardToHand(psychicPokemon);
        trainer2.addCardToHand(grassPokemon);

        trainer2.play(trainer2.getHand().get(trainer2.getHand().indexOf(grassPokemon)));
        trainer2.play(trainer2.getHand().get(trainer2.getHand().indexOf(psychicPokemon)));

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