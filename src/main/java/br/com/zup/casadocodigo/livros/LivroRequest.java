package br.com.zup.casadocodigo.livros;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zup.casadocodigo.autores.Autor;
import br.com.zup.casadocodigo.autores.AutorRepository;
import br.com.zup.casadocodigo.categorias.Categoria;
import br.com.zup.casadocodigo.categorias.CategoriaRepository;
import br.com.zup.casadocodigo.validation.UniqueValue;

public class LivroRequest {
	
	@NotBlank @Column(unique=true, nullable = false)
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;
	
	@NotBlank @Size(max = 500)
	private String resumo;
	
	@NotBlank
	private String sumario;
	
	@NotNull @Min(20)
	private BigDecimal preco;
	
	@NotNull @Min(100)
	private int paginas;
	
	@NotBlank @Column(unique=true)
	private String isbn;
	
	@NotNull
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;
	
	@NotNull 
	private Long idCategoria;
	
	@NotNull
	private Long idAutor;
	
	public LivroRequest(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) int paginas, @NotBlank String isbn,
			@NotNull Long idCategoria, @NotNull Long idAutor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}
	
	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Livro toModel(CategoriaRepository categoriaRepository, AutorRepository autorRepository) {
		@NotNull Categoria categoria = categoriaRepository.getOne(this.idCategoria);
        @NotNull Autor autor = autorRepository.getOne(this.idAutor);
        
        return new Livro(this.titulo, this.resumo, this.sumario, this.preco,
                this.paginas, this.isbn, this.dataPublicacao, categoria, autor);
	}

}
