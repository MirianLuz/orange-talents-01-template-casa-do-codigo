package br.com.zup.casadocodigo.estados;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.casadocodigo.paises.Pais;

@Entity
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank @Column(unique = true)
	private String nome;
	
	@NotNull
	@ManyToOne
	private Pais pais;

	public Estado(@NotBlank String nome, @NotNull Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Estado [id=" + id + ", nome=" + nome + ", pais=" + pais + "]";
	}
	
}
