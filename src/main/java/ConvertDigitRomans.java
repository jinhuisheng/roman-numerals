import java.util.ArrayList;

/**
 * @author huisheng.jin
 * @date 2020/11/24.
 */
public class ConvertDigitRomans {
    private static ArrayList<ConvertDigitRoman> list;

    static {
        list = new ArrayList<>();
        list.add(new ConvertDigitRoman("digit"
                , "I"
                , "IV"
                , "V", "IX"));
        list.add(new ConvertDigitRoman("tenDigit"
                , "X"
                , "XL"
                , "L"
                , "XC"));
        list.add(new ConvertDigitRoman("hundredDigit"
                , "C"
                , "CD"
                , "D"
                , "CM"));

    }

    public static ConvertDigitRoman getDigitRoman(String digitName) {
        return list.stream().filter(item -> item.getDigitName().equals(digitName)).findFirst().get();
    }


}
