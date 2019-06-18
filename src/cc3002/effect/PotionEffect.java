package cc3002.effect;

import cc3002.pokemon.IPokemon;

public class PotionEffect extends AbstractEffect {
    private int max;

    public PotionEffect(int x){
        this.max = x;
    }

    @Override
    public void doEffect() {
        IPokemon selected = this.getAssociatedCard().getTrainer().getActivePokemon();
        int damage = (selected.getInitialHP() - selected.getHP())/10;
        if(damage > max) selected.setHp(max*10 + selected.getHP());
        else selected.setHp(damage *10 + selected.getHP());
        this.getAssociatedCard().discard(this.getAssociatedCard().getTrainer());
    }
}
