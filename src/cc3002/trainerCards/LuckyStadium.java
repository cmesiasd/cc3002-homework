package cc3002.trainerCards;

import cc3002.effect.IEffect;
import cc3002.effect.LuckyStadiumEffect;
/**
 * Implementation of Stadium Card
 * Lucky Stadium
 *
 * @author cmesiasd
 * @version 2.0
 */
public class LuckyStadium extends StadiumCard{
    public LuckyStadium() {
        super("Lucky Stadium", "Una vez durante su turno, el jugador puede lanzar una moneda. Si sale\n" +
                "cara, el jugador roba una carta.", new LuckyStadiumEffect());
    }
}
