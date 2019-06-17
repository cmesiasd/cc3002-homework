package cc3002;

import cc3002.abilities.Attack;
import cc3002.effect.NullEffect;
import cc3002.energyCost.EnergyCost;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AttackTest {
    EnergyCost At1, At2, At3, At4, At5, At6;
    Attack attack1, attack2, attack3, attack4, attack5, attack6;
    NullEffect nullEffect = new NullEffect();

    @Before
    public void setUp() throws Exception {
        At1 = new EnergyCost(0,0,0,0,0,2);
        At2 = new EnergyCost(0,0,0,1,0,2);
        At3 = new EnergyCost(0,1,0,0,0,3);
        At4 = new EnergyCost(0,0,2,0,0,0);
        At5 = new EnergyCost(0,0,3,1,0,0);
        At6 = new EnergyCost(0,0,3,1,0,0);
        attack1 = new Attack("Hoja Afilada", 30, "Permite robar una carta",At1,nullEffect);
        attack2 = new Attack("Hiedra adormidera", 35, "El pokemon danado pasa a estar dormido",At2,nullEffect);
        attack3 = new Attack("Polen Nocivo", 40, "Hace 10 de dano mas por cada energia tipo Grass",At3,nullEffect);
        attack4 = new Attack("Ascuas", 20, "El pokemon danado descarga una enrgia",At6,nullEffect);
        attack5 = new Attack("Quemadura de lava", 30, "Quema al rival",At5,nullEffect);
        attack6 = new Attack("Quemadura de lava", 30, "Quema al rival",At4,nullEffect);
    }

    @Test
    public void getBaseDamage() {
        assertEquals(30,attack1.getBaseDamage());
        assertNotEquals("Pikachu", attack2.getBaseDamage());
        assertEquals(40, attack3.getBaseDamage());
    }

    @Test
    public void getName() {
        assertEquals("Ascuas",attack4.getName());
        assertNotEquals("Impactrueno",attack5.getName());
    }

    @Test
    public void getDescription() {
        assertEquals("Quema al rival",attack5.getDescription());
        assertTrue("Permite robar una carta" == attack1.getDescription());
    }

    @Test
    public void getCost() {
        assertNotEquals(attack1.getEnergyCost(),attack2.getEnergyCost());
        assertEquals(attack4.getEnergyCost(),attack5.getEnergyCost());
    }

    @Test
    public void equals1() {
        assertNotEquals("false",attack1.equals(attack2));
        assertEquals(false,attack5.equals(attack6));
    }
}