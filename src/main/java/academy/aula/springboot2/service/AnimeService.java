package academy.aula.springboot2.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import academy.aula.springboot2.domain.Anime;
import academy.aula.springboot2.repository.AnimeRepository;

@Service
public class AnimeService {


    private List<Anime> animes = List.of(new Anime(1L,"DBZ"), new Anime(2L,"Bersek"));

    // private final AnimeRepository animeRepository;
    public List<Anime> listAll(){
        return animes;         
    }

    public Anime findById(Long id){
        return animes.stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
                
    }
    
}
