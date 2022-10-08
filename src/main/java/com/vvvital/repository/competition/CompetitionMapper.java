package com.vvvital.repository.competition;

import com.vvvital.model.Competition;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CompetitionMapper implements RowMapper<Competition> {
    @Override
    public Competition mapRow(ResultSet rs, int rowNum) throws SQLException {
        Competition competition = new Competition();
        competition.setId(rs.getInt("compt_id"));
        competition.setName(rs.getString("name"));
        competition.setDate(rs.getTimestamp("date_time").toLocalDateTime());
        competition.setDescription(rs.getString("description"));
        return competition;
    }
}
