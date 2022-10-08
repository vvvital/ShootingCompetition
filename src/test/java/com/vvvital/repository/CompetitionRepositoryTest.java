package com.vvvital.repository;

import com.vvvital.model.Competition;
import com.vvvital.repository.competition.CompetitionRepositoryImpl;
import org.junit.Assert;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration({"classpath:springConfig.xml"})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/initDB.sql", config = @SqlConfig(encoding = "UTF-8"))

public class CompetitionRepositoryTest {

    Logger logger = LoggerFactory.getLogger(CompetitionRepositoryTest.class);
    @Autowired
    CompetitionRepositoryImpl comptRepository;

    List<Competition> actualList = new ArrayList<>();

    @Before
    public void init() {
        Competition newCompt1 = new Competition("test1", LocalDateTime.of(2022, 2, 5, 12, 0),
                "The stand shooting competition");
        Competition newCompt2 = new Competition("test2", LocalDateTime.of(2022, 5, 10, 12, 0),
                "The shooting by moving target competition");
        Competition newCompt3 = new Competition("test3", LocalDateTime.of(2022, 10, 20, 12, 0),
                "The shooting by fixed target competition");
        comptRepository.update(newCompt1);
        comptRepository.update(newCompt2);
        comptRepository.update(newCompt3);
        newCompt1.setId(1000);
        newCompt2.setId(1001);
        newCompt3.setId(1002);
        actualList.add(newCompt1);
        actualList.add(newCompt2);
        actualList.add(newCompt3);
    }

    @Test
    public void update() {
        logger.info("test method update");
        Competition newCompt4 = new Competition("test4", LocalDateTime.of(2022, 11, 11, 12, 0),
                "The shooting by fixed target competition");
        boolean isCreate = comptRepository.update(newCompt4);
        newCompt4.setId(1003);
        assertThat(isCreate).isTrue();
        assertThat(newCompt4).isIn(comptRepository.getAll());
        newCompt4.setName("rename#4");
        newCompt4.setDate(LocalDateTime.of(2022, 10, 10, 10, 10));
        newCompt4.setDescription("new description#4");
        boolean isUpdate = comptRepository.update(newCompt4);
        assertThat(isUpdate).isTrue();
        assertThat(newCompt4).isIn(comptRepository.getAll());
    }

    @Test
    public void delete() {
        logger.info("test method delete");
        boolean isDelete = comptRepository.delete(1000);
        assertThat(isDelete).isTrue();
        assertThat(comptRepository.getById(1000)).isNull();
        assertThat(actualList.get(0)).isNotIn(comptRepository.getAll());
    }

    @Test
    public void getAll() {
        logger.info("method getAll");
        List<Competition> expectedList = comptRepository.getAll();
        Assert.assertEquals(expectedList, actualList);
        System.out.println(Arrays.toString(expectedList.toArray()));
    }

    @Test
    public void getById() {
        Competition expected = comptRepository.getById(1000);
        assertThat(expected).isNotNull();
        assertThat(expected).isIn(actualList.get(0));
    }

    @Test
    public void getDate(){
        Competition expected=comptRepository.getByDate(LocalDateTime.of(2022, 5, 10, 12, 0));
        assertThat(expected).isEqualTo(actualList.get(1));
    }
}
