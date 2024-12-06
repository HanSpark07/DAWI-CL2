package pe.edu.cibertec.cl2_jpa_velasquez_hans.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.cl2_jpa_velasquez_hans.entity.Film;

public interface IFilmRepository extends CrudRepository<Film, Integer> {
}
