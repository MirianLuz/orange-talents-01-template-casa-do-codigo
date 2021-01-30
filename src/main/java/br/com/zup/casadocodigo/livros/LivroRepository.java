package br.com.zup.casadocodigo.livros;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

	@Query("SELECT new br.com.zup.casadocodigo.livros.ListaLivrosResponse(l.id, l.titulo) FROM Livro l")
	List<ListaLivrosResponse> findAllLivros();

}
