package br.com.zup.casadocodigo.validation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casadocodigo.categorias.Categoria;
import br.com.zup.casadocodigo.categorias.CategoriaDTO;
import br.com.zup.casadocodigo.categorias.CategoriaRepository;

@Component
public class CategoriaDuplicadaValidator implements Validator{
	
	@Autowired
	public CategoriaRepository categoriaRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		CategoriaDTO dto = (CategoriaDTO) target;
		
		Optional<Categoria> possivelCategoria = categoriaRepository.findByNome(dto.getNome());
		
		if (possivelCategoria.isPresent()) {
			errors.rejectValue("nome", null, "Já existe uma categoria cadastrada com esse nome: " + dto.getNome());
		}
		
	}

}
