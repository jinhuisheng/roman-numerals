/**
 * @author huisheng.jin
 * @date 2020/11/12.
 */
public class UnitNumber {
    private final Integer number;
    private final String unit;

    public UnitNumber(Integer number, String unit) {

        this.number = number;
        this.unit = unit;
    }

    public Integer getNumber() {
        return number;
    }

    public String getUnit() {
        return unit;
    }
}
