import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HoroscopeClientTest {

    HoroscopeClient horoscopeClient = new HoroscopeClient();

    @Test
    @DisplayName("fetches a horoscope for a user")
    public void getDataReturnsHoroscope() {
    }

}
