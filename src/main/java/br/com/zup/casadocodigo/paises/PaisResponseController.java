package br.com.zup.casadocodigo.paises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaisResponseController {

	@Autowired
	private PaisRepository paisRepository;
	
	@GetMapping(value = "/pais/{id}")
	public ResponseEntity<?> detalhar(@PathVariable Long id) {
		Pais pais = paisRepository.getOne(id);
		if (pais == null) {
			return ResponseEntity.notFound().build();
		}
		
		PaisResponse paisResponse = new PaisResponse(pais);
		return ResponseEntity.ok(paisResponse);
		
	}
}
