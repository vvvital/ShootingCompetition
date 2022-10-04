package com.vvvital.repository.competition;

import com.vvvital.model.Competition;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionRepository {
    void update(Competition competition);

}
