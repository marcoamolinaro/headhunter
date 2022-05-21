package br.com.scm.headhunter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.scm.headhunter.dto.VagaDTO;
import br.com.scm.headhunter.entities.Vaga;
import br.com.scm.headhunter.repositories.VagaRepository;
import br.com.scm.headhunter.services.exceptions.ObjectNotFoundException;

@Service
public class VagaService {
	
	@Autowired
	private VagaRepository vagaRepository;
	
	@Transactional(readOnly = true)
	public Page<VagaDTO> findAll(Pageable pageable) {
		
		Page<Vaga> result = vagaRepository.findAll(pageable);
		
		Page<VagaDTO> dto = result.map(x -> new VagaDTO(x));
		
		return  dto;
	}
	
	@Transactional(readOnly = true)
	public VagaDTO findById(Long id) {
		try {
			Vaga vaga = vagaRepository.findById(id).get();
					
			return new VagaDTO(vaga);
		
		} catch (Exception e) {
			throw new ObjectNotFoundException("Vaga com id: " + id + " não encontrada.");
		}
	}
	
	@Transactional(readOnly = true) 
	public VagaDTO findByCodigo(Integer codigo) {
		try {
			Vaga vaga = vagaRepository.findByCodigo(codigo);
			
			return new VagaDTO(vaga);
			
		} catch (Exception e) {
			throw new ObjectNotFoundException("Vaga com código: " + codigo + " não encontrada.");
		}
	}
	
	@Transactional
	public void deleteByCodigo(Integer codigo) {
		findByCodigo(codigo);
		
		vagaRepository.deleteByCodigo(codigo);
	}

	@Transactional
	public void deleteById(Long id) {	
		try {
			vagaRepository.deleteById(id);		
		} catch (Exception e) {
			throw new ObjectNotFoundException("Vaga com id: " + id + " não encontrada.");
		}
	}

}
