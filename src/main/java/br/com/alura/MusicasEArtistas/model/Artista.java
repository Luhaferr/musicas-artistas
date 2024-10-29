package br.com.alura.MusicasEArtistas.model;

import java.util.List;

public class Artista {
    private Long id;
    private String nome;
    private Categoria tipo;
    private Genero genero;
    private int idade;
    private int totalAlbuns;
    private List<Musica> musicas;
}
