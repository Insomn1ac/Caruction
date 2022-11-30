package org.intensive.caruction.repository;

import org.intensive.caruction.model.Lot;
import org.intensive.caruction.model.LotRequest;
import org.intensive.caruction.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LotRequestRepository extends CrudRepository<LotRequest, Long> {

     Optional<LotRequest> findAllByLot(Lot lot);

     @Query(value = "select lr.user.id from LotRequest lr where lr.lot.id = ?1")
     Long findUserIdInLotRequest(Long id);

     Optional<LotRequest> findByUserAndLot(User user, Lot lot);
}
