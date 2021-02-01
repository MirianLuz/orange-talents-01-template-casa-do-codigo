package br.com.zup.casadocodigo.autores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	public AutorRepository autorRepository;
	
	@PostMapping
	public String cadastrar(@RequestBody @Valid AutorDTO dto) {
		Autor autor = dto.toModel();
		autorRepository.save(autor);
		return autor.toString();
		
	}
}
