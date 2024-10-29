package br.com.alura.MusicasEArtistas.repository;

import br.com.alura.MusicasEArtistas.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artista, Long> {

}
