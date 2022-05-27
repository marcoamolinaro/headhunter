package br.com.scm.headhunter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.scm.headhunter.dto.VagaDTO;
import br.com.scm.headhunter.entities.Vaga;
import br.com.scm.headhunter.repositories.VagaRepository;
import br.com.scm.headhunter.services.exceptions.ObjectFoundException;
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
	
	@Transactional
	public VagaDTO save(VagaDTO dto) {
		VagaDTO newDTO = null;
		
		try {
			Vaga vagaNew = saveVaga(dto);
			
			Vaga vaga = vagaRepository.saveAndFlush(vagaNew);
			
			vagaNew.setId(vaga.getId());
			newDTO = new VagaDTO(vagaNew);
		
		} catch (Exception e) {
			throw new ObjectFoundException("Vaga com código: " + dto.getCodigo() + " já cadastrada.");
		}
		
		return newDTO;			
	}

	
	@Transactional
	public VagaDTO update(VagaDTO dto) {
		VagaDTO vagaDTO = null;
		try {
			Vaga vaga = vagaRepository.findByCodigo(dto.getCodigo());
			
			updateVaga(dto, vaga);
			
			vagaRepository.saveAndFlush(vaga);
			
			vagaDTO = new VagaDTO(vaga);
		} catch (Exception e) {
			throw new ObjectNotFoundException("Vaga com código: " + dto.getCodigo() + " não encontrada.");
		}
		
		return vagaDTO;
	}
	
	@Transactional
	public VagaDTO updateStatus(VagaDTO dto) {
		VagaDTO vagaDTO = null;
		try {
			Vaga vaga = vagaRepository.findByCodigo(dto.getCodigo());
			
			updateVaga(dto, vaga);
			
			vagaRepository.saveAndFlush(vaga);
						
			vagaDTO = new VagaDTO(vaga);
		} catch (Exception e) {
			throw new ObjectNotFoundException("Vaga com código: " + dto.getCodigo() + " não encontrada.");
		}
		
		return vagaDTO;
	}


	private Vaga saveVaga(VagaDTO dto) {
		Vaga vagaNew = new Vaga();
		vagaNew.setCodigo(dto.getCodigo());
		vagaNew.setData(dto.getData());
		vagaNew.setDescricao(dto.getDescricao());
		vagaNew.setLink(dto.getLink());
		vagaNew.setNacInt(dto.getNacInt());
		vagaNew.setRemota(dto.getRemota());
		vagaNew.setStatus(dto.getStatus());
		vagaNew.setTitulo(dto.getTitulo());
		return vagaNew;
	}
	
	private void updateVaga(VagaDTO dto, Vaga vaga) {
		vaga.setId(dto.getId());
		vaga.setCodigo(dto.getCodigo());
		vaga.setData(dto.getData());
		vaga.setDescricao(dto.getDescricao());
		vaga.setLink(dto.getLink());
		vaga.setNacInt(dto.getNacInt());
		vaga.setRemota(dto.getRemota());
		vaga.setStatus(dto.getStatus());
		vaga.setTitulo(dto.getTitulo());
	}

}
