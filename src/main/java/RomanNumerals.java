import java.util.ArrayList;
import java.util.List;

/**
 * @author huisheng.jin
 * @version 2019/11/9.
 */
public class RomanNumerals {

    private final StringBuilder result = new StringBuilder();
    private final List<Integer> eachUnitNumbers;

    private RomanNumerals(int number) {
        this.eachUnitNumbers = createUnitNumbers(number);
    }

    public static String convert(int number) {
        RomanNumerals romanNumerals = new RomanNumerals(number);
        romanNumerals.convert();
        return romanNumerals.getResult();
    }

    private String getResult() {
        return this.result.toString();
    }

    private void convert() {
        for (int currentUnitIndex = eachUnitNumbers.size() - 1
             ; currentUnitIndex >= 0; currentUnitIndex--) {
            convertUnitNumber(currentUnitIndex);
        }
    }

    private void convertUnitNumber(int currentUnitIndex) {
        UnitNumberConverter unitNumberConverter = UnitNumberConverter.getByIndex(currentUnitIndex);
        Integer currentDigitNumber = eachUnitNumbers.get(currentUnitIndex);
        this.result.append(unitNumberConverter.convert(currentDigitNumber,currentUnitIndex));
    }

    private List<Integer> createUnitNumbers(int number) {
        char[] chars = getNumberCharOrderByUnitFromHighToLow(number);
        return getUnitNumbers(chars);
    }

    private List<Integer> getUnitNumbers(char[] chars) {
        List<Integer> eachUnitNumbers = new ArrayList<>();
        for (char aChar : chars) {
            eachUnitNumbers.add(Integer.parseInt(String.valueOf(aChar)));
        }
        return eachUnitNumbers;
    }

    private char[] getNumberCharOrderByUnitFromHighToLow(int number) {
        return new StringBuilder(String.valueOf(number))
                .reverse()
                .toString()
                .toCharArray();
    }

}
