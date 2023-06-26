import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HoroscopeClient {

    private final String baseUrl = "https://aztro.sameerkumar.website";
    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String postRequest (String starSign, String day) {
        String fullUrl = this.baseUrl + "/?sign=" + starSign + "&day=" + day;
        String json = null;

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(fullUrl))
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
            json = response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return json;
    }

    public HoroscopeResponse getData (String starSign, String day) throws IOException {
        String horoscopeJson = this.postRequest(starSign, day);
        return this.objectMapper.readValue(horoscopeJson, HoroscopeResponse.class);
    }


}
