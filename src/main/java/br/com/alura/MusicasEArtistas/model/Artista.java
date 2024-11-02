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
    @OneToMany
    private List<Album> albuns;
    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Musica> musicas;

    public List<Album> getAlbuns() {
        return albuns;
    }

    public void setAlbuns(List<Album> albuns) {
        albuns.forEach(a -> a.setArtista(this));
        this.albuns = albuns;
    }

    public Artista() {
    }

    public Artista(String nome, Categoria tipo, Genero generoMusical) {
        this.nome = nome;
        this.tipo = tipo;
        this.genero = generoMusical;

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
                ", musicas=" + musicas +
                '}';
    }
}
