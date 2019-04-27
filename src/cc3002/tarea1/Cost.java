package cc3002.tarea1;

import cc3002.tarea1.fighting.FightingEnergy;
import cc3002.tarea1.fire.FireEnergy;
import cc3002.tarea1.grass.GrassEnergy;
import cc3002.tarea1.lighting.LightingEnergy;
import cc3002.tarea1.psychic.PsychicEnergy;
import cc3002.tarea1.water.WaterEnergy;

import java.util.HashMap;
import java.util.Objects;

/**
 * Create the Cost Object.
 * Hashmap to control energies and their costs
 *
 * @author cmesias
 * @version 1.0
 */
public class Cost {
    private HashMap<String,Integer> cost;

    /**
     * Constructor for Cost
     * Add to the HashMap each type of energy
     *
     * @param wa Count of WaterEnergy
     * @param psy Count of PsychicEnergy
     * @param fi Count of FireEnergy
     * @param fig Count of FightingEnergy
     * @param lig Count of LightingEnergy
     * @param gra Count of GrassEnergy
     */
    public Cost(int wa, int psy, int fi, int fig, int lig, int gra) {
        HashMap<String, Integer> cost = new HashMap<>();

        WaterEnergy waterEnergy = new WaterEnergy("");
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

    public void getKeys(Cost cost){
        System.out.println(cost.getCost());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cost)) return false;
        Cost cost1 = (Cost) o;
        return Objects.equals(getCost(), cost1.getCost());
    }

}
