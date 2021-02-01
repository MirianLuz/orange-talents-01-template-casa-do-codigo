package br.com.zup.casadocodigo.cliente;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.endereco.EnderecoRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@PostMapping
	public String cadastrar(@RequestBody @Valid ClienteRequest request) {
		Cliente cliente = request.toModel(enderecoRepository);
		clienteRepository.save(cliente);
		return cliente.toString();
	}
}
