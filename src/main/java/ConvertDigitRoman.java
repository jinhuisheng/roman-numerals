/**
 * @author huisheng.jin
 * @date 2020/11/24.
 */
public class ConvertDigitRoman {
    private final String currentDigitRomanNumberOne;
    private final String currentDigitRomanNumberFour;
    private final String currentDigitRomanNumberFive;
    private final String currentDigitRomanNumberNine;
    private final String digitName;

    public ConvertDigitRoman(String digitName, String currentDigitRomanNumberOne
            , String currentDigitRomanNumberFour
            , String currentDigitRomanNumberFive
            , String currentDigitRomanNumberNine) {
        this.digitName = digitName;
        this.currentDigitRomanNumberOne = currentDigitRomanNumberOne;
        this.currentDigitRomanNumberFour = currentDigitRomanNumberFour;
        this.currentDigitRomanNumberFive = currentDigitRomanNumberFive;
        this.currentDigitRomanNumberNine = currentDigitRomanNumberNine;
    }

    public String getDigitName() {
        return digitName;
    }

    public String getCurrentDigitRomanNumberOne() {
        return currentDigitRomanNumberOne;
    }

    public String getCurrentDigitRomanNumberFour() {
        return currentDigitRomanNumberFour;
    }

    public String getCurrentDigitRomanNumberFive() {
        return currentDigitRomanNumberFive;
    }

    public String getCurrentDigitRomanNumberNine() {
        return currentDigitRomanNumberNine;
    }
}
