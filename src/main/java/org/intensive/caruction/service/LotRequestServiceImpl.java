package org.intensive.caruction.service;

import org.intensive.caruction.model.Lot;
import org.intensive.caruction.model.LotRequest;
import org.intensive.caruction.repository.LotRequestRepository;
import org.intensive.caruction.repository.UserRepository;
import org.intensive.caruction.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LotRequestServiceImpl {

    private final LotRequestRepository lotRequestRepository;
    private final UserRepository userRepository;

    @Autowired
    public LotRequestServiceImpl(LotRequestRepository lotRequestRepository, UserRepository userRepository) {
        this.lotRequestRepository = lotRequestRepository;
        this.userRepository = userRepository;
    }

    // todo handle different HTTP statuses if needed
    public ResponseEntity<?> subscribeToLot(UserDetailsImpl user, Lot lot) {

        LotRequest request = new LotRequest();
        request.setUser(user.getUser());
        request.setLot(lot);

        lotRequestRepository.save(request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // todo may be good way to use status instead of deletion
    public ResponseEntity<?> unsubscribeFromLot(UserDetailsImpl user, Lot lot) {

        Optional<LotRequest> request = lotRequestRepository.findByUserAndLot(user.getUser(), lot);

        if (request.isPresent()) {
            if (lotRequestRepository.findUserIdInLotRequest(lot.getId()).equals(user.getUser().getId())) {

                lotRequestRepository.deleteById(request.get().getId());
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
