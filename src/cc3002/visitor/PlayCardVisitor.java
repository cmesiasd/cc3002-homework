package cc3002.visitor;

import cc3002.Trainer;
import cc3002.energy.IEnergy;
import cc3002.pokemon.IBasicPokemon;
import cc3002.pokemon.IPhaseOnePokemon;
import cc3002.pokemon.IPhaseTwoPokemon;
import cc3002.trainerCards.ObjectCard;
import cc3002.trainerCards.StadiumCard;
import cc3002.trainerCards.SupportCard;

public class PlayCardVisitor implements IVisitorCard {

    @Override
    public void visitBasicPokemon(IBasicPokemon aBasicPokemon) {
        Trainer trainer = aBasicPokemon.getTrainer();
        if (trainer.getActivePokemon() == null)
            trainer.setActivePokemon(aBasicPokemon);
        else if (trainer.getBench().size() < 5)
            trainer.getBench().add(aBasicPokemon);
    }

    @Override
    public void visitPhaseOnePokemon(IPhaseOnePokemon aPhaseOnePokemon) {
        int IDpreEVo = aPhaseOnePokemon.getIDBasicPokemonToEvolve();
        aPhaseOnePokemon.getTrainer().evolutionPokemon(aPhaseOnePokemon,IDpreEVo);
    }

    @Override
    public void visitPhaseTwoPokemon(IPhaseTwoPokemon aPhaseTwoPokemon) {
        int IDpreEVo = aPhaseTwoPokemon.getIDPhaseOnePokemonToEvolve();
        aPhaseTwoPokemon.getTrainer().evolutionPokemon(aPhaseTwoPokemon,IDpreEVo);
    }

    @Override
    public void visitEnergy(IEnergy energy) {
        energy.useEnergyCard(energy.getTrainer().getSelectedPokemon());
    }

    @Override
    public void visitObjectCard(ObjectCard objectCard) {
        objectCard.getEffect().setAssociatedCard(objectCard);
        objectCard.useTrainerCardEffect();
    }

    @Override
    public void visitStadiumCard(StadiumCard stadiumCard) {
        stadiumCard.getEffect().setAssociatedCard(stadiumCard);
        stadiumCard.useTrainerCardEffect();
    }

    @Override
    public void visitSupportCard(SupportCard supportCard) {
        supportCard.getEffect().setAssociatedCard(supportCard);
        supportCard.useTrainerCardEffect();
    }
}
