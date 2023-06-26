import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.format.DateTimeParseException;
import static org.junit.jupiter.api.Assertions.*;

class HoroscopeConverterTest {

    HoroscopeConverter horoscopeConverter = new HoroscopeConverter();

    @Test
    @DisplayName("method getStarSign should return Aries when the input date is between March 21st and April 19th")
    public void getStarSignShouldReturnAriesWhenGivenRightInput() {
        // given
        String date = "23.03";
        //when
        String actualRes = horoscopeConverter.getStarSign(date);
        //then
        String expectedRes = "Aries";
        assertEquals(expectedRes, actualRes);
    }

    @Test
    @DisplayName("method getStarSign should display DateTimeParseException when the input date is in the wrong format")
    public void getStarSignShouldDisplayExceptionWhenGivenWrongInput() {
        // given
        String date = "23.03.";
        //when
        Exception exception = assertThrows(DateTimeParseException.class, () -> horoscopeConverter.getStarSign(date));
        //then
        String expectedMessage = "Text '23.03..1904' could not be parsed at index 6";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
