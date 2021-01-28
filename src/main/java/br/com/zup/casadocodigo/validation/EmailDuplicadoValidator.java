package br.com.zup.casadocodigo.validation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casadocodigo.autores.Autor;
import br.com.zup.casadocodigo.autores.AutorDTO;
import br.com.zup.casadocodigo.autores.AutorRepository;

@Component
public class EmailDuplicadoValidator implements Validator{
	
	@Autowired
	public AutorRepository autorRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return AutorDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		AutorDTO dto = (AutorDTO) target;
		
		Optional<Autor> possivelAutor = autorRepository.findByEmail(dto.getEmail());
		
		if (possivelAutor.isPresent()) {
			errors.rejectValue("email", null, "Já existe um(a) autor(a) com o email cadastrado " + dto.getEmail());
		}
		
	}

}
