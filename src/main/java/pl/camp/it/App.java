package pl.camp.it;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.camp.it.model.Book;
import pl.camp.it.model.Order;
import pl.camp.it.model.User;

import java.util.List;
import java.util.Arrays;
import java.util.HashMap;

public class App {
    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();

        System.out.println("***************** /books endpoint *********************");
        String URL = "http://localhost:8081/api/books";

        Book[] books = restTemplate.getForObject(URL, Book[].class, new HashMap<>());

        System.out.println(Arrays.asList(books));

        String titleOfFirstBook = books[0].getTitle();

        System.out.println(titleOfFirstBook);

        System.out.println("***************** /authenticate endpoint *********************");
        String URL2 = "http://localhost:8081/api/authenticate";

        User user = new User();
        user.setLogin("mateusz5");
        user.setPassword("mateusz");

        HttpEntity<User> httpEntity = new HttpEntity<>(user);

        try {
            ResponseEntity responseEntity = restTemplate.exchange(URL2, HttpMethod.POST, httpEntity, ResponseEntity.class);
            System.out.println(responseEntity.getStatusCode());
        } catch (HttpClientErrorException.Unauthorized e) {
            System.out.println("401 !!");
        }

        System.out.println("***************** /orders endpoint *********************");
        String URL3 = "http://localhost:8081/api/orders";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("login", "mateusz");
        httpHeaders.set("password", "mateusz");

        HttpEntity httpEntity2 = new HttpEntity(httpHeaders);

        try {
            ResponseEntity<List<Order>> responseEntity =
                    restTemplate.exchange(URL3, HttpMethod.GET, httpEntity2, new ParameterizedTypeReference<List<Order>>() {});
            System.out.println(responseEntity.getBody());
        } catch (HttpClientErrorException.Unauthorized e) {
            System.out.println("Nie ma takiego usera !! 401 !!");
        }
    }
}
