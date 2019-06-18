package cc3002.visitor;

import cc3002.Trainer;
import cc3002.abilities.Ability;
import cc3002.abilities.Attack;
import cc3002.abilities.IAbility;

/**
 * Visitor to do abilities
 *
 * @author cmesiasd
 * @version 2.0
 */
public class AbilityVisitor implements IVisitorAbility {
    @Override
    public void visitAbility(Ability ability) {
        Trainer opponent = ability.getAssociatedPokemon().getTrainer().getOpponent();
        ability.getEffect().setAbility(ability);
        ability.getEffect().setAssociatedCard(ability.getAssociatedPokemon());
        ability.getEffect().doEffect();
        opponent.receiveAnAttack(ability.getAssociatedPokemon().getTrainer(), ability.getAssociatedPokemon().getAttacks().indexOf(ability));

    }

    @Override
    public void visitAttack(Attack attack) {
        Trainer opponent = attack.getAssociatedPokemon().getTrainer().getOpponent();
        attack.getEffect().setAssociatedCard(attack.getAssociatedPokemon());
        attack.getEffect().doEffect();
        opponent.receiveAnAttack(attack.getAssociatedPokemon().getTrainer(), attack.getAssociatedPokemon().getAttacks().indexOf(attack));
    }
}
