package cc3002.tarea1;

public interface IEnergy {
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
