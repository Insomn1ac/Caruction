package org.intensive.caruction.repository;

import org.intensive.caruction.model.AdminRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRequestRepository extends JpaRepository<AdminRequest, Integer> {

    void deleteAdminRequestByUserId(int id);
}
