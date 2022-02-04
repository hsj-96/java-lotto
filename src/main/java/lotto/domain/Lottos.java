package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.LottoBalls;

public class Lottos {

    private static final int PRICE_OF_LOTTO = 1000;
    private static final int NUMBER_OF_LOTTO_BALL = 6;

    private final List<Lotto> lottos;

    Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos createAutoLottos(final Budget budget) {
        final List<Lotto> lottos = new ArrayList<>();

        final int numberOfLotto = getNumberOfLotto(budget);
        for (int i = 0; i < numberOfLotto; i++) {
            Collections.shuffle(LottoBalls.get());
            lottos.add(new Lotto(createRandomNumbers()));
        }
        return new Lottos(lottos);
    }

    private static int getNumberOfLotto(final Budget budget) {
        validateMoreThanLottoPrice(budget);
        return budget.getValue() / PRICE_OF_LOTTO;
    }

    private static void validateMoreThanLottoPrice(Budget budget) {
        if(budget.getValue() < PRICE_OF_LOTTO){
            throw new IllegalArgumentException("로또 한장의 구입 가격보다 투입 금액이 적습니다.");
        }
    }

    private static List<String> createRandomNumbers() {
        return new ArrayList<>(LottoBalls.get().subList(0, NUMBER_OF_LOTTO_BALL));
    }

    public List<Lotto> get() {
        return this.lottos;
    }
}
