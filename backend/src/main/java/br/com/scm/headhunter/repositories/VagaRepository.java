package br.com.scm.headhunter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.scm.headhunter.entities.Vaga;

public interface VagaRepository extends JpaRepository<Vaga, Long> {

}
