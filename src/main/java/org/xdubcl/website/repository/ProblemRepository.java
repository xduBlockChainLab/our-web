package org.xdubcl.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xdubcl.website.model.Problem;

import java.util.List;

@Repository
public interface ProblemRepository extends JpaRepository<Problem,Long> {
    List<Problem> findAll();
}
