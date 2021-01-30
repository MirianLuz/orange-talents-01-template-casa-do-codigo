package br.com.zup.casadocodigo.detalhelivro;

import java.math.BigDecimal;

import br.com.zup.casadocodigo.autores.DetalheAutorResponse;
import br.com.zup.casadocodigo.livros.Livro;

public class DetalheLivroResponse {

	private String titulo;
	private String resumo;
	private String isbn;
	private int paginas;
	private BigDecimal preco;
	private String sumario;
	private DetalheAutorResponse autor;

	public DetalheLivroResponse(Livro livro) {
		titulo = livro.getTitulo();
		resumo = livro.getResumo();
		isbn = livro.getIsbn();
		paginas = livro.getPaginas();
		preco = livro.getPreco();
		resumo = livro.getResumo();
		sumario = livro.getSumario();
		autor = new DetalheAutorResponse(livro.getAutor());
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getPaginas() {
		return paginas;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getSumario() {
		return sumario;
	}

	public DetalheAutorResponse getAutor() {
		return autor;
	}

}
