package br.com.alura.MusicasEArtistas.model;

import java.time.LocalDate;

public class Musica {
    private Long id;
    private String nome;
    private Artista artista;
    private LocalDate anoLancamento;
    private Double avaliacao;
    private String compositor;
    private Genero genero;
}
