package br.com.scm.headhunter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public VagaDTO findByCodigo(@PathVariable Integer codigo) {
		return vagaService.findByCodigo(codigo);
	}
	
	@PostMapping(value="/save")
	public VagaDTO save(@RequestBody VagaDTO dto) {
		VagaDTO vagaDto = vagaService.save(dto);
		return vagaDto;
	}

	@PutMapping(value="/update")
	public VagaDTO update(@RequestBody VagaDTO dto) {
		VagaDTO vagaDto = vagaService.update(dto);
		return vagaDto;
	}
	
	@PutMapping(value="/updatestatus")
	public VagaDTO updateStatus(@RequestBody VagaDTO dto) {
		VagaDTO vagaDto = vagaService.update(dto);
		return vagaDto;
	}
	
	@DeleteMapping(value = "/codigo/{codigo}")
	public void deleteByCodigo(@PathVariable Integer codigo) {
		vagaService.deleteByCodigo(codigo);
	}

	@DeleteMapping(value = "/id/{id}")
	public void deleteById(@PathVariable Long id) {
		vagaService.deleteById(id);
	}

}
