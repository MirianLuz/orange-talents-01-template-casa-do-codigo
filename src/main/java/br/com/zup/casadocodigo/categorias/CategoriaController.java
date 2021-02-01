package br.com.zup.casadocodigo.categorias;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	public CategoriaRepository categoriaRepository;
	
	@PostMapping
	public String cadastrar(@RequestBody @Valid CategoriaDTO dto) {
		Categoria categoria = dto.toModel();
		categoriaRepository.save(categoria);
		return categoria.toString();
	}

}
