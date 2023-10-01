import java.net.*;
import java.io.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class URLConnectionReader {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .header("X-Api-Key", "PbOAuMdHypMxB7vyekuVhA==QbRXiWly1NZxUQIJ")
                .uri(new URI("https://api.api-ninjas.com/v1/recipe?query=tomato+paste"))
                .build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }
}