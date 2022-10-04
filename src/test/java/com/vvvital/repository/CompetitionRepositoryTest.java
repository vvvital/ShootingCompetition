package com.vvvital.repository;

import com.vvvital.repository.competition.CompetitionRepository;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration({"classpath:springConfig.xml"})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/initDB.sql", config = @SqlConfig(encoding = "UTF-8"))

public class CompetitionRepositoryTest {

    Logger logger= LoggerFactory.getLogger(CompetitionRepositoryTest.class);

    @Autowired
    CompetitionRepository comptRepository;


}
