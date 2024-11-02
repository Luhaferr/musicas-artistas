package br.com.alura.MusicasEArtistas;

import br.com.alura.MusicasEArtistas.principal.Principal;
import br.com.alura.MusicasEArtistas.repository.AlbumRepository;
import br.com.alura.MusicasEArtistas.repository.ArtistRepository;
import br.com.alura.MusicasEArtistas.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusicasEArtistasApplication implements CommandLineRunner {
	@Autowired
	private ArtistRepository artistRepository;
	@Autowired
	private MusicRepository musicRepository;
	@Autowired
	private AlbumRepository albumRepository;

	public static void main(String[] args) {
		SpringApplication.run(MusicasEArtistasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(artistRepository, musicRepository, albumRepository);
		principal.exibirMenu();
	}
}
