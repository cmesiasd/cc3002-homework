package cc3002.visitor;

import cc3002.pokemon.fighting.AbstractFightingPokemon;
import cc3002.pokemon.fire.AbstractFirePokemon;
import cc3002.pokemon.grass.AbstractGrassPokemon;
import cc3002.pokemon.lighting.AbstractLightingPokemon;
import cc3002.pokemon.psychic.AbstractPsychicPokemon;
import cc3002.pokemon.water.AbstractWaterPokemon;

public class StrikesBackVisitor implements IVisitorPokemonType {

    @Override
    public void visitLightingPokemon(AbstractLightingPokemon lightingPokemon) {
        int damage = lightingPokemon.getSelectedAttack().getBaseDamage();
        lightingPokemon.setHp(lightingPokemon.getHP()-damage);
    }

    @Override
    public void visitFightingPokemon(AbstractFightingPokemon fightingPokemon) {
        int damage = fightingPokemon.getSelectedAttack().getBaseDamage();
        fightingPokemon.setHp(fightingPokemon.getHP()-damage);
    }

    @Override
    public void visitFirePokemon(AbstractFirePokemon firePokemon) {
        int damage = firePokemon.getSelectedAttack().getBaseDamage();
        firePokemon.setHp(firePokemon.getHP()-damage);
    }

    @Override
    public void visitGrassPokemon(AbstractGrassPokemon grassPokemon) {
        int damage = grassPokemon.getSelectedAttack().getBaseDamage();
        grassPokemon.setHp(grassPokemon.getHP()-damage);
    }

    @Override
    public void visitPsychicPokemon(AbstractPsychicPokemon psychicPokemon) {
        int damage = psychicPokemon.getSelectedAttack().getBaseDamage();
        psychicPokemon.setHp(psychicPokemon.getHP()-damage);
    }

    @Override
    public void visitWaterPokemon(AbstractWaterPokemon waterPokemon) {
        int damage = waterPokemon.getSelectedAttack().getBaseDamage();
        waterPokemon.setHp(waterPokemon.getHP()-damage);
    }
}
