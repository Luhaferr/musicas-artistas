package br.com.alura.MusicasEArtistas.principal;

import br.com.alura.MusicasEArtistas.model.Artista;
import br.com.alura.MusicasEArtistas.model.Categoria;
import br.com.alura.MusicasEArtistas.model.Genero;
import br.com.alura.MusicasEArtistas.model.Musica;
import br.com.alura.MusicasEArtistas.repository.ArtistRepository;
import br.com.alura.MusicasEArtistas.repository.MusicRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private List<Artista> artistas = new ArrayList<>();
    private List<Musica> musicas = new ArrayList<>();
    private ArtistRepository artistRepository;
    private MusicRepository musicRepository;

    public Principal(ArtistRepository ArtistRepository, MusicRepository musicRepository) {
        this.artistRepository = ArtistRepository;
        this.musicRepository = musicRepository;
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
            System.out.println("Informe o nome desse artista: ");
            String nome = scanner.nextLine();
            System.out.println("Informe a categoria desse artista: (solo, dupla ou banda)");
            String tipo = scanner.nextLine();
            Categoria categoria = Categoria.valueOf(tipo.toUpperCase());
            System.out.println("Informe o gênero musical desse artista: ");
            String generomMusical = scanner.nextLine();
            Genero genero = Genero.valueOf(generomMusical.toUpperCase());
            System.out.println("Informe o total de albuns desse artista: ");
            int albuns = scanner.nextInt();
            Artista artista = new Artista(nome, categoria, genero, albuns);
            artistRepository.save(artista);
            System.out.println("Cadastrar novo artista? (S/N)");
            cadastrarNovo = scanner.nextLine();
        }
    }

    private void cadastrarMusicas() {
        System.out.println("Essa música é de qual artista?");
        //VERIFICAR SE ARTISTA JÁ ESTÁ CADASTRADO
        //ASSOCIAR ESSE ARTISTA DO BR À MUSICA
    }

    private void pesquisarMusicasPorArtista() {
    }

    private void pesquisarMusicasPorAno() {
    }

    private void listarMusica() {
        List<Musica> musicaList = musicRepository.findAll();
        if (musicaList.isEmpty()) {
            System.out.println("Nenhuma música encontrada!");
        } else {
            musicaList.forEach(System.out::println);
        }
    }
}
