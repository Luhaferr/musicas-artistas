package br.com.alura.MusicasEArtistas.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne
    private Artista artista;
    private LocalDate anoLancamento;
    private Double avaliacao;
    @Enumerated(EnumType.STRING)
    private Genero genero;

    public Musica() {
    }

    public Musica(String nome, Artista artista, LocalDate anoLancamento, Double avaliacao, Genero genero) {
        this.nome = nome;
        this.artista = artista;
        this.anoLancamento = anoLancamento;
        this.avaliacao = avaliacao;
        this.genero = genero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public LocalDate getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(LocalDate anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Musica{" +
                ", nome='" + nome + '\'' +
                ", artista=" + artista +
                ", anoLancamento=" + anoLancamento +
                ", avaliacao=" + avaliacao +
                ", genero=" + genero +
                '}';
    }
}
