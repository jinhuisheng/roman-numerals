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

            "21,XXI",
            "22,XXII",

            "24,XXIV",
            "25,XXV",

            "29,XXIX",
            "30,XXX",
            "31,XXXI",
            "39,XXXIX",

            "40,XL",
            "41,XLI",
            "42,XLII",
            "43,XLIII",
            "44,XLIV",
            "45,XLV",
            "46,XLVI",
            "47,XLVII",

            "50,L",
            "51,LI",
            "60,LX",
            "61,LXI",
            "81,LXXXI",
            "91,XCI",
            "97,XCVII",
            "101,CI",
            "102,CII",

            "502,DII",
            "572,DLXXII",
            "872,DCCCLXXII",

            "901,CMI",
            "989,CMLXXXIX",
            "999,CMXCIX",


            "1001,MI",
            "2751,MMDCCLI",

            "10000,MMMMMMMMMM",
            "11000,MMMMMMMMMMM",
            "12000,MMMMMMMMMMMM",
            "132000,MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM",

    })
    void convert(Integer number, String expectedValue) {
        assertThat(RomanNumerals.convert(number)).isEqualTo(expectedValue);
    }
}
