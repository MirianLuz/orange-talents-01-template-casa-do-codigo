package br.com.zup.casadocodigo.estados;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.paises.PaisRepository;

@RestController
@RequestMapping("/estados")
public class EstadoController {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping
	public String cadastrar(@RequestBody @Valid EstadoRequest request) {
		Estado estado = request.toModel(paisRepository);
		estadoRepository.save(estado);
		return estado.toString();
	}
	

}
