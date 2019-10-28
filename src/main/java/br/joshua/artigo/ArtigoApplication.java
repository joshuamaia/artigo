package br.joshua.artigo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.joshua.artigo.model.entity.Pessoa;
import br.joshua.artigo.model.repository.PessoaRepository;

@SpringBootApplication
public class ArtigoApplication implements CommandLineRunner {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ArtigoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		if (pessoaRepository.count() < 1) {
			
			Pessoa p1 = new Pessoa();
			p1.setNome("Carimbo");
			p1.setEmail("carimbo@email.com");
			
			Pessoa p2 = new Pessoa();
			p2.setNome("Porta");
			p2.setEmail("porta@email.com");
			
			Pessoa p3 = new Pessoa();
			p3.setNome("Mesa");
			p3.setEmail("mesa@email.com");
			
			pessoaRepository.save(p1);
			pessoaRepository.save(p2);
			pessoaRepository.save(p3);
			
		}
		
	}

}
