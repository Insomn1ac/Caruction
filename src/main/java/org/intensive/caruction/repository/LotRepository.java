package org.intensive.caruction.repository;

import org.intensive.caruction.model.Lot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotRepository extends CrudRepository<Lot, Long> { }
