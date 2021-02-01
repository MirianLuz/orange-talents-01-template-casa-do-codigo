package br.com.zup.casadocodigo.endereco;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.estados.EstadoRepository;
import br.com.zup.casadocodigo.paises.PaisRepository;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	private PaisRepository paisRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@PostMapping
	public String cadastrar(@RequestBody @Valid EnderecoRequest request) {
		Endereco endereco = request.toModel(paisRepository, estadoRepository);
		enderecoRepository.save(endereco);
		return endereco.toString();
	}

}
