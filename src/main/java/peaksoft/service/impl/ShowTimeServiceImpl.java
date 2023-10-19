package peaksoft.service.impl;

import peaksoft.dao.MovieDao;
import peaksoft.dao.ShowTimeDao;
import peaksoft.dao.TheatreDao;
import peaksoft.dao.impl.MovieDaoImpl;
import peaksoft.dao.impl.ShowTimeImpldao;
import peaksoft.dao.impl.TheatreDaoImpl;
import peaksoft.models.Movie;
import peaksoft.models.ShowTime;
import peaksoft.models.Theatre;
import peaksoft.service.ShowTimeServices;

/**
 * author: Ulansky
 */
public class ShowTimeServiceImpl implements ShowTimeServices {
    ShowTimeDao showTimeDao = new ShowTimeImpldao();
    MovieDao movieDao = new MovieDaoImpl();
    TheatreDao theatreDao = new TheatreDaoImpl();
    @Override
    public ShowTime saveShow(ShowTime showTime) {
         return showTimeDao.saveShow(showTime);

    }

    @Override
    public ShowTime findById(Long id) {
        return showTimeDao.find(id);
    }

    @Override
    public String assign(Long showTime_id, Long movie_id, Long theatre_id) {
        ShowTime showTime = findById(showTime_id);
        Movie movie = movieDao.findById(movie_id);
        Theatre theatre = theatreDao.findById(theatre_id);
        showTime.setMovie_id(movie.getId());
        showTime.setTheatre_id(theatre.getId());
        showTimeDao.assign(showTime);
        return "success";
    }
}
