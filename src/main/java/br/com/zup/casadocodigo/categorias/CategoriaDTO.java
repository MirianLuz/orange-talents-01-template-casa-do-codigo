package br.com.zup.casadocodigo.categorias;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class CategoriaDTO {
	
	@NotBlank
	@Column(unique = true)
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
