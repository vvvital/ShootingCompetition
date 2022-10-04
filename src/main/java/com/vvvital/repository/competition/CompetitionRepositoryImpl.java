package com.vvvital.repository.competition;

import com.vvvital.model.Competition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

public class CompetitionRepositoryImpl implements CompetitionRepository {

    @Autowired
    private DataSource dataSource;

    private final JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);


    @Override
    public void update(Competition competition) {
        jdbcTemplate.update("INSERT INTO competition VALUES (nextval('competition_sequence'),?,?,?,?)"
               ,competition.getName(),competition.getDate(),competition.getDescription(),competition.getMembers());
    }
}
