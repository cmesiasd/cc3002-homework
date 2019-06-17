package cc3002.pokemon.lighting;

import cc3002.abilities.Ability;
import cc3002.abilities.IAbility;
import cc3002.effect.NullEffect;
import cc3002.energyCost.EnergyCost;
import cc3002.pokemon.fighting.BasicFightingPokemon;
import cc3002.abilities.Attack;
import cc3002.energy.fighting.FightingEnergy;
import cc3002.energy.fire.FireEnergy;
import cc3002.pokemon.fire.BasicFirePokemon;
import cc3002.energy.grass.GrassEnergy;
import cc3002.pokemon.grass.BasicGrassPokemon;
import cc3002.energy.lighting.LightingEnergy;
import cc3002.energy.psychic.PsychicEnergy;
import cc3002.pokemon.psychic.BasicPsychicPokemon;
import cc3002.energy.water.WaterEnergy;
import cc3002.pokemon.water.BasicWaterPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BasicLightingPokemonTest {
    FightingEnergy fightingEnergy;
    BasicFightingPokemon basicFightingPokemon;
    FireEnergy fireEnergy;
    BasicFirePokemon basicFirePokemon;
    GrassEnergy grassEnergy;
    BasicGrassPokemon basicGrassPokemon;
    LightingEnergy lightingEnergy;
    BasicLightingPokemon basicLightingPokemon, basicLightingPokemon2;
    PsychicEnergy psychicEnergy;
    BasicPsychicPokemon basicPsychicPokemon;
    WaterEnergy waterEnergy;
    BasicWaterPokemon basicWaterPokemon;
    EnergyCost At1, At2, At3, At4, At5, At6, At7, IniEnergy, FullEnergy;
    Attack attack1, attack2, attack3, attack4, attack5, attack6, attack7;
    List<IAbility> LA_Pikachu, LA_Espeon, LA_Lucario;
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

        //region Lighting Pokemon Pikachu
        At1 = new EnergyCost(0,0,0,1,1,0);
        At2 = new EnergyCost(0,0,0,1,2,0);
        At3 = new EnergyCost(0,0,0,0,3,0);
        attack1 = new Attack("Ataque Rápido", 30, "Si el pokemon no es de tipo electrico duplica el dano",At1,nullEffect);
        attack2 = new Attack("Impact Trueno", 45, "El pokemon danado pasa a estar Paralizado",At2,nullEffect);
        attack3 = new Attack("Bola Voltio", 50, "Hace 10 de dano mas por cada energia tipo Electrico",At3,nullEffect);
        LA_Pikachu = new ArrayList<>();
        LA_Pikachu.add(attack1);
        LA_Pikachu.add(attack2);
        LA_Pikachu.add(attack3);
        basicLightingPokemon = new BasicLightingPokemon("Pikachu",70,76,FullEnergy,LA_Pikachu);
        //endregion

        //region Lighting Pokemon Electrode
        At4 = new EnergyCost(0,2,1,0,0,0);
        At5 = new EnergyCost(1,2,1,1,0,0);
        attack4 = new Attack("Electrorrayo", 45, "El Pokemon danado pasa a estar Confundido",At4,nullEffect);
        attack5 = new Attack("Pistola Electrica", 70, "Ataque electrico paralizador",At5,nullEffect);
        LA_Espeon = new ArrayList<>();
        LA_Espeon.add(attack4);
        LA_Espeon.add(attack5);
        basicLightingPokemon2 = new BasicLightingPokemon("Electrode",100,200,FullEnergy,LA_Espeon);
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
        basicLightingPokemon.attack(basicLightingPokemon2,1);
        basicLightingPokemon2.attack(basicFightingPokemon,0);
        assertEquals(55, basicLightingPokemon2.getHP());
        assertEquals(115, basicFightingPokemon.getHP());
    }

    @Test
    public void attackedByFightingPokemon() {
        basicFightingPokemon.attack(basicLightingPokemon,0);
        basicFightingPokemon.attack(basicLightingPokemon2,1);
        assertEquals(0, basicLightingPokemon2.getHP());
        assertEquals(0, basicLightingPokemon.getHP());
    }
}