package cc3002.tarea1;

import cc3002.tarea1.cost.Cost;
import cc3002.tarea1.energy.IEnergy;
import cc3002.tarea1.energy.fighting.FightingEnergy;
import cc3002.tarea1.pokemon.IPokemon;
import cc3002.tarea1.pokemon.fighting.FightingPokemon;
import cc3002.tarea1.energy.fire.FireEnergy;
import cc3002.tarea1.pokemon.fire.FirePokemon;
import cc3002.tarea1.energy.grass.GrassEnergy;
import cc3002.tarea1.pokemon.grass.GrassPokemon;
import cc3002.tarea1.energy.lighting.LightingEnergy;
import cc3002.tarea1.pokemon.lighting.LightingPokemon;
import cc3002.tarea1.energy.psychic.PsychicEnergy;
import cc3002.tarea1.pokemon.psychic.PsychicPokemon;
import cc3002.tarea1.energy.water.WaterEnergy;
import cc3002.tarea1.pokemon.water.WaterPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        psychicPokemon = new PsychicPokemon("Crobat",130,51,IniEnergy,LA_Crobat);
        //endregion

        //region Pokemon 2
        At3 = new Cost(0,0,0,0,0,2);
        At4 = new Cost(0,0,0,1,0,2);
        attack3 = new Attack("Hoja Afilada", 30, "Permite robar una carta",At3);
        attack4 = new Attack("Hiedra adormidera", 35, "El pokemon danado pasa a estar dormido",At4);

        LA_Bulbasaur = new ArrayList<>();
        LA_Bulbasaur.add(attack3);
        LA_Bulbasaur.add(attack4);
        LA_Bulbasaur.add(attack5);
        grassPokemon = new GrassPokemon("Bulbasaur",70,1,FullEnergy,LA_Bulbasaur);
        //endregion

    }

    @Test
    public void getBench() {
        trainer1.playPokemonCard(1);
        trainer1.getBench();
    }

    @Test
    public void getSelectedEnergy() {
    }

    @Test
    public void getSelectedPokemon() {
    }

    @Test
    public void getName() {
    }

    @Test
    public void getHandPokemons() {
    }

    @Test
    public void getEnergies() {
    }

    @Test
    public void selectPokemon() {
    }

    @Test
    public void attackTrainer() {
    }

    @Test
    public void playEnergyCard() {
    }

    @Test
    public void playPokemonCard() {

    }

    @Test
    public void changePokemon() {
    }
}