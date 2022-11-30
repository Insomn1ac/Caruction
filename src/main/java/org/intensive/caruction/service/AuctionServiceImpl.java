package org.intensive.caruction.service;

import org.intensive.caruction.model.Auction;
import org.intensive.caruction.repository.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AuctionServiceImpl {

    private final AuctionRepository auctionRepository;

    @Autowired
    public AuctionServiceImpl(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    // TODO handle with custom exeption
    public Auction findAuctionById(Long id) {
        return auctionRepository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException(
                                "Auction not found for id = " + id));
    }

    public ResponseEntity<?> deleteAuctionById(Long id) {

        /* TODO take care about deleting all lots for deleted auction
         * or resrict deletion when at least one lot exists
         */
        if (auctionRepository.findById(id).isPresent()) {
            auctionRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
