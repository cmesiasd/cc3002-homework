package cc3002.tarea1;

import java.util.ArrayList;

public class Trainer {
    private String name;
    private ArrayList<IPokemon> pokemons;
    private ArrayList<IEnergy> energies;
    private IPokemon selectedPokemon;
    private IEnergy selectedEnergy;

    public Trainer(String name, ArrayList<IPokemon> pokemons, ArrayList<IEnergy> energies) {
        this.name = name;
        this.pokemons = pokemons;
        this.energies = energies;
    }

    //region Properties


    public IEnergy getSelectedEnergy() {
        return selectedEnergy;
    }

    public IPokemon getSelectedPokemon(){
        return selectedPokemon;
    }

    public String getName() {
        return name;
    }

    public ArrayList<IPokemon> getPokemons() {
        return pokemons;
    }

    public ArrayList<IEnergy> getEnergies() {
        return energies;
    }
    //endregion

    public void selectPokemon(int index){
        selectedPokemon = getPokemons().get(index);
    }

    public void attackTrainer(Trainer trainer, int at){
        getSelectedPokemon().attack(trainer.getSelectedPokemon(),at);
    }

    public void playEnergyCard(int index){
        selectedEnergy = getEnergies().get(index);
        selectedEnergy.useEnergyCard(getSelectedPokemon());
    }
}
