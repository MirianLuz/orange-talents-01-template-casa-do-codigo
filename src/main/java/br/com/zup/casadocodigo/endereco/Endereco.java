package br.com.zup.casadocodigo.endereco;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.casadocodigo.estados.Estado;
import br.com.zup.casadocodigo.paises.Pais;

@Entity
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String rua;
	
	@NotNull
	private int numero;
	
	@NotBlank
	private String complemento;
	
	@NotBlank	
	private String cidade;
	
	@NotNull
	@OneToOne
	private Pais pais;
	
	@NotNull
	@OneToOne
	private Estado estado;
	
	@Deprecated
	public Endereco() {
	}

	public Endereco(@NotBlank String rua, @NotNull int numero, @NotBlank String complemento, @NotBlank String cidade,
			@NotNull Pais pais, @NotNull Estado estado) {
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", rua=" + rua + ", numero=" + numero + ", complemento=" + complemento
				+ ", cidade=" + cidade + ", pais=" + pais + ", estado=" + estado + "]";
	}
	
}
