package pe.edu.cibertec.cl2_jpa_velasquez_hans.service;

import pe.edu.cibertec.cl2_jpa_velasquez_hans.dto.FilmDetalleDto;
import pe.edu.cibertec.cl2_jpa_velasquez_hans.dto.FilmDto;

import java.util.List;

public interface FilmService {
    List<FilmDto> findAllFilms();

    FilmDetalleDto findDetailById(Integer id);

    Boolean updateFilm(FilmDetalleDto filmDetailDto);

    Boolean createFilm(FilmDto filmDto);

    Boolean deleteFilm(Integer Id);
}
