package br.com.zup.casadocodigo.categorias;

import javax.validation.constraints.NotBlank;

import br.com.zup.casadocodigo.validation.UniqueValue;

public class CategoriaDTO {
	
	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;
	
	public CategoriaDTO() {
	}

	public CategoriaDTO(@NotBlank String nome) {
		this.nome = nome;
	}

	public Categoria toModel() {
		return new Categoria(this.nome);
	}

	public Object getNome() {
		return this.nome;
	}
}
