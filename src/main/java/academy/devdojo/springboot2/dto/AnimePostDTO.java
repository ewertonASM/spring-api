package academy.devdojo.springboot2.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimePostDTO {
    @NotEmpty(message = " The anime name cannot be empty")
    private String name;
}
