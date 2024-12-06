package pe.edu.cibertec.cl2_jpa_velasquez_hans.dto;

import java.util.Date;

public record FilmDetalleDto(Integer filmId,
                             String title,
                             String description,
                             String language,
                             Integer releaseYear,
                             Integer rentalDuration,
                             Double rentalRate,
                             Integer length,
                             Double replacementCost,
                             String rating,
                             String specialFeatures,
                             Date lastUpdate) {
}
