package CinemaBookingsFinal.Domain.mapper;

import CinemaBookingsFinal.Domain.dto.Cinema.CinemaDTO;
import CinemaBookingsFinal.Domain.dto.Movie.MovieDTO;
import CinemaBookingsFinal.Domain.entity.Cinema;
import CinemaBookingsFinal.Domain.entity.Movie;

public class MovieMapper {

        public static MovieDTO toDto(Movie movie){
            return MovieDTO.builder()
                    .id(movie.getId())
                    .title(movie.getTitle())
                    .genre(movie.getGenre())
                    .duration(movie.getDuration())
                .build();

        }
        public static Movie toEntity(MovieDTO movieDTO){
            return Movie.builder()
                    .id(movieDTO.getId())
                    .title(movieDTO.getTitle())
                    .genre(movieDTO.getGenre())
                    .duration(movieDTO.getDuration())
                    .build();
        }
}
