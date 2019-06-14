package cc3002.visitor;

import cc3002.energy.IEnergy;
import cc3002.pokemon.IBasicPokemon;
import cc3002.pokemon.IPhaseOnePokemon;
import cc3002.pokemon.IPhaseTwoPokemon;
import cc3002.trainerCards.ObjectCard;
import cc3002.trainerCards.StadiumCard;
import cc3002.trainerCards.SupportCard;

public interface IVisitorCard {
    void visitBasicPokemon(IBasicPokemon aBasicPokemon);

    void visitPhaseOnePokemon(IPhaseOnePokemon aPhaseOnePokemon);

    void visitPhaseTwoPokemon(IPhaseTwoPokemon aPhaseTwoPokemon);

    void visitEnergy(IEnergy energy);

    void visitObjectCard(ObjectCard objectCard);

    void visitStadiumCard(StadiumCard stadiumCard);

    void visitSupportCard(SupportCard supportCard);
}
