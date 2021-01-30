package br.com.zup.casadocodigo.autores;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zup.casadocodigo.validation.UniqueValue;

public class AutorDTO {

	@NotBlank
	private String nome;
	
	@NotBlank @Email @Column(unique = true)
	@UniqueValue(domainClass = Autor.class, fieldName = "email")
	private String email;
	
	@NotBlank @Size(max = 400)
	private String descricao;

	public AutorDTO(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
	}

	public Object getEmail() {
		return this.email;
	}
	
}
