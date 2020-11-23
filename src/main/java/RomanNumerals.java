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
        return convertThousandDigitNumber(number / 1000)
                + convertHundredDigitNumber((number % 1000) / 100)
                + convertTenDigitNumber((number % 1000) % 100 / 10)
                + convertDigit((number % 1000) % 10);
    }

    private static String convertThousandDigitNumber(int number) {
        return convertNumber(number, "M");
    }

    private static String convertHundredDigitNumber(int number) {
        return convertTemp(number
                , "C"
                , "CD"
                , "D"
                , "CM");
    }

    private static String convertTenDigitNumber(int number) {
        return convertTemp(number
                , "X"
                , "XL"
                , "L"
                , "XC");
    }

    private static String convertDigit(Integer number) {
        return convertTemp(number
                , "I"
                , "IV"
                , "V"
                , "IX");
    }

    private static String convertTemp(Integer number
            , String currentDigitRomanNumberOne
            , String currentDigitRomanNumberFour
            , String currentDigitRomanNumberFive
            , String currentDigitRomanNumberNine) {
        if (number == NUMBER_NINE) {
            return currentDigitRomanNumberNine;
        }
        if (number >= NUMBER_FIVE) {
            return currentDigitRomanNumberFive
                    + convertNumber(number - 5, currentDigitRomanNumberOne);
        }
        if (number == NUMBER_FOUR) {
            return currentDigitRomanNumberFour;
        }
        return convertNumber(number, currentDigitRomanNumberOne);
    }

    private static String convertNumber(Integer number, String romanNumber) {
        return IntStream.range(NUMBER_ZERO, number).boxed()
                .map(integer -> romanNumber)
                .collect(Collectors.joining());
    }
}
