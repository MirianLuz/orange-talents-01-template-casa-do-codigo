package br.com.zup.casadocodigo.livros;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class Livro {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank 
	private String titulo;
	
	@NotBlank @Size(max = 500)
	private String resumo;
	
	@NotBlank
	private String sumario;
	
	@NotNull @Min(20)
	private BigDecimal preco;
	
	@NotNull @Min(100)
	private int paginas;
	
	@NotBlank
	private int isbn;
	
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;
	
	@NotNull
	private Long idCategoria;
	
	@NotNull
	@OneToMany
	private Long idAutor;
	

}
