package br.com.zup.casadocodigo.paises;

import javax.validation.constraints.NotBlank;

import br.com.zup.casadocodigo.validation.UniqueValue;

public class PaisRequest {

	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;
	
	public PaisRequest() {
	}

	public PaisRequest(@NotBlank String nome) {
		this.nome = nome;
	}

	public Pais toModel() {
		return new Pais(this.nome);
	}

	public String getNome() {
		return nome;
	}
	
}
