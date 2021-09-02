package academy.aula.springboot2.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import academy.aula.springboot2.domain.Anime;

public interface AnimeRepository extends JpaRepository<Anime, Long>{



}
