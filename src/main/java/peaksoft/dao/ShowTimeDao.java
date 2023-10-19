package peaksoft.dao;

import peaksoft.models.ShowTime;

public interface ShowTimeDao {
    ShowTime saveShow(ShowTime showTime);

    ShowTime find(Long id);

    void assign(ShowTime showTime);
}
