package org.intensive.caruction.repository;

import org.intensive.caruction.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    void deleteCategoryByNameContainingIgnoreCase(String category);
}
