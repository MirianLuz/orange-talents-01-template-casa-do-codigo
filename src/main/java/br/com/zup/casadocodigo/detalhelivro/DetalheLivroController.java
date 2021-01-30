package br.com.zup.casadocodigo.detalhelivro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.livros.Livro;
import br.com.zup.casadocodigo.livros.LivroRepository;

@RestController
public class DetalheLivroController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@GetMapping(value = "/produtos/{id}")
	public ResponseEntity<?> detalhar(@PathVariable Long id) {
		Livro livro = livroRepository.getOne(id);
		if (livro == null) {
			return ResponseEntity.notFound().build();
		}
		
		DetalheLivroResponse detalheLivroResponse = new DetalheLivroResponse(livro);
		return ResponseEntity.ok(detalheLivroResponse);
		
	}

}
