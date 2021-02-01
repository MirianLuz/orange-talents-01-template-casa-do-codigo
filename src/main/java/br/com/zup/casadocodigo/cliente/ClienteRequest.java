package br.com.zup.casadocodigo.cliente;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.casadocodigo.endereco.Endereco;
import br.com.zup.casadocodigo.endereco.EnderecoRepository;
import br.com.zup.casadocodigo.validation.CPFOuCNPJ;
import br.com.zup.casadocodigo.validation.UniqueValue;

public class ClienteRequest {
	@NotBlank @Column(unique = true, nullable = false)
	private String nome;
	
	@NotBlank @Column(unique = true, nullable = false)
	private String sobrenome;
	
	@CPFOuCNPJ
	private String documento;
	
	@NotBlank @Email @Column(unique = true)
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String email;
	
	@NotNull
	private Long idEndereco;
	
	@NotBlank
	private String telefone;

	public ClienteRequest(@NotBlank String nome, @NotBlank String sobrenome, String documento,
			@NotBlank @Email String email, @NotNull Long idEndereco, @NotBlank String telefone) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.email = email;
		this.idEndereco = idEndereco;
		this.telefone = telefone;
	}
	
	public Cliente toModel(EnderecoRepository enderecoRepository) {
		@NotNull Endereco endereco = enderecoRepository.getOne(this.idEndereco);
		return new Cliente(nome, sobrenome, documento, email, endereco, telefone);
	}
	
	
}
