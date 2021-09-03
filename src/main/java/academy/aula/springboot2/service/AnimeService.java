package academy.aula.springboot2.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import academy.aula.springboot2.domain.Anime;
import academy.aula.springboot2.repository.AnimeRepository;
import academy.aula.springboot2.requests.AnimePostRequestBody;
import academy.aula.springboot2.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;
    public List<Anime> listAll(){
        return animeRepository.findAll();         
    }

    public Anime findById(Long id){
        return animeRepository.findById(id)
                 .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
                
    }

    public Anime save(AnimePostRequestBody animePostRequestBody) {

       Anime anime = Anime.builder().name(animePostRequestBody.getName()).build();
       return animeRepository.save(anime);

    }

    public void delete(Long id) {
        animeRepository.delete(findById(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {

        findById(animePutRequestBody.getId());
        Anime anime = Anime.builder().id(animePutRequestBody.getId())
                        .id(animePutRequestBody.getId())
                        .build();
        
        animeRepository.save(anime);
    }

    
    
}
