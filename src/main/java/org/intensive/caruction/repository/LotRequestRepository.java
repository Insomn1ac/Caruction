package org.intensive.caruction.repository;

import org.intensive.caruction.model.LotRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotRequestRepository extends JpaRepository<LotRequest, Long> {

}
