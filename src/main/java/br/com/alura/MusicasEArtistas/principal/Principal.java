package br.com.alura.MusicasEArtistas.principal;

import br.com.alura.MusicasEArtistas.model.Artista;
import br.com.alura.MusicasEArtistas.model.Musica;
import br.com.alura.MusicasEArtistas.repository.ArtistRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private List<Artista> artistas = new ArrayList<>();
    private List<Musica> musicas = new ArrayList<>();
    private ArtistRepository repository;

    public Principal(ArtistRepository repository) {
        this.repository = repository;
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
    }

    private void cadastrarMusicas() {
    }

    private void pesquisarMusicasPorArtista() {
    }

    private void pesquisarMusicasPorAno() {
    }

    private void listarMusica() {
    }
}
