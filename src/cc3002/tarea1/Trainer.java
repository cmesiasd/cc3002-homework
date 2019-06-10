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
    private ArrayList<ICard> hand;
    private ArrayList<IPokemon> bench;
    private IPokemon activePokemon;

    /**
     * Constructor for Trainer
     *
     * @param name Trainer's name
     */
    public Trainer(String name) {
        this.name = name;
        this.hand = new ArrayList<ICard>();
        this.activePokemon = null;
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
     * @return Pokemon's Active Pokemon
     */
    public IPokemon getActivePokemon(){
        return activePokemon;
    }

    /**
     * @return Trainer's Name
     */
    public String getName() {
        return name;
    }

    /**
     * @return Trainer's hand
     */
    public ArrayList<ICard> getHand() {
        return hand;
    }

    //endregion

    /**
     * Add a cadt to the trainer's hand.
     * @param aCard the card to add in the hand.
     */
    void addCardToHand(ICard aCard) {
        hand.add(aCard);
    }


    /**
     * Lets the trainer to play a card.
     * @param aCard the ICard that wants to play.
     */
    void play(ICard aCard) {
        hand.remove(aCard);
        //aCard.setTrainer(this);
    }



    /** Trainer attacks another trainer with
     *  active Pokemon's trainer.
     *
     * @param trainer Target trainer
     * @param index_at Index to select attack
     */
    public void attackTrainer(Trainer trainer, int index_at){
        this.getActivePokemon().attack(trainer.getActivePokemon(),index_at);
    }


    /**Add a Pokemon card from the hand to the bench
     * Only if the size of the bank is less than 5
     *
     * @param pokemon Position of card in hand.
     */
    public void playPokemonCard(IPokemon pokemon){
        if (activePokemon == null)
            activePokemon = pokemon;
        else if (bench.size() <= 5)
            bench.add(pokemon);
    }


}
