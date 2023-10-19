package peaksoft.service.impl;

import peaksoft.dao.MovieDao;
import peaksoft.dao.impl.MovieDaoImpl;
import peaksoft.models.Movie;
import peaksoft.service.MovieService;

import java.util.List;

/**
 * author: Ulansky
 */
public class MovieServiceImpl implements MovieService {
    MovieDao movieDao = new MovieDaoImpl();
    @Override
    public String createMovie(String table, List<String> strings) {
        movieDao.createTable(table,strings);
        return "succesfully create table: "+table;
    }

    @Override
    public String saveMovie(Movie movie) {
        movieDao.saveMovies(movie);
        return "successfully saved";
    }

    @Override
    public Movie findById(Long id) {
        return movieDao.findById(id);
    }


}
