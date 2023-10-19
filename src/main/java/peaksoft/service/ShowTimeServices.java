package peaksoft.service;

import peaksoft.models.ShowTime;

public interface ShowTimeServices {
    ShowTime saveShow(ShowTime showTime);
    ShowTime findById(Long id);

    String assign(Long showTime_id, Long movie_id, Long theatre_id);
}
