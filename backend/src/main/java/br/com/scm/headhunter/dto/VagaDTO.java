package br.com.scm.headhunter.dto;

import java.util.Date;

import br.com.scm.headhunter.entities.Vaga;

public class VagaDTO {
	private Long id;
	private Integer codigo;
	private Date data;
	private String titulo;
	private String descricao;
	private Boolean status;
	private String link;
	private Boolean remota;
	private String nacInt;
	
	public VagaDTO() {}
	
	public VagaDTO(Long id, Integer codigo, Date data, String titulo, String descricao, Boolean status, String link,
			Boolean remota, String nacInt) {
		this.id = id;
		this.codigo = codigo;
		this.data = data;
		this.titulo = titulo;
		this.descricao = descricao;
		this.status = status;
		this.link = link;
		this.remota = remota;
		this.nacInt = nacInt;
	}
	
	public VagaDTO(Vaga vaga) {
		this.id = vaga.getId();
		this.codigo = vaga.getCodigo();
		this.data = vaga.getData();
		this.titulo = vaga.getTitulo();
		this.descricao = vaga.getDescricao();
		this.status = vaga.getStatus();
		this.link = vaga.getLink();
		this.remota = vaga.getRemota();
		this.nacInt = vaga.getNacInt();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Boolean getRemota() {
		return remota;
	}

	public void setRemota(Boolean remota) {
		this.remota = remota;
	}

	public String getNacInt() {
		return nacInt;
	}

	public void setNacInt(String nacInt) {
		this.nacInt = nacInt;
	}
}
