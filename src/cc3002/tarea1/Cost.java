package cc3002.tarea1;

import cc3002.tarea1.psychic.PsychicEnergy;
import cc3002.tarea1.water.WaterEnergy;

import java.util.HashMap;


public class Cost {
    private HashMap<String,Integer> cost;

    public Cost() {
        HashMap<String, Integer> cost = new HashMap<>();
        String water = "water";
        String psychic = "psychic";

        WaterEnergy waterEnergy = new WaterEnergy(water);
        PsychicEnergy psychicEnergy = new PsychicEnergy(psychic);
        WaterEnergy holaEnergy = new WaterEnergy(water);

        cost.put(waterEnergy.getType(),3);
        cost.put(holaEnergy.getType(),2);
        cost.put(psychicEnergy.getType(),0);
        this.cost = cost;
    }



    public HashMap<String, Integer> getCost() {
        return cost;
    }

    public void getKeys(Cost cost){
        System.out.println(cost.getCost());
    }

}
