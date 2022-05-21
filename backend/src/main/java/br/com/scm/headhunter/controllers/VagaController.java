package br.com.scm.headhunter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.scm.headhunter.dto.VagaDTO;
import br.com.scm.headhunter.services.VagaService;

@RestController
@RequestMapping(value = "/vagas")
public class VagaController {
	
	@Autowired
	private VagaService vagaService;
	
	@GetMapping
	public Page<VagaDTO> findAll(Pageable pageable) {
		return vagaService.findAll(pageable);
	}

	@GetMapping(value = "/id/{id}")
	public VagaDTO findById(@PathVariable Long id) {
		return vagaService.findById(id);
	}
	
	@GetMapping(value = "/codigo/{codigo}")
	public VagaDTO findById(@PathVariable Integer codigo) {
		return vagaService.findByEmail(codigo);
	}

}