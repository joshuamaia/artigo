package br.joshua.artigo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.joshua.artigo.model.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
