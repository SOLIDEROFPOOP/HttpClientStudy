package todo;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class HttpHandler {

     public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
         HttpRequest request = HttpRequest.newBuilder()
                 .uri(URI.create("http://localhost:8080/people"))
                 .header("Content-Type","application/json")
                 .GET()
                 .build();

         HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

         ObjectMapper mapper = new ObjectMapper();
         ArrayList<Person> people = mapper.readValue(response.body(), new TypeReference<ArrayList<Person>>(){});
         people.forEach(p -> System.out.println(p.toString()));
     }

}