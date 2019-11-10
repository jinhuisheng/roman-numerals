import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author huisheng.jin
 * @version 2019/11/9.
 */
public class RomanNumeralsTest {
//    @Test
//    void demo() {
//        assertThat(RomanNumerals.convert(1)).isEqualTo("I");
//    }


    @ParameterizedTest
    @CsvSource({
            "1,I",
            "2,II",
            "3,III",

            "4,IV",
            "5,V",
            "6,VI",
            "7,VII",
            "8,VIII",

            "9,IX",
            "10,X",
            "11,XI",
            "12,XII",
            "13,XIII",
            "14,XIV",
            "15,XV",
            "16,XVI",
            "17,XVII",
            "18,XVIII",
            "19,XIX",
            "20,XX",

    })
    void convert(Integer number, String expectedValue) {
        assertThat(RomanNumerals.convert(number)).isEqualTo(expectedValue);
    }
}
