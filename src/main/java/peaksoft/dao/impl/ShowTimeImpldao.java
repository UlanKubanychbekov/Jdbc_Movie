package peaksoft.dao.impl;

import peaksoft.config.JdbcConfig;
import peaksoft.dao.ShowTimeDao;
import peaksoft.models.ShowTime;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * author: Ulansky
 */
public class ShowTimeImpldao implements ShowTimeDao {
    private  final Connection connection = JdbcConfig.getConnection();
    @Override
    public ShowTime saveShow(ShowTime showTime) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("""
    insert into show_time(movie_id,theatre_id,start_time,end_time)
    values (?,?,?,?)
    """);
            preparedStatement.setLong(1,showTime.getMovie_id());
            preparedStatement.setLong(2,showTime.getTheatre_id());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(showTime.getStart_time()));
            preparedStatement.setTimestamp(4,Timestamp.valueOf(showTime.getStart_time()));
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return getShowTimeFindStartAndEnd(showTime.getStart_time(),showTime.getEnd_time());
    }

    @Override
    public ShowTime find(Long id) {
        ShowTime showTime = new ShowTime();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("""
    select * from show_time where  id = ?
    """);
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()){
                throw  new RuntimeException("not found");
            }else {
                showTime.setId(resultSet.getLong("id"));
                showTime.setMovie_id(resultSet.getLong("movie_id"));
                showTime.setTheatre_id(resultSet.getLong("theatre_id"));
                showTime.setStart_time(resultSet.getTimestamp("start_time").toLocalDateTime());
                showTime.setEnd_time(resultSet.getTimestamp("end_time").toLocalDateTime());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return showTime;
    }

    @Override
    public void assign(ShowTime showTime) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("""
update show_time set
movie_id = ?,
theatre_id = ?
where id = ?
""");
            preparedStatement.setLong(1,showTime.getMovie_id());
            preparedStatement.setLong(2,showTime.getTheatre_id());
            preparedStatement.setLong(3,showTime.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public ShowTime getShowTimeFindStartAndEnd(LocalDateTime start,LocalDateTime end){
        ShowTime showTime = new ShowTime();
        PreparedStatement preparedStatement = null;
        try {
           preparedStatement = connection.prepareStatement("""
    select * from show_time where start_time =? and end_time = ?
    
    """);
            preparedStatement.setTimestamp(1,Timestamp.valueOf(start));
            preparedStatement.setTimestamp(2,Timestamp.valueOf(end));
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                showTime.setId(resultSet.getLong("id"));
            }else{
                throw  new RuntimeException("not found showTime");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
return showTime;
    }
}
