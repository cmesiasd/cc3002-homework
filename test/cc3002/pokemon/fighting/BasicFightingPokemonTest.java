package cc3002.pokemon.fighting;

import cc3002.abilities.Ability;
import cc3002.abilities.Attack;
import cc3002.abilities.IAbility;
import cc3002.effect.NullEffect;
import cc3002.energy.water.WaterEnergy;
import cc3002.pokemon.lighting.BasicLightingPokemon;
import cc3002.pokemon.psychic.BasicPsychicPokemon;
import cc3002.energyCost.EnergyCost;
import cc3002.energy.fighting.FightingEnergy;
import cc3002.energy.fire.FireEnergy;
import cc3002.pokemon.fire.BasicFirePokemon;
import cc3002.energy.grass.GrassEnergy;
import cc3002.pokemon.grass.BasicGrassPokemon;
import cc3002.energy.lighting.LightingEnergy;
import cc3002.energy.psychic.PsychicEnergy;
import cc3002.pokemon.water.BasicWaterPokemon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BasicFightingPokemonTest {
    FightingEnergy fightingEnergy;
    BasicFightingPokemon basicFightingPokemon;
    FireEnergy fireEnergy;
    BasicFirePokemon basicFirePokemon;
    GrassEnergy grassEnergy;
    BasicGrassPokemon basicGrassPokemon;
    LightingEnergy lightingEnergy;
    BasicLightingPokemon basicLightingPokemon;
    PsychicEnergy psychicEnergy;
    BasicPsychicPokemon basicPsychicPokemon;
    WaterEnergy waterEnergy;
    BasicWaterPokemon basicWaterPokemon;
    EnergyCost At1, At2, At3, At4, At5, At6, At7, IniEnergy, FullEnergy;
    Attack attack1, attack2, attack3, attack4, attack5, attack6, attack7;
    List<IAbility> LA_Crobat, LA_Bulbasaur, LA_Lucario;
    NullEffect nullEffect = new NullEffect();

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
        attack1 = new Attack("Vista Nocturna", 40, "Permite robar una carta",At1,nullEffect);
        attack2 = new Attack("Colmillo Ultratoxico", 55, "El pokemon danado pasa a estar envenenado",At2,nullEffect);
        LA_Crobat = new ArrayList<>();
        LA_Crobat.add(attack1);
        LA_Crobat.add(attack2);
        basicPsychicPokemon = new BasicPsychicPokemon("Crobat",130,51,IniEnergy,LA_Crobat);
        //endregion

        //region Grass Pokemon Bulbasaur
        At3 = new EnergyCost(0,0,0,0,0,2);
        At4 = new EnergyCost(0,0,0,1,0,2);
        At5 = new EnergyCost(0,1,0,0,0,3);
        attack3 = new Attack("Hoja Afilada", 30, "Permite robar una carta",At3,nullEffect);
        attack4 = new Attack("Hiedra adormidera", 35, "El pokemon danado pasa a estar dormido",At4,nullEffect);
        attack5 = new Attack("Polen Nocivo", 40, "Hace 10 de dano mas por cada energia tipo Grass",At5,nullEffect);
        LA_Bulbasaur = new ArrayList<>();
        LA_Bulbasaur.add(attack3);
        LA_Bulbasaur.add(attack4);
        LA_Bulbasaur.add(attack5);
        basicGrassPokemon = new BasicGrassPokemon("Bulbasaur",70,1,FullEnergy,LA_Bulbasaur);
        //endregion

        //region Fighting Pokemon Lucario
        At6 = new EnergyCost(0,0,0,2,0,0);
        At7 = new EnergyCost(0,0,1,2,0,0);
        attack6 = new Attack("Derrumbar", 45, "Derrumba al pokemon",At6,nullEffect);
        attack7 = new Attack("Patada magnum", 70, "El pokemon danado queda Aturdido",At7,nullEffect);
        LA_Lucario = new ArrayList<>();
        LA_Lucario.add(attack6);
        LA_Lucario.add(attack7);
        basicFightingPokemon = new BasicFightingPokemon("Lucario",160,4,FullEnergy,LA_Lucario);
        //endregion
    }

    @Test
    public void attack() {
        basicFightingPokemon.attack(basicPsychicPokemon,1);
        Assert.assertEquals(90, basicPsychicPokemon.getHP());
        basicFightingPokemon.attack(basicGrassPokemon,0);
        assertEquals(25, basicGrassPokemon.getHP());
    }

    @Test
    public void attackedByPsychicPokemon() {
        basicPsychicPokemon.attack(basicFightingPokemon,0);
        Assert.assertEquals(160, basicFightingPokemon.getHP());
    }

    @Test
    public void attackedByGrassPokemon() {
        basicGrassPokemon.attack(basicFightingPokemon,0);
        Assert.assertEquals(100, basicFightingPokemon.getHP());
    }
}