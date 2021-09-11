package academy.devdojo.springboot2.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import academy.devdojo.springboot2.domain.Anime;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SpringClient {
    
    public static void main(String[] args) {
        ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:8080/animes/{id}", Anime.class, 2); 
        log.info(entity);

        Anime object = new RestTemplate().getForObject("http://localhost:8080/animes/{id}", Anime.class, 2);
        log.info(object);

        Anime[] animes = new RestTemplate().getForObject("http://localhost:8080/animes/all", Anime[].class);
        log.info(Arrays.toString(animes));

        ResponseEntity<List<Anime>> exchange = new RestTemplate().exchange("http://localhost:8080/animes/all", HttpMethod.GET, null,
                            new ParameterizedTypeReference<List<Anime>>(){});
        log.info(exchange.getBody());


        // Anime example = Anime.builder().name("my hero academia").build();
        // Anime exampleSaved = new RestTemplate().postForObject("http://localhost:8080/animes", example, Anime.class);
        // log.info("saved anime {}", exampleSaved);

        Anime exExample = Anime.builder().name("naruto").build();
        ResponseEntity<Anime> exExampleSaved = new RestTemplate().exchange("http://localhost:8080/animes",HttpMethod.POST,
                                                                            new HttpEntity<>(exExample, createJsonHeader()),
                                                                            Anime.class);
        log.info("saved anime {}", exExampleSaved);

        Anime exExampleForUpdate = exExampleSaved.getBody();
        exExampleForUpdate.setName("Naruto Shippuden");
        ResponseEntity<Void> exExampleUpdated = new RestTemplate().exchange("http://localhost:8080/animes",
                                                                             HttpMethod.PUT, 
                                                                             new HttpEntity<>(exExampleForUpdate, createJsonHeader()),
                                                                             Void.class);
        log.info("Updated anime {}", exExampleUpdated);

        ResponseEntity<Void> exExampleDeleted = new RestTemplate().exchange("http://localhost:8080/animes/{id}",
                                                                             HttpMethod.DELETE,
                                                                             null, 
                                                                             Void.class, 
                                                                             exExampleForUpdate.getId());
        log.info("Updated anime {}", exExampleDeleted);



    }

    private static HttpHeaders createJsonHeader(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;

    }
}
