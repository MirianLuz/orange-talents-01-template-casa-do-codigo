package br.com.zup.casadocodigo.cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.casadocodigo.endereco.Endereco;
import br.com.zup.casadocodigo.validation.CPFOuCNPJ;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank @Column(unique = true, nullable = false)
	private String nome;
	
	@NotBlank @Column(unique = true, nullable = false)
	private String sobrenome;
	
	@CPFOuCNPJ
	private String documento;
	
	@NotBlank @Email @Column(unique = true)
	private String email;
	
	@NotNull
	@ManyToOne
	private Endereco endereco;
	
	@NotBlank
	private String telefone;

	public Cliente(@NotBlank String nome, @NotBlank String sobrenome, String documento, @NotBlank @Email String email,
			@NotNull Endereco endereco, @NotBlank String telefone) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.email = email;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", documento=" + documento
				+ ", email=" + email + ", endereco=" + endereco + ", telefone=" + telefone + "]";
	}
	
}
