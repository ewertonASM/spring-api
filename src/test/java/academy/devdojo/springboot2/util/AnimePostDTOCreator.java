package academy.devdojo.springboot2.util;

import academy.devdojo.springboot2.dto.AnimePostDTO;

public class AnimePostDTOCreator {

    public static AnimePostDTO createAnimePostDTO(){
        return AnimePostDTO.builder()
                .name(AnimeCreator.createAnimeToBeSaved().getName())
                .build();

    }
}