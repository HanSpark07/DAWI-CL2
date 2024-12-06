package pe.edu.cibertec.cl2_jpa_velasquez_hans.dto;

public record FilmDto(Integer filmId,
                      String title,
                      String language,
                      Integer rentalDuration,
                      Double rentalRate) {
}
