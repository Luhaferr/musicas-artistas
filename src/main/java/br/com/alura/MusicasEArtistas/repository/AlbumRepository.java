package br.com.alura.MusicasEArtistas.repository;

import br.com.alura.MusicasEArtistas.model.Album;
import br.com.alura.MusicasEArtistas.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {

}
