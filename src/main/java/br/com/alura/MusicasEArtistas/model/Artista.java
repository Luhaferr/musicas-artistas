package br.com.alura.MusicasEArtistas.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;
    @Enumerated(EnumType.STRING)
    private Categoria tipo;
    @Enumerated(EnumType.STRING)
    private Genero genero;
    private int totalAlbuns;
    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Musica> musicas;

    public Artista() {
    }

    public Artista(String nome, Categoria tipo, Genero generoMusical, int totalAlbuns) {
        this.nome = nome;
        this.tipo = tipo;
        this.genero = generoMusical;
        this.totalAlbuns = totalAlbuns;
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

    public Categoria getTipo() {
        return tipo;
    }

    public void setTipo(Categoria tipo) {
        this.tipo = tipo;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getTotalAlbuns() {
        return totalAlbuns;
    }

    public void setTotalAlbuns(int totalAlbuns) {
        this.totalAlbuns = totalAlbuns;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        musicas.forEach(m -> m.setArtista(this));
        this.musicas = musicas;
    }

    @Override
    public String toString() {
        return "Artista{" +
                ", nome='" + nome + '\'' +
                ", tipo=" + tipo +
                ", genero=" + genero +
                ", totalAlbuns=" + totalAlbuns +
                ", musicas=" + musicas +
                '}';
    }
}
