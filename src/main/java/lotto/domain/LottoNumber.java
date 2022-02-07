package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    private final static int LOTTO_START_NUMBER = 1;
    private final static int LOTTO_END_NUMBER = 45;

    private final int value;

    public LottoNumber(String value) {
        int number = parseInt(value);
        validateLottoNumberRange(number);

        this.value = number;
    }

    private int parseInt(String value) {
        int number;
        try {
            number = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 번호의 입력은 숫자만 허용합니다.");
        }
        return number;
    }

    private void validateLottoNumberRange(final int value) {
        if (isNotLottoNumberRange(value)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 까지 입니다.");
        }
    }

    private boolean isNotLottoNumberRange(int value) {
        return value < LOTTO_START_NUMBER || value > LOTTO_END_NUMBER;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
