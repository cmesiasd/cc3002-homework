package cc3002.pokemon.psychic;

import cc3002.abilities.Attack;
import cc3002.energyCost.EnergyCost;
import cc3002.pokemon.fighting.BasicFightingPokemon;
import cc3002.energy.fighting.FightingEnergy;
import cc3002.energy.fire.FireEnergy;
import cc3002.pokemon.fire.BasicFirePokemon;
import cc3002.energy.grass.GrassEnergy;
import cc3002.pokemon.grass.BasicGrassPokemon;
import cc3002.energy.lighting.LightingEnergy;
import cc3002.pokemon.lighting.BasicLightingPokemon;
import cc3002.energy.psychic.PsychicEnergy;
import cc3002.energy.water.WaterEnergy;
import cc3002.pokemon.water.BasicWaterPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BasicPsychicPokemonTest {
    FightingEnergy fightingEnergy;
    BasicFightingPokemon basicFightingPokemon;
    FireEnergy fireEnergy;
    BasicFirePokemon basicFirePokemon;
    GrassEnergy grassEnergy;
    BasicGrassPokemon basicGrassPokemon;
    LightingEnergy lightingEnergy;
    BasicLightingPokemon basicLightingPokemon;
    PsychicEnergy psychicEnergy;
    BasicPsychicPokemon basicPsychicPokemon, basicPsychicPokemon2;
    WaterEnergy waterEnergy;
    BasicWaterPokemon basicWaterPokemon;
    EnergyCost At1, At2, At3, At4, At5, At6, At7, IniEnergy, FullEnergy;
    Attack attack1, attack2, attack3, attack4, attack5, attack6, attack7;
    List<Attack> LA_Crobat, LA_Espeon, LA_Lucario;

    @Before
    public void setUp() throws Exception {

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

        //region Psychic Pokemon Crobat
        At1 = new EnergyCost(0,2,0,1,0,0);
        At2 = new EnergyCost(0,2,1,1,0,0);
        At3 = new EnergyCost(1,3,0,0,0,0);
        attack1 = new Attack("Vista Nocturna", 40, "Permite robar una carta",At1);
        attack2 = new Attack("Colmillo Ultratoxico", 55, "El pokemon danado pasa a estar envenenado",At2);
        attack3 = new Attack("Golpe Sorpresa", 60, "Hace 10 de dano mas por cada energia tipo Psiquica",At3);
        LA_Crobat = new ArrayList<>();
        LA_Crobat.add(attack1);
        LA_Crobat.add(attack2);
        LA_Crobat.add(attack3);
        basicPsychicPokemon = new BasicPsychicPokemon("Crobat",130,51,IniEnergy,LA_Crobat);
        //endregion

        //region Psychic Pokemon Espeon
        At4 = new EnergyCost(0,2,1,0,0,0);
        At5 = new EnergyCost(1,2,1,1,0,0);
        attack4 = new Attack("Psicorrayo", 45, "El Pokemon danado pasa a estar Confundido",At4);
        attack5 = new Attack("Psicocarga", 70, "El daño de este ataque no se ve afectado " +
                "por ningún efecto en el Pokémon Activo de tu rival.",At5);
        LA_Espeon = new ArrayList<>();
        LA_Espeon.add(attack4);
        LA_Espeon.add(attack5);
        basicPsychicPokemon2 = new BasicPsychicPokemon("Espeon",170,50,FullEnergy,LA_Espeon);
        //endregion

        //region Fighting Pokemon Lucario
        At6 = new EnergyCost(0,0,0,2,0,0);
        At7 = new EnergyCost(0,0,1,2,0,0);
        attack6 = new Attack("Derrumbar", 45, "Derrumba al pokemon",At6);
        attack7 = new Attack("Patada magnum", 70, "El pokemon danado queda Aturdido",At7);
        LA_Lucario = new ArrayList<>();
        LA_Lucario.add(attack6);
        LA_Lucario.add(attack7);
        basicFightingPokemon = new BasicFightingPokemon("Lucario",160,4,FullEnergy,LA_Lucario);
        //endregion


    }

    @Test
    public void attack() {
        basicPsychicPokemon.attack(basicPsychicPokemon2,2);
        basicPsychicPokemon2.attack(basicFightingPokemon,1);
        assertEquals(130, basicPsychicPokemon.getHP());
        assertEquals(20, basicFightingPokemon.getHP());
        //El Pokemon recibe energías y puede ejecutar el ataque
        basicPsychicPokemon.receivePsychicEnergy(psychicEnergy);
        basicPsychicPokemon.receivePsychicEnergy(psychicEnergy);
        basicPsychicPokemon.receivePsychicEnergy(psychicEnergy);
        basicPsychicPokemon.receiveWaterEnergy(waterEnergy);
        basicPsychicPokemon.attack(basicPsychicPokemon2,2);
        assertEquals(50, basicPsychicPokemon2.getHP());
    }

    @Test
    public void attackedByFightingPokemon(){
        basicFightingPokemon.attack(basicPsychicPokemon,0);
        basicFightingPokemon.attack(basicPsychicPokemon2,1);
        assertEquals(130, basicPsychicPokemon2.getHP());
        assertEquals(115, basicPsychicPokemon.getHP());
    }

    @Test
    public void attackedByPsychicPokemon(){
        basicPsychicPokemon.attack(basicPsychicPokemon2,0);
        basicPsychicPokemon2.attack(basicPsychicPokemon,0);
        assertEquals(170, basicPsychicPokemon2.getHP());
        assertEquals(40, basicPsychicPokemon.getHP());
    }



}