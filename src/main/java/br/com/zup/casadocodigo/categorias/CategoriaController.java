package br.com.zup.casadocodigo.categorias;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.validation.CategoriaDuplicadaValidator;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	public CategoriaRepository categoriaRepository;
	
	@Autowired
	public CategoriaDuplicadaValidator categoriaDuplicadaValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(categoriaDuplicadaValidator);
	}
	
	@PostMapping
	public String cadastrar(@RequestBody @Valid CategoriaDTO dto) {
		Categoria categoria = dto.toModel();
		categoriaRepository.save(categoria);
		return categoria.toString();
	}

}
