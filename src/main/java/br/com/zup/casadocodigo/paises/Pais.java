package br.com.zup.casadocodigo.paises;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import br.com.zup.casadocodigo.estados.Estado;

@Entity
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank @Column(unique = true)
	private String nome;
	
	@OneToMany(mappedBy = "pais")
	private List<Estado> estados;
	
	@Deprecated
	public Pais() {
	}

	public Pais(@NotBlank String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", nome=" + nome + "]";
	}
	
}
