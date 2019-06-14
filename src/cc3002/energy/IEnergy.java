package cc3002.energy;

import cc3002.ICard;
import cc3002.pokemon.IPokemon;

public interface IEnergy extends ICard {

    /** Play the Energy Card to a Pokemon, adding an energy
     *
     * @param pokemon Pokemon
     */
    void useEnergyCard(IPokemon pokemon);
}
