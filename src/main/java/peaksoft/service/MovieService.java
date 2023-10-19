package peaksoft.service;

import peaksoft.models.Movie;

import java.util.List;

/**
 * author: Ulansky
 */
public interface MovieService {
    String createMovie(String movies, List<String> strings);

    String saveMovie(Movie movie);

    Movie findById(Long id);
}
