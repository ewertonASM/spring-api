package academy.devdojo.springboot2.dto;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnimePostDTO {
    @NotEmpty(message = " The anime name cannot be empty")
    private String name;
}
