package academy.aula.springboot2.requests;

import java.util.UUID;

import lombok.Data;

@Data
public class AnimePutRequestBody {
    private Long id;
    private String name;
    
}
