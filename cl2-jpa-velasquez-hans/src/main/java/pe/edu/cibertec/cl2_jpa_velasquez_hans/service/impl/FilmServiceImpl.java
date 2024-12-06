package pe.edu.cibertec.cl2_jpa_velasquez_hans.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.cl2_jpa_velasquez_hans.dto.FilmDetalleDto;
import pe.edu.cibertec.cl2_jpa_velasquez_hans.dto.FilmDto;
import pe.edu.cibertec.cl2_jpa_velasquez_hans.entity.Film;
import pe.edu.cibertec.cl2_jpa_velasquez_hans.repository.IFilmRepository;
import pe.edu.cibertec.cl2_jpa_velasquez_hans.service.FilmService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    IFilmRepository ifilmRepository;

    @Override
    public List<FilmDto> findAllFilms() {
        List<FilmDto> films = new ArrayList<FilmDto>();
        Iterable<Film> iterable = ifilmRepository.findAll();
        iterable.forEach(film -> {
            FilmDto filmDto = new FilmDto(film.getFilmId(),
                    film.getTitle(),
                    film.getLanguage().getName(),
                    film.getRentalDuration(),
                    film.getRentalRate());
            films.add(filmDto);
        });
        return films;
    }

    @Override
    public FilmDetalleDto findDetailById(Integer id) {
        Optional<Film> optional = ifilmRepository.findById(id);
        return optional.map(
                film -> new FilmDetalleDto(film.getFilmId(),
                        film.getTitle(),
                        film.getDescription(),
                        film.getLanguage().getName(),
                        film.getReleaseYear(),
                        film.getRentalDuration(),
                        film.getRentalRate(),
                        film.getLength(),
                        film.getReplacementCost(),
                        film.getRating(),
                        film.getSpecialFeatures(),
                        film.getLastUpdate())
        ).orElse(null);
    }

    @Override
    public Boolean updateFilm(FilmDetalleDto filmDetailDto) {
        Optional<Film> optional = ifilmRepository.findById(filmDetailDto.filmId());
        return optional.map(
                film -> {
                    film.setTitle(filmDetailDto.title());
                    film.setDescription(filmDetailDto.description());
                    film.setReleaseYear(filmDetailDto.releaseYear());
                    film.setRentalDuration(filmDetailDto.rentalDuration());
                    film.setRentalRate(filmDetailDto.rentalRate());
                    film.setLength(filmDetailDto.length());
                    film.setReplacementCost(filmDetailDto.replacementCost());
                    film.setRating(filmDetailDto.rating());
                    film.setSpecialFeatures(filmDetailDto.specialFeatures());
                    film.setLastUpdate(new Date());
                    ifilmRepository.save(film);
                    return true;
                }
        ).orElse(false);
    }

    @Override
    public Boolean createFilm(FilmDto filmDto){
        Film film = new Film();
        film.setTitle(film.getTitle());
        film.setDescription(film.getDescription());
        film.setReleaseYear(film.getReleaseYear());
        film.setRentalDuration(film.getRentalDuration());
        film.setRentalRate(film.getRentalRate());
        film.setLength(film.getLength());
        film.setReplacementCost(film.getReplacementCost());
        film.setRating(film.getRating());
        film.setSpecialFeatures(film.getSpecialFeatures());
        film.setLastUpdate(new Date());
        ifilmRepository.save(film);
        return true;
    }

    @Override
    public Boolean deleteFilm(Integer Id){
        Optional<Film> optional = ifilmRepository.findById(Id);
        return optional.map(
                film -> {
                    ifilmRepository.delete(film);
                    return true;
                }
        ).orElse(false);
    }
}
