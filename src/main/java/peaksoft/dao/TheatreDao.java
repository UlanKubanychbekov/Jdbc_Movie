package peaksoft.dao;

import peaksoft.models.Theatre;

public interface TheatreDao {
    Theatre findById(Long theatreId);
}
