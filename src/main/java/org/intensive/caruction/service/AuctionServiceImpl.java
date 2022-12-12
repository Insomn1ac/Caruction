package org.intensive.caruction.service;

import org.intensive.caruction.exception.ElementNotFoundException;
import org.intensive.caruction.model.Auction;
import org.intensive.caruction.repository.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AuctionServiceImpl {

    private final AuctionRepository auctionRepository;

    @Autowired
    public AuctionServiceImpl(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    public void save(Auction auction) {
        auctionRepository.save(auction);
    }

    public Auction findAuctionById(Long id) {
        return auctionRepository.findById(id)
                .orElseThrow(() ->
                        new ElementNotFoundException(
                                "Auction not found for id = " + id));
    }

    public List<Auction> getActiveAuction() {
        return auctionRepository.findAllByStatusIsTrue();
    }

    public List<Auction> getAllAuction() {
        return auctionRepository.findAll();
    }

    public ResponseEntity<?> deleteAuctionById(Long id) {
        if (auctionRepository.findById(id).isPresent()) {
            auctionRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
