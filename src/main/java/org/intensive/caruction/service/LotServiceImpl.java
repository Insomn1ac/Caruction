package org.intensive.caruction.service;

import org.intensive.caruction.model.Auction;
import org.intensive.caruction.model.Lot;
import org.intensive.caruction.repository.LotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class LotServiceImpl {

    private final LotRepository lotRepository;

    @Autowired
    public LotServiceImpl(LotRepository lotRepository) {
        this.lotRepository = lotRepository;
    }

    // TODO handle with custom exeption
    public Lot findLotById(Long id) {
        return lotRepository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException(
                                "Lot not found for id = " + id));
    }

    public ResponseEntity<?> deleteLotById(Long id) {

        if (lotRepository.findById(id).isPresent()) {
            lotRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> updateRecipe(Long id, Lot lot) {

        Optional<Lot> existingLot = lotRepository.findById(id);

        if (existingLot.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        lotRepository.save(lot);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
