import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author huisheng.jin
 * @date 2020/11/12.
 */
public class RomanNumerals {
    private static HashMap<String, String> map = new HashMap<>();

    static {
        map.put("digit-1", "I");
        map.put("digit-4", "IV");
        map.put("digit-5", "V");
        map.put("digit-9", "IX");

        map.put("ten-1", "X");
        map.put("ten-4", "XL");
        map.put("ten-5", "L");
        map.put("ten-9", "XC");

        map.put("hundred-1", "C");
        map.put("hundred-4", "CD");
        map.put("hundred-5", "D");
        map.put("hundred-9", "CM");

        map.put("thousand-1", "M");
        map.put("thousand-4", "CD");
        map.put("thousand-5", "D");
        map.put("thousand-9", "CM");

    }

    private static String getFlag(Integer number, String unit) {
        return map.get(String.format("%s-%d", unit, number));
    }

    public static String convert(Integer number) {
        return countEqualOrMoreThanTenThousand(number / 10000)
        +  countUnitNumbers(number % 10000);
    }

    private static String countEqualOrMoreThanTenThousand(int moreThanTenThousandNumber) {
        return IntStream.range(0, moreThanTenThousandNumber*10).boxed().map(i -> "M").collect(Collectors.joining());
    }

    private static String countUnitNumbers(Integer number) {
        List<UnitNumber> list = createUnitNumbers(number );
        return list.stream().map(item -> countUnitNumber(item.getNumber(), item.getUnit()))
                .collect(Collectors.joining());
    }

    private static List<UnitNumber> createUnitNumbers(Integer number) {
        String[] split = String.valueOf(number).split("");
        List<UnitNumber> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            list.add(new UnitNumber(Integer.valueOf(split[i]), getUnit(split.length - 1 - i)));
        }
        return list;
    }

    private static String getUnit(int i) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "digit");
        map.put(2, "ten");
        map.put(3, "hundred");
        map.put(4, "thousand");

        return map.get(i + 1);
    }

    private static String countUnitNumber(Integer number, String digit) {
        if (containsKey(number, digit)) {
            return getFlag(number, digit);
        }
        if (number > 5) {
            return getFlag(5, digit) + countNumberLessThanFive(number - 5, digit);
        }
        return countNumberLessThanFive(number, digit);
    }

    private static boolean containsKey(Integer number, String unit) {
        return map.containsKey(String.format("%s-%d", unit, number));
    }

    private static String countNumberLessThanFive(Integer number, String digit) {
        if (number == 0) {
            return "";
        }
        if (containsKey(number, digit)) {
            return getFlag(number, digit);
        }
        return IntStream.range(0, number).boxed().map(i -> getFlag(1, digit)).collect(Collectors.joining());
    }

}
