package peaksoft.dao.impl;

import peaksoft.config.JdbcConfig;
import peaksoft.dao.TheatreDao;
import peaksoft.models.Theatre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * author: Ulansky
 */
public class TheatreDaoImpl implements TheatreDao {
    private final Connection connection = JdbcConfig.getConnection();
    @Override
    public Theatre findById(Long theatreId) {
        Theatre theatre = new Theatre();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("""
    select * from theatre where id =?
    """);
            preparedStatement.setLong(1,theatreId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()){
                throw new RuntimeException("not fpund");
            }
            else{
                theatre.setId(resultSet.getLong("id"));
                theatre.setName(resultSet.getString("name"));
                theatre.setLocation(resultSet.getString("location"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return theatre;
    }
}
