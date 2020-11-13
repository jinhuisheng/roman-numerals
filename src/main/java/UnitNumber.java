import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author huisheng.jin
 * @date 2020/11/12.
 */
public class UnitNumber {
    private final Integer number;
    private final String unit;
    private static HashMap<Integer, String> map;

    static {
        map = new HashMap<>();
        map.put(1, "digit");
        map.put(2, "ten");
        map.put(3, "hundred");
        map.put(4, "thousand");
    }

    public UnitNumber(Integer number, String unit) {
        this.number = number;
        this.unit = unit;
    }

    public static List<UnitNumber> separateUnitNumber(Integer number) {
        String[] split = String.valueOf(number).split("");
        List<UnitNumber> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            list.add(new UnitNumber(Integer.valueOf(split[i]), map.get(split.length - 1 - i + 1)));
        }
        return list;
    }

    public Integer getNumber() {
        return number;
    }

    public String getUnit() {
        return unit;
    }
}
