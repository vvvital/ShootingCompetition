package com.vvvital.repository.competition;

import com.vvvital.model.Competition;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CompetitionRepository {
    boolean update(Competition competition);

    boolean delete(Integer id);

    List<Competition>getAll();

    Competition getByDate(Date date);

}
