package br.com.zup.casadocodigo.estados;

import br.com.zup.casadocodigo.paises.PaisResponse;

public class EstadoResponse {

	private Long id;
	private String nome;
	private PaisResponse pais;

	public EstadoResponse(Estado estado) {
		this.id = estado.getId();
		this.nome = estado.getNome();
		this.pais = new PaisResponse(estado.getPais());
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public PaisResponse getPais() {
		return pais;
	}
}
