package academy.devdojo.springboot2.util;

import academy.devdojo.springboot2.dto.AnimePutDTO;

public class AnimePutDTOCreator {
    public static AnimePutDTO createAnimePutDTO(){
        return AnimePutDTO.builder()
                .id(AnimeCreator.createValidUpdateAnime().getId())
                .name(AnimeCreator.createValidUpdateAnime().getName())
                .build();
    }
}