package br.com.zup.casadocodigo.estados;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.casadocodigo.paises.Pais;
import br.com.zup.casadocodigo.paises.PaisRepository;
import br.com.zup.casadocodigo.validation.ExistId;
import br.com.zup.casadocodigo.validation.UniqueValue;

public class EstadoRequest {

	@NotBlank 
	@UniqueValue(domainClass = Estado.class, fieldName = "nome")
	private String nome;
	
	@NotNull
	@ExistId(domainClass = Pais.class, fieldName = "id")
	private Long idPais;

	public EstadoRequest(@NotBlank String nome, @NotNull Long idPais) {
		this.nome = nome;
		this.idPais = idPais;
	}

	public Long getIdPais() {
		return idPais;
	}

	public Estado toModel(PaisRepository paisRepository) {
		@NotNull Pais pais = paisRepository.getOne(this.idPais);
		return new Estado(this.nome, pais);
	}
	
}
