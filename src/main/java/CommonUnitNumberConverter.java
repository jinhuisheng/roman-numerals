
/**
 * @author huisheng.jin
 * @version 2019/11/11.
 */
public class CommonUnitNumberConverter extends UnitNumberConverter {
    private static final int NINE = 9;
    private static final int FIVE = 5;
    private static final int FOUR = 4;
    private static final int ZERO = 0;

    CommonUnitNumberConverter(String romanOneUnitNumber, String romanTenUnitNumber, String romanFiveUnitNumber) {
        super(romanOneUnitNumber, romanTenUnitNumber, romanFiveUnitNumber);
    }

    @Override
    public String convert(int unitDigitNumber, int currentUnit) {
        if (unitDigitNumber == ZERO) {
            return "";
        }
        if (unitDigitNumber == NINE) {
            return convertNumberNineByUnit(join(romanOneUnitNumber), romanTenUnitNumber);
        } else {
            return convertLessThanNumberNineByUnit(unitDigitNumber, romanFiveUnitNumber, romanOneUnitNumber);
        }
    }

    private String convertLessThanNumberNineByUnit(int number, String romanRelateFiveNumber, String romanNumber) {
        if (number < FOUR) {
            return convertLessThanFourNumberBy(number, romanNumber);
        } else if (number == FOUR) {
            return convertNumberFourByUnit(romanRelateFiveNumber, romanNumber);
        } else {
            return convertNumberBiggerThanFourAndLessThanNine(number, romanRelateFiveNumber, romanNumber);
        }
    }

    private String convertLessThanFourNumberBy(int number, String romanNumber) {
        return collectRoman(number, romanNumber);
    }

    private String convertNumberNineByUnit(String romanFive, String s) {
        return romanFive + s;
    }

    private String convertNumberFourByUnit(String romanRelateFiveNumber, String romanNumberPre) {
        return join(romanNumberPre) + romanRelateFiveNumber;
    }

    private String convertNumberBiggerThanFourAndLessThanNine(int number, String romanRelateFiveNumber, String romanNumber) {
        return romanRelateFiveNumber + convertLessThanFourNumberBy(number - FIVE, romanNumber);
    }

}
