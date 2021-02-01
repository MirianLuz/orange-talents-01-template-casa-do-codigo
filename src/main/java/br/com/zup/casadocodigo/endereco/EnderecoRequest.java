package br.com.zup.casadocodigo.endereco;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.casadocodigo.estados.Estado;
import br.com.zup.casadocodigo.estados.EstadoRepository;
import br.com.zup.casadocodigo.paises.Pais;
import br.com.zup.casadocodigo.paises.PaisRepository;

public class EnderecoRequest {

	@NotBlank
	private String rua;
	
	@NotNull
	private int numero;
	
	@NotBlank
	private String complemento;
	
	@NotBlank	
	private String cidade;
	
	@NotNull
	private Long idPais;
	
	@NotNull
	private Long idEstado;

	public EnderecoRequest(@NotBlank String rua, @NotNull int numero, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Long idPais, @NotNull Long idEstado) {
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.idEstado = idEstado;
	}
	
	public Endereco toModel(PaisRepository paisRepository, EstadoRepository estadoRepository) {
		@NotNull Pais pais = paisRepository.getOne(this.idPais);
        @NotNull Estado estado = estadoRepository.getOne(this.idEstado);
		
		return new Endereco(rua, numero, complemento, cidade, pais, estado);
	}
	

}
