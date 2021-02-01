package br.com.zup.casadocodigo.estados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstadoResponseController {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@GetMapping(value = "/estado/{id}")
	public ResponseEntity<?> detalhar(@PathVariable Long id) {
		Estado estado = estadoRepository.getOne(id);
		if (estado == null) {
			return ResponseEntity.notFound().build();
		}
		
		EstadoResponse estadoResponse = new EstadoResponse(estado);
		return ResponseEntity.ok(estadoResponse);
		
	}

}
