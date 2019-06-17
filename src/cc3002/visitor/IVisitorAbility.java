package cc3002.visitor;

import cc3002.abilities.Ability;
import cc3002.abilities.Attack;

public interface IVisitorAbility {

    void visitAbility(Ability ability);

    void visitAttack(Attack attack);
}
