import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author huisheng.jin
 * @date 2020/11/12.
 */
public class RomanNumerals {

    public static String convert(Integer number) {
        return countEqualOrMoreThanTenThousand(number / 10000)
        +  countUnitNumbers(number % 10000);
    }

    private static String countEqualOrMoreThanTenThousand(int moreThanTenThousandNumber) {
        return IntStream.range(0, moreThanTenThousandNumber*10).boxed().map(i -> "M").collect(Collectors.joining());
    }

    private static String countUnitNumbers(Integer number) {
        List<UnitNumber> list = UnitNumber.separateUnitNumber(number);
        return list.stream().map(item -> countUnitNumber(item.getNumber(), item.getUnit()))
                .collect(Collectors.joining());
    }

    private static String countUnitNumber(Integer number, String digit) {
        if (FlagContainer.containsKey(number, digit)) {
            return FlagContainer.getFlag(number, digit);
        }
        if (number > 5) {
            return FlagContainer.getFlag(5, digit) + countNumberLessThanFive(number - 5, digit);
        }
        else {
            return countNumberLessThanFive(number, digit);
        }
    }

    private static String countNumberLessThanFive(Integer number, String digit) {
        if (number == 0) {
            return "";
        }
        if (FlagContainer.containsKey(number, digit)) {
            return FlagContainer.getFlag(number, digit);
        }
        return IntStream.range(0, number).boxed()
                .map(i -> FlagContainer.getFlag(1, digit))
                .collect(Collectors.joining());
    }

}
