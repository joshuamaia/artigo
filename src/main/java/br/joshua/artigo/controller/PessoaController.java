package br.joshua.artigo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.joshua.artigo.model.entity.Pessoa;
import br.joshua.artigo.model.repository.PessoaRepository;

@RestController
@RequestMapping("/rest/pessoa")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;

	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Pessoa>> listar() {

		List<Pessoa> lista = pessoaRepository.findAll();

		return ResponseEntity.ok(lista);
	}

	@RequestMapping(path = "/criar", method = RequestMethod.POST)
	public ResponseEntity<Pessoa> criar(@RequestBody Pessoa pessoa) {

		if (pessoa == null) {
			new ResponseEntity<Pessoa>(HttpStatus.NOT_FOUND);
		}

		pessoa = pessoaRepository.save(pessoa);

		return new ResponseEntity<Pessoa>(pessoa, HttpStatus.CREATED);
	}

	@RequestMapping(path = "/atualizar", method = RequestMethod.PUT)
	public ResponseEntity<Pessoa> atualizar(@RequestBody Pessoa pessoa) {

		if (pessoa == null || pessoa.getId() == null) {
			new ResponseEntity<Pessoa>(HttpStatus.NOT_FOUND);
		}

		pessoa = pessoaRepository.save(pessoa);

		return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
	}

	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pessoa> listarPessoaPorId(@PathVariable("id") Long id) {

		if (id == null) {
			new ResponseEntity<Pessoa>(HttpStatus.NOT_FOUND);
		}

		Pessoa pessoa = pessoaRepository.getOne(id);

		return ResponseEntity.ok(pessoa);
	}

	@RequestMapping(path = "/excluir/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {

		if (id == null) {
			new ResponseEntity<Pessoa>(HttpStatus.NOT_FOUND);
		}

		pessoaRepository.deleteById(id);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
