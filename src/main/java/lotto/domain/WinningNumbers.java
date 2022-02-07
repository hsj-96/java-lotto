package lotto.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbers {

    private static final String SPACES = "\\s+";
    private static final String EMPTY_STRING = "";
    private static final String DELIMITER_COMMA = ",";
    private static final int NUMBER_OF_LOTTO_BALL = 6;

    private final Set<LottoNumber> lottoNumbers;

    public WinningNumbers(String inputWinningNumbers) {
        inputWinningNumbers = removeBlank(inputWinningNumbers);
        validateInputFormat(inputWinningNumbers);
        final Set<LottoNumber> winningNumbers = convertToLottoNumbers(inputWinningNumbers);

        validateWinningNumberCount(winningNumbers);

        this.lottoNumbers = winningNumbers;
    }

    private String removeBlank(final String inputNumbers) {
        return inputNumbers.replaceAll(SPACES, EMPTY_STRING);
    }

    private void validateInputFormat(final String numbers) {
        if (!numbers.matches(getValidateRegex())) {
            throw new IllegalArgumentException("구분자와 숫자만으로 이루어져야 합니다.");
        }
    }

    private String getValidateRegex() {
        return String.format("[0-9%s]+$", DELIMITER_COMMA);
    }

    private Set<LottoNumber> convertToLottoNumbers(final String winningNumbers) {
        String[] split = winningNumbers.split(DELIMITER_COMMA);

        return Arrays.stream(split)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    private void validateWinningNumberCount(final Set<LottoNumber> winningNumbers) {
        if (winningNumbers.size() != NUMBER_OF_LOTTO_BALL) {
            throw new IllegalArgumentException("당첨 번호는 중복되지 않은 6개의 숫자 입니다.");
        }
    }

    public Set<LottoNumber> get() {
        return this.lottoNumbers;
    }
}
