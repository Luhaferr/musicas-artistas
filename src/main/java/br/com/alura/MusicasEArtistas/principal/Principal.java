package br.com.alura.MusicasEArtistas.principal;

import br.com.alura.MusicasEArtistas.model.*;
import br.com.alura.MusicasEArtistas.repository.AlbumRepository;
import br.com.alura.MusicasEArtistas.repository.ArtistRepository;
import br.com.alura.MusicasEArtistas.repository.MusicRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private List<Artista> artistas = new ArrayList<>();
    private List<Musica> musicas = new ArrayList<>();
    private ArtistRepository artistRepository;
    private MusicRepository musicRepository;
    private AlbumRepository albumRepository;
    private Artista artista;

    public Principal(ArtistRepository ArtistRepository, MusicRepository musicRepository, AlbumRepository albumRepository) {
        this.artistRepository = ArtistRepository;
        this.musicRepository = musicRepository;
        this.albumRepository = albumRepository;
    }

    public void exibirMenu() {
        int opcao = -1;
        while (opcao != 0) {
            String menu = """
                    1 - Cadastrar artistas
                    2 - Cadastrar músicas
                    3 - Pesquisar músicas por artistas
                    4 - Pesquisar músicas por ano de lançamento
                    5 - Listar músicas
                    6 - Cadastrar album
                    
                    0 - Sair
                    """;

            System.out.println(menu);
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarArtistas();
                    break;
                case 2:
                    cadastrarMusicas();
                    break;
                case 3:
                    pesquisarMusicasPorArtista();
                    break;
                case 4:
                    pesquisarMusicasPorAno();
                    break;
                case 5:
                    listarMusica();
                    break;
                case 6:
                    cadastrarAlbum();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void cadastrarArtistas() {
        String cadastrarNovo = "S";

        while (cadastrarNovo.equalsIgnoreCase("S")) {
            System.out.println("Informe o nome do artista: ");
            String nome = scanner.nextLine();
            System.out.println("Informe a categoria desse artista: (solo, dupla ou banda)");
            String tipo = scanner.nextLine();
            Categoria categoria = Categoria.valueOf(tipo.toUpperCase());
            System.out.println("Informe o gênero musical desse artista: ");
            String generomMusical = scanner.nextLine();
            Genero genero = Genero.valueOf(generomMusical.toUpperCase());
            Artista artista = new Artista(nome, categoria, genero);
            artistRepository.save(artista);
            System.out.println("Cadastrar novo artista? (S/N)");
            cadastrarNovo = scanner.nextLine();
        }
    }

    private void cadastrarMusicas() {
        System.out.println("Essa música é de qual artista?");
        String nomeArtista = scanner.nextLine();

        Optional<Artista> artistaBuscado = artistRepository.findByNomeContainingIgnoreCase(nomeArtista);

        if (artistaBuscado.isPresent()) {
            Artista artista = artistaBuscado.get();
            System.out.println("Qual o nome da música?");
            String nomeMusica = scanner.nextLine();
            System.out.println("Qual o ano de lançamento?");
            int ano = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Qual sua avaliação sobre a música?");
            Double avaliacao = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Qual o gênero dessa música?");
            Genero generoMusical = Genero.valueOf(scanner.nextLine().toUpperCase());
            Musica musica = new Musica(nomeMusica, artista, ano, avaliacao, generoMusical);
            musicRepository.save(musica);

        } else {
            System.out.println("Artista não encontrado! Cadastre um artista primeiro");
            cadastrarArtistas();
        }
    }

    private void cadastrarAlbum() {
        System.out.println("Digite o nome do artista para ver sua coleção de albuns");
        String nomeArtista = scanner.nextLine();

        Optional<Artista> artistaBuscado = artistRepository.findByNomeContainingIgnoreCase(nomeArtista);
        if (artistaBuscado.isPresent()) {
            Artista artista = artistaBuscado.get();
            System.out.println("Qual o nome do album?");
            String nomeAlbum = scanner.nextLine();
            System.out.println("Qual o ano de lançamento?");
            int ano = scanner.nextInt();
            scanner.nextLine();
            Album album = new Album(nomeAlbum, artista, ano);
            albumRepository.save(album);
        } else {
            System.out.println("Artista não encontrado! Cadastre um artista primeiro");
            cadastrarArtistas();
        }
    }

    private void pesquisarMusicasPorArtista() {
        System.out.println("Digite o nome do artista para ver sua coleção de músicas");
        String nomeArtista = scanner.nextLine();

        Optional<Artista> artistaBuscado = artistRepository.findByNomeContainingIgnoreCase(nomeArtista);
        if (artistaBuscado.isPresent()) {
            Artista artista = artistaBuscado.get();
            System.out.println("Artista: " + artista.getNome() + " - " + "Músicas: " + artista.getMusicas());
        } else {
            System.out.println("Artista não encontrado");
        }
    }

    private void pesquisarMusicasPorAno() {
        System.out.println("Você quer buscar as músicas de qual ano?");
        int ano = scanner.nextInt();
        scanner.nextLine();
        musicas = musicRepository.findByAnoLancamento(ano);
        musicas.forEach(m -> System.out.println("Título: " + m.getTitulo() + " - Artista: " + m.getArtista().getNome() + " - Gênero: " + m.getGenero() + " - Avaliação: " + m.getAvaliacao()));
    }

    private void listarMusica() {
        artistas = artistRepository.findAll();
        if (artistas.isEmpty()) {
            System.out.println("Nenhuma música encontrada!");
        } else {
            artistas.forEach(System.out::println);
        }
    }
}
