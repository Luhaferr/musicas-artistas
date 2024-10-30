package br.com.alura.MusicasEArtistas.repository;

import br.com.alura.MusicasEArtistas.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Musica, Long> {
}
