package todo;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
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
            signIn();
     }
     public static void get() throws IOException, InterruptedException {
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
     public static void post() throws IOException, InterruptedException {
         Person person = new Person();
         person.setName("mura");
         person.setLastName("kek");
         person.setMiddleName("dddd");
         ObjectMapper objectMapper = new ObjectMapper();
         String body = objectMapper.writeValueAsString(person);
         HttpClient client = HttpClient.newHttpClient();
         HttpRequest request = HttpRequest.newBuilder()
                 .uri(URI.create("http://localhost:8080/people"))
                 .header("Content-Type","application/json")
                 .POST(HttpRequest.BodyPublishers.ofString(body))
                 .build();
         client.send(request,HttpResponse.BodyHandlers.ofString());

     }
    public static void signIn() throws IOException, InterruptedException {
         SignIn sign = new SignIn();
         sign.setUsername("user2");
         sign.setPassword("password2");
         ObjectMapper objectMapper = new ObjectMapper();
         String body = objectMapper.writeValueAsString(sign);
         HttpClient client = HttpClient.newHttpClient();
         HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/auth/sign-in"))
                .header("Content-Type","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}