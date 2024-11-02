package br.com.alura.MusicasEArtistas.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @ManyToOne
    private Artista artista;
    @OneToMany
    private List<Musica> musicas;
    private int dataLancamento;

    public Album(){

    }

    public Album(Artista artista) {
        this.artista = artista;
    }

    public Album(String titulo, Artista artista, int dataLancamento) {
        this.titulo = titulo;
        this.artista = artista;
        this.dataLancamento = dataLancamento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }

    public int getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(int dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}
