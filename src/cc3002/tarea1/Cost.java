package cc3002.tarea1;

import cc3002.tarea1.water.WaterEnergy;

import java.util.HashMap;


public class Cost {
    private HashMap<IEnergy,Integer> cost;

    public Cost() {
        HashMap<IEnergy, Integer> cost = new HashMap<>();
        WaterEnergy waterEnergy = new WaterEnergy();
        cost.put(waterEnergy,0);
        this.cost = cost;
    }

    public HashMap<IEnergy, Integer> getCost() {
        return cost;
    }

}
