package com.vvvital.repository.competition;

import com.vvvital.model.Competition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class CompetitionRepositoryImpl implements CompetitionRepository {

    Logger logger = LoggerFactory.getLogger(CompetitionRepositoryImpl.class);
    private final RowMapper<Competition> ROW_MAPPER;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CompetitionRepositoryImpl(CompetitionMapper competitionMapper, DataSource dataSource) {
        this.ROW_MAPPER = competitionMapper;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean update(Competition competition) {
        if (competition.getId() == null) {
            //logger.info("create new competition");
            return jdbcTemplate.update("INSERT INTO competition VALUES (nextval('competition_sequence'),?,?,?,?)"
                    , competition.getName(), competition.getDate(), competition.getDescription(), competition.getMembers()) != 0;
        } else {
            //logger.info("update competition id {}", competition.getId());
            return jdbcTemplate.update("update competition set name=?,date_time=?,description=?,userid=? where compt_id=?"
                    , competition.getName(), competition.getDate(), competition.getDescription(), competition.getMembers(), competition.getId()) != 0;
        }
    }

    @Override
    public boolean delete(Integer id) {
        return jdbcTemplate.update("delete from competition where compt_id=?", id) != 0;
    }

    @Override
    public List<Competition> getAll() {
        return jdbcTemplate.query("select * from competition",ROW_MAPPER);
    }

    @Override
    public Competition getByDate(LocalDateTime date) {
        return DataAccessUtils.singleResult(jdbcTemplate.query("select * from competition where date_time=?",ROW_MAPPER,date));
    }

    public Competition getById(Integer id){
        return DataAccessUtils.singleResult(jdbcTemplate.query("select * from competition where compt_id=?",ROW_MAPPER,id));
    }

}
