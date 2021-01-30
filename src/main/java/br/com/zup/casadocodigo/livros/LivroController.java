package br.com.zup.casadocodigo.livros;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.autores.AutorRepository;
import br.com.zup.casadocodigo.categorias.CategoriaRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	
	@PostMapping
	public String cadastrar(@RequestBody @Valid LivroRequest request) {
		Livro livro = request.toModel(categoriaRepository, autorRepository);
		livroRepository.save(livro);
		return livro.toString();
	}
	
	
	@GetMapping
	public List<ListaLivrosResponse> listar() {
		List<ListaLivrosResponse> listaDeLivros = livroRepository.findAllLivros();
		return listaDeLivros;
	}
	
}
