package org.intensive.caruction.repository;

import org.intensive.caruction.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    void deleteCategoryByNameContainingIgnoreCase(String category);
}
