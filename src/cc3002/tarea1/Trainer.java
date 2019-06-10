package cc3002.tarea1;

import cc3002.tarea1.energy.IEnergy;
import cc3002.tarea1.pokemon.IPokemon;

import java.util.ArrayList;

/**
 * Create a trainer entity
 *
 * @author cmesiasd
 * @version 1.0
 */
public class Trainer {
    private String name;
    private ArrayList<IPokemon> handPokemons;
    private ArrayList<IEnergy> energies;
    private ArrayList<IPokemon> bench;
    private IPokemon selectedPokemon;
    private IEnergy selectedEnergy;

    /**
     * Constructor for Trainer
     *
     * @param name Trainer's name
     * @param handPokemons Pokemons cards in hand
     * @param energies Energies cards in hand
     */
    public Trainer(String name, ArrayList<IPokemon> handPokemons, ArrayList<IEnergy> energies) {
        this.name = name;
        this.handPokemons = handPokemons;
        this.energies = energies;
        this.bench = new ArrayList<IPokemon>();
    }

    //region Properties

    /**
     * @return Trainer's bench
     */
    public ArrayList<IPokemon> getBench() {
        return bench;
    }

    /**
     * @return Trainer's Selected energy
     */
    public IEnergy getSelectedEnergy() {
        return selectedEnergy;
    }

    /**
     * @return Pokemon's Selected Pokemon
     */
    public IPokemon getSelectedPokemon(){
        return selectedPokemon;
    }

    /**
     * @return Trainer's Name
     */
    public String getName() {
        return name;
    }

    /**
     * @return Trainer's hand of pokemon
     */
    public ArrayList<IPokemon> getHandPokemons() {
        return handPokemons;
    }

    /**
     * @return Trainer's energies
     */
    public ArrayList<IEnergy> getEnergies() {
        return energies;
    }
    //endregion


    /** Select a pokemon from the bank
     * and make it ActivePokemon
     *
     * @param index Index to select Pokemon from the bench
     */
    public void selectPokemon(int index){
        selectedPokemon = getBench().get(index);
        getBench().remove(index);
    }

    /** Trainer attacks another trainer with
     *  active Pokemon's trainer.
     *
     * @param trainer Target trainer
     * @param index_at Index to select attack
     */
    public void attackTrainer(Trainer trainer, int index_at){
        getSelectedPokemon().attack(trainer.getSelectedPokemon(),index_at);
    }

    /**Add a Energy card from the hand to Active(Selected) Pokemon
     *
     * @param index Position of card in hand.
     */
    public void playEnergyCard(int index){
        selectedEnergy = getEnergies().get(index);
        selectedEnergy.useEnergyCard(getSelectedPokemon());
    }


    /**Add a Pokemon card from the hand to the bench
     * Only if the size of the bank is less than 5
     *
     * @param index Position of card in hand.
     */
    public void playPokemonCard(int index){
        if(getBench().size() <= 5 || getBench().isEmpty()){
            getBench().add(getHandPokemons().get(index));
            getHandPokemons().remove(index);
        }
    }


    /**
     * If the pokemon dies it is changed by the next one in the list
     */
    public void changePokemon() {
        if(this.getSelectedPokemon().getHP() <= 0){
            selectPokemon(1);
        }
    }
}
