package lotto.domain;

import lotto.LottoBalls;

public class BonusNumber {

    private final String value;

    public BonusNumber(String value) {
        ValidateIsNumber(value);
        validateBonusNumberRange(value);

        this.value = value;
    }

    private void ValidateIsNumber(String value) {
        if (!Character.isDigit(value.charAt(0))) {
            throw new IllegalArgumentException("보너스 번호의 입력은 숫자 하나만 허용합니다.");
        }
    }

    private void validateBonusNumberRange(String value) {
        if (!LottoBalls.get().contains(value)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 까지 입니다.");
        }
    }

    public String get() {
        return value;
    }
}
