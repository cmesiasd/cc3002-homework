package cc3002.effect;

public class ElectricShockEffect extends AbstractEffect {
    private int x;
    public  ElectricShockEffect(int x){
        this.x = x;
    }

    @Override
    public void doEffect() {
        this.getAbility().getAssociatedPokemon().getTrainer().flipCoin();
        //if (this.coinFlip) this.getAbility().getAssociatedPokemon().setHp(this.x);
    }
}
