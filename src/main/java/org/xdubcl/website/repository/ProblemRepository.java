package org.xdubcl.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.xdubcl.website.model.Problem;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ProblemRepository extends CrudRepository<Problem,Long> {
    ArrayList<Problem> findAll();
}
