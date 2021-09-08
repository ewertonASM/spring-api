package academy.devdojo.springboot2.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import lombok.Data;

@Data
public class AnimePostDTO {
    @NotEmpty(message = " The anime name cannot be empty")
    private String name;
}
