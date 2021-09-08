package academy.devdojo.springboot2.dto;

import java.util.Optional;

import lombok.Data;

@Data
public class AnimePutDTO {
    private Optional<String> name;
}
