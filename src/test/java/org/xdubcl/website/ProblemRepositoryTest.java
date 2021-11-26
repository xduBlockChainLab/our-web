package org.xdubcl.website;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.xdubcl.website.model.Problem;
import org.xdubcl.website.repository.ProblemRepository;

import java.sql.Savepoint;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ProblemRepositoryTest {

    @Autowired
    private ProblemRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void TestCreateQuestions()
    {

        Problem problem =new Problem();
        problem.setQuestion("什么是java接口?");


        Problem saveproblem = repo.save(problem);
        Problem existuser = entityManager.find(Problem.class, saveproblem.getId());


    }


}
