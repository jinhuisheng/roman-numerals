import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author huisheng.jin
 * @version 2019/11/9.
 */
public class RomanNumerals {

    private static final String I = "I";
    private static final String ROMAN_FIVE = "V";
    private static final String ROMAN_TEN = "X";
    private static final int ARABIC_FIVE = 5;
    private static final int ARABIC_TEN = 10;
    private int number;
    private StringBuilder result = new StringBuilder();

    private RomanNumerals(int number) {
        this.number = number;
    }

    public static String convert(int number) {
        RomanNumerals romanNumerals = new RomanNumerals(number);
        return romanNumerals.convert();
    }

    private String convert() {
        convertBiggerThanOrEqualsTen();
        convertLessThanOrEqualsNine();
        return result.toString();
    }

    private void convertBiggerThanOrEqualsTen() {
        if (number >= ARABIC_TEN) {
            result.append(collectRoman(number / ARABIC_TEN, ROMAN_TEN));
        }
    }

    private void convertLessThanOrEqualsNine() {
        if (number % ARABIC_TEN == ARABIC_TEN - 1) {
            result.append(join(I) + ROMAN_TEN);
        } else {
            result.append(convertSmallThanNine(number % ARABIC_TEN));
        }
    }

    private static String convertSmallThanNine(int number) {
        if (number == ARABIC_FIVE - 1) {
            return join(I) + ROMAN_FIVE;
        }
        if (number >= ARABIC_FIVE) {
            return ROMAN_FIVE + collectRoman(number - ARABIC_FIVE, I);
        }
        return collectRoman(number, I);
    }

    private static String collectRoman(int number, String romanTen) {
        return IntStream.range(0, number)
                .mapToObj(String::valueOf).map(str -> join(romanTen))
                .collect(Collectors.joining());
    }

    private static String join(String roman) {
        return roman;
    }
}
