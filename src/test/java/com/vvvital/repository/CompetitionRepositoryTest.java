package com.vvvital.repository;

import com.vvvital.model.Competition;
import com.vvvital.repository.competition.CompetitionRepository;
import com.vvvital.repository.competition.CompetitionRepositoryImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@ContextConfiguration({"classpath:springConfig.xml"})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/initDB.sql", config = @SqlConfig(encoding = "UTF-8"))

public class CompetitionRepositoryTest {

    Logger logger = LoggerFactory.getLogger(CompetitionRepositoryTest.class);
    @Autowired
    CompetitionRepositoryImpl comptRepository;

    @Before
    public void init() {
        Competition newCompt1 = new Competition("test1", new Date(2022, 2, 5),
                "The stand shooting competition");
        Competition newCompt2 = new Competition("test2", new Date(2022, 5, 10),
                "The shooting by moving target competition");
        Competition newCompt3 = new Competition("test3", new Date(2022, 10, 20),
                "The shooting by fixed target competition");
        comptRepository.update(newCompt1);
        comptRepository.update(newCompt2);
        comptRepository.update(newCompt3);
    }

    @Test
    public void update() {
        logger.info("test method update");
    }

    @Test
    public void delete() {
        logger.info("test method delete");
        boolean isDelete = comptRepository.delete(1001);
        logger.info(String.valueOf(isDelete));
    }

    @Test
    public void getAll() {
        logger.info("method getAll");
        List<Competition> competitions = comptRepository.getAll();
        System.out.println(Arrays.toString(competitions.toArray()));
    }
}
