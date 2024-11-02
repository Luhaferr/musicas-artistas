package br.com.alura.MusicasEArtistas.model;

import java.time.LocalDateTime;
import java.util.List;

public record AlbumDTO(Long id, String titulo, Artista artista, List<Musica> musicas, LocalDateTime dataLancamento) {
}
