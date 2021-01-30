package br.com.zup.casadocodigo.paises;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paises")
public class PaisController {
	
	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping
	public String cadastrar(@RequestBody @Valid PaisRequest request) {
		Pais pais = request.toModel();
		paisRepository.save(pais);
		return pais.toString();
	}

}
