package cc3002.tarea1.energy;

import cc3002.tarea1.ICard;
import cc3002.tarea1.pokemon.IPokemon;

public interface IEnergy extends ICard {
    //region Properties

    /**
     * @return Type of energy
     */
    String getType();
    //endregion

    /** Play the Energy Card to a Pokemon, adding an energy
     *
     * @param pokemon Pokemon
     */
    void useEnergyCard(IPokemon pokemon);
}
