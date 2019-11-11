import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 单位数字转换器（针对个位，十位，百位，千位等）
 *
 * @author huisheng.jin
 * @version 2019/11/11.
 */
abstract class UnitNumberConverter {
    private static final String ROMAN_NUMBER_ONE = "I";
    private static final String ROMAN_NUMBER_FIVE = "V";
    private static final String ROMAN_NUMBER_TEN = "X";
    private static final String ROMAN_NUMBER_FIFTY = "L";
    private static final String ROMAN_HUNDRED = "C";
    private static final String ROMAN_NUMBER_ONE_THOUSAND = "M";
    private static final String ROMAN_NUMBER_FIVE_HUNDRED = "D";
    private static final Map<Integer, UnitNumberConverter> UNIT_CONVERTER_LIST;
    private static final BigThanOneThousandUnitNumberConverter BIG_THAN_ONE_THOUSAND_UNIT_NUMBER_CONVERTER;

    final String romanOneUnitNumber;
    final String romanTenUnitNumber;
    final String romanFiveUnitNumber;

    UnitNumberConverter(String romanOneUnitNumber, String romanTenUnitNumber, String romanFiveUnitNumber) {
        this.romanOneUnitNumber = romanOneUnitNumber;
        this.romanTenUnitNumber = romanTenUnitNumber;
        this.romanFiveUnitNumber = romanFiveUnitNumber;
    }


    static {
        UNIT_CONVERTER_LIST = new HashMap<>();
        UNIT_CONVERTER_LIST.put(0, new CommonUnitNumberConverter(ROMAN_NUMBER_ONE, ROMAN_NUMBER_TEN, ROMAN_NUMBER_FIVE));
        UNIT_CONVERTER_LIST.put(1, new CommonUnitNumberConverter(ROMAN_NUMBER_TEN, ROMAN_HUNDRED, ROMAN_NUMBER_FIFTY));
        UNIT_CONVERTER_LIST.put(2, new CommonUnitNumberConverter(ROMAN_HUNDRED, ROMAN_NUMBER_ONE_THOUSAND, ROMAN_NUMBER_FIVE_HUNDRED));

        BIG_THAN_ONE_THOUSAND_UNIT_NUMBER_CONVERTER = new BigThanOneThousandUnitNumberConverter(ROMAN_NUMBER_ONE_THOUSAND);
    }

    static UnitNumberConverter getByIndex(int index) {
        UnitNumberConverter unitNumberConverter = UNIT_CONVERTER_LIST.get(index);
        if (Objects.nonNull(unitNumberConverter)) {
            return unitNumberConverter;
        }
        return BIG_THAN_ONE_THOUSAND_UNIT_NUMBER_CONVERTER;
    }

    public abstract String convert(int unitDigitNumber, int currentUnit);

    protected String collectRoman(int number, String romanNumber) {
        return IntStream.range(0, number)
                .mapToObj(String::valueOf).map(str -> join(romanNumber))
                .collect(Collectors.joining());
    }

    protected String join(String roman) {
        return roman;
    }
}
