package academy.devdojo.springboot2.dto;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class AnimePutDTO {

    private Long id;
    private String name;
}
