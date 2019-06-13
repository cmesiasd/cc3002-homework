package cc3002.energyCost;

import cc3002.energy.water.WaterEnergy;
import cc3002.energy.fighting.FightingEnergy;
import cc3002.energy.fire.FireEnergy;
import cc3002.energy.grass.GrassEnergy;
import cc3002.energy.lighting.LightingEnergy;
import cc3002.energy.psychic.PsychicEnergy;

import java.util.HashMap;
import java.util.Objects;

/**
 * Create the EnergyCost Object.
 * Hashmap to control energies and their costs
 *
 * @author cmesias
 * @version 1.0
 */
public class EnergyCost {
    private HashMap<String,Integer> cost;

    /**
     * Constructor for EnergyCost
     * Add to the HashMap each type of energy
     *
     * @param wa Count of WaterEnergy
     * @param psy Count of PsychicEnergy
     * @param fi Count of FireEnergy
     * @param fig Count of FightingEnergy
     * @param lig Count of LightingEnergy
     * @param gra Count of GrassEnergy
     */
    public EnergyCost(int wa, int psy, int fi, int fig, int lig, int gra) {
        HashMap<String, Integer> cost = new HashMap<>();

        WaterEnergy waterEnergy = new WaterEnergy("water");
        PsychicEnergy psychicEnergy = new PsychicEnergy("psychic");
        FireEnergy fireEnergy = new FireEnergy("fire");
        GrassEnergy grassEnergy = new GrassEnergy("grass");
        FightingEnergy fightingEnergy = new FightingEnergy("fighting");
        LightingEnergy lightingEnergy = new LightingEnergy("lighting");

        cost.put(waterEnergy.getType(),wa);
        cost.put(psychicEnergy.getType(),psy);
        cost.put(fireEnergy.getType(),fi);
        cost.put(grassEnergy.getType(),gra);
        cost.put(fightingEnergy.getType(),fig);
        cost.put(lightingEnergy.getType(),lig);

        this.cost = cost;
    }


    /**
     * @return Hashmap of energies.
     */
    public HashMap<String, Integer> getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnergyCost)) return false;
        EnergyCost energyCost1 = (EnergyCost) o;
        return Objects.equals(getCost(), energyCost1.getCost());
    }

}
