/**
 * @author huisheng.jin
 * @version 2019/11/11.
 */
public class BigThanOneThousandUnitNumberConverter extends UnitNumberConverter {

    BigThanOneThousandUnitNumberConverter(String romanOneUnitNumber) {
        super(romanOneUnitNumber, "", "");
    }

    @Override
    public String convert(int unitDigitNumber, int currentUnit) {

        return collectRoman((int) (unitDigitNumber * Math.pow(10, currentUnit - 3)), romanOneUnitNumber);
    }

}
