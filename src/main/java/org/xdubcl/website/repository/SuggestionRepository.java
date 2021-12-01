package org.xdubcl.website.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import org.xdubcl.website.model.Suggestion;

@Repository
public interface SuggestionRepository extends CrudRepository<Suggestion,Long> {
    Iterable<Suggestion> findAll();
}