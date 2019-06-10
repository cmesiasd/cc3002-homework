package cc3002.tarea1.attack;

import cc3002.tarea1.Attack;

public class AttackList {
    private Attack[] attacks;

    public AttackList(Attack first, Attack second, Attack third, Attack fourth) {
        attacks = new Attack[4];
        attacks[0] = first;
        attacks[1] = second;
        attacks[2] = third;
        attacks[3] = fourth;
    }

    public Attack getAttack(int index){
        return this.attacks[index-1];
    }
}
