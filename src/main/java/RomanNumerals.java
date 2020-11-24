import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author huisheng.jin
 * @date 2020/11/23.
 */
public class RomanNumerals {

    private static final int NUMBER_NINE = 9;
    private static final int NUMBER_FIVE = 5;
    private static final int NUMBER_FOUR = 4;
    private static final int NUMBER_ZERO = 0;

    public static String convert(Integer number) {
        int thousandDigitNumber = number / 1000;
        int hundredDigitNumber = (number % 1000) / 100;
        int tenDigitNumber = (number % 1000) % 100 / 10;
        int digitNumber = (number % 1000) % 10;
        return convertThousandDigitNumber(thousandDigitNumber)
                + convertHundredDigitNumber(hundredDigitNumber)
                + convertTenDigitNumber(tenDigitNumber)
                + convertDigitNumber(digitNumber);
    }

    private static String convertThousandDigitNumber(int number) {
        return convertNumber(number, "M");
    }

    private static String convertHundredDigitNumber(int number) {
        return convertTemp(number, "hundredDigit");
    }

    private static String convertTenDigitNumber(int number) {
        return convertTemp(number, "tenDigit");
    }

    private static String convertDigitNumber(Integer number) {
        return convertTemp(number, "digit");
    }

    private static String convertTemp(Integer number, String digitName) {
        ConvertDigitRoman convertDigitRoman = ConvertDigitRomans.getDigitRoman(digitName);
        String currentDigitRomanNumberOne = convertDigitRoman.getCurrentDigitRomanNumberOne();
        if (number == NUMBER_NINE) {
            return convertDigitRoman.getCurrentDigitRomanNumberNine();
        }
        if (number >= NUMBER_FIVE) {
            return convertDigitRoman.getCurrentDigitRomanNumberFive()
                    + convertNumber(number - 5, currentDigitRomanNumberOne);
        }
        if (number == NUMBER_FOUR) {
            return convertDigitRoman.getCurrentDigitRomanNumberFour();
        }
        return convertNumber(number, currentDigitRomanNumberOne);
    }

    private static String convertNumber(Integer number, String romanNumber) {
        return IntStream.range(NUMBER_ZERO, number).boxed()
                .map(integer -> romanNumber)
                .collect(Collectors.joining());
    }
}
