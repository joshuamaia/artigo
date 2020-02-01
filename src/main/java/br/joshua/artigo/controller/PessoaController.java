package br.joshua.artigo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.joshua.artigo.model.entity.Pessoa;
import br.joshua.artigo.model.repository.PessoaRepository;

@RestController
@RequestMapping("/rest/pessoa")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;

	@GetMapping(path = "/listar")
	public ResponseEntity<Object> listar() {

		try {

			List<Pessoa> lista = pessoaRepository.findAll();

			return ResponseEntity.ok(lista);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping(path = "/criar")
	public ResponseEntity<Object> criar(@RequestBody Pessoa pessoa) {

		try {
			if (pessoa == null) {
				new ResponseEntity<Pessoa>(HttpStatus.NOT_FOUND);
			}

			pessoa = pessoaRepository.save(pessoa);

			return new ResponseEntity<Object>(pessoa, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping(path = "/atualizar")
	public ResponseEntity<Object> atualizar(@RequestBody Pessoa pessoa) {

		try {
			if (pessoa == null || pessoa.getId() == null) {
				new ResponseEntity<Pessoa>(HttpStatus.NOT_FOUND);
			}

			pessoa = pessoaRepository.save(pessoa);

			return new ResponseEntity<Object>(pessoa, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(path = "/listar/{id}")
	public ResponseEntity<Object> listarPorId(@PathVariable("id") Long id) {

		try {
			if (id == null) {
				new ResponseEntity<Pessoa>(HttpStatus.NOT_FOUND);
			}

			Pessoa pessoa = pessoaRepository.getOne(id);

			return ResponseEntity.ok(pessoa);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping(path = "/excluir/{id}")
	public ResponseEntity<Object> excluir(@PathVariable("id") Long id) {

		try {
			if (id == null) {
				new ResponseEntity<Pessoa>(HttpStatus.NOT_FOUND);
			}

			pessoaRepository.deleteById(id);

			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

}
