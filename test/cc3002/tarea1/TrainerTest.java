package cc3002.tarea1;

import cc3002.tarea1.fighting.FightingEnergy;
import cc3002.tarea1.fighting.FightingPokemon;
import cc3002.tarea1.fire.FireEnergy;
import cc3002.tarea1.fire.FirePokemon;
import cc3002.tarea1.grass.GrassEnergy;
import cc3002.tarea1.grass.GrassPokemon;
import cc3002.tarea1.lighting.LightingEnergy;
import cc3002.tarea1.lighting.LightingPokemon;
import cc3002.tarea1.psychic.PsychicEnergy;
import cc3002.tarea1.psychic.PsychicPokemon;
import cc3002.tarea1.water.WaterEnergy;
import cc3002.tarea1.water.WaterPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TrainerTest {
    FightingEnergy fightingEnergy;
    FightingPokemon fightingPokemon;
    FireEnergy fireEnergy;
    FirePokemon firePokemon;
    GrassEnergy grassEnergy;
    GrassPokemon grassPokemon;
    LightingEnergy lightingEnergy;
    LightingPokemon lightingPokemon;
    PsychicEnergy psychicEnergy;
    PsychicPokemon psychicPokemon;
    WaterEnergy waterEnergy;
    WaterPokemon waterPokemon;
    Trainer trainer1, trainer2;
    Cost At1, At2, At3, At4, At5, At6, At7, IniEnergy, FullEnergy;
    Attack attack1, attack2, attack3, attack4, attack5, attack6, attack7;
    List<Attack> LA_Crobat, LA_Bulbasaur, LA_Lucario;
    ArrayList<IPokemon> LP_Ash_bench, LP_Ash_Hand;
    ArrayList<IEnergy> LE_Ash;

    @Before
    public void setUp() throws Exception {

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

        //region Psychic Pokemon Crobat
        At1 = new Cost(0,2,0,1,0,0);
        At2 = new Cost(0,2,1,1,0,0);
        attack1 = new Attack("Vista Nocturna", 40, "Permite robar una carta",At1);
        attack2 = new Attack("Colmillo Ultratoxico", 55, "El pokemon danado pasa a estar envenenado",At2);
        LA_Crobat = new ArrayList<>();
        LA_Crobat.add(attack1);
        LA_Crobat.add(attack2);
        psychicPokemon = new PsychicPokemon("Crobat",130,51,IniEnergy,LA_Crobat);
        //endregion

        //region Grass Pokemon Bulbasaur
        At3 = new Cost(0,0,0,0,0,2);
        At4 = new Cost(0,0,0,1,0,2);
        At5 = new Cost(0,1,0,0,0,3);
        attack3 = new Attack("Hoja Afilada", 30, "Permite robar una carta",At3);
        attack4 = new Attack("Hiedra adormidera", 35, "El pokemon danado pasa a estar dormido",At4);
        attack5 = new Attack("Polen Nocivo", 40, "Hace 10 de dano mas por cada energia tipo Grass",At5);
        LA_Bulbasaur = new ArrayList<>();
        LA_Bulbasaur.add(attack3);
        LA_Bulbasaur.add(attack4);
        LA_Bulbasaur.add(attack5);
        grassPokemon = new GrassPokemon("Bulbasaur",70,1,FullEnergy,LA_Bulbasaur);
        //endregion

        //region Fighting Pokemon Lucario
        At6 = new Cost(0,0,0,2,0,0);
        At7 = new Cost(0,0,1,2,0,0);
        attack6 = new Attack("Derrumbar", 45, "Derrumba al pokemon",At6);
        attack7 = new Attack("Patada magnum", 70, "El pokemon danado queda Aturdido",At7);
        LA_Lucario = new ArrayList<>();
        LA_Lucario.add(attack6);
        LA_Lucario.add(attack7);
        fightingPokemon = new FightingPokemon("Lucario",160,4,FullEnergy,LA_Lucario);
        //endregion

        //region Ash
        LP_Ash_Hand = new ArrayList<>();
        LP_Ash_Hand.add(fightingPokemon);
        LP_Ash_Hand.add(grassPokemon);
        LE_Ash = new ArrayList<>();
        LE_Ash.add(grassEnergy);
        LE_Ash.add(fightingEnergy);
        LE_Ash.add(fightingEnergy);
        trainer1 = new Trainer("Ash",LP_Ash_Hand,LE_Ash);
        LP_Ash_bench = new ArrayList<>();
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