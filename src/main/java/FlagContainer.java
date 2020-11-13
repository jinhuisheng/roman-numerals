import java.util.HashMap;

/**
 * @author huisheng.jin
 * @date 2020/11/13.
 */
public class FlagContainer {

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

    public static boolean containsKey(Integer number, String unit) {
        return map.containsKey(String.format("%s-%d", unit, number));
    }

    public static String getFlag(Integer number, String unit) {
        return map.get(String.format("%s-%d", unit, number));
    }

}
