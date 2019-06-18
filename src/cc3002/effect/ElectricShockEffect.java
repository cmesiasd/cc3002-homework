package cc3002.effect;

import cc3002.pokemon.IPokemon;

public class ElectricShockEffect extends AbstractEffect {
    private int x;
    public  ElectricShockEffect(int x){
        this.x = x;
    }

    @Override
    public void doEffect() {
        this.getAssociatedCard().getTrainer().flipCoin();
        if(this.getAssociatedCard().getTrainer().getCoin()) {
            IPokemon selected = this.getAbility().getAssociatedPokemon();
            selected.setHp(selected.getHP()-this.x);
        }
    }
}
