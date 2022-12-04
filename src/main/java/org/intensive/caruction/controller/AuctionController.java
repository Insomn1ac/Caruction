package org.intensive.caruction.controller;

import org.intensive.caruction.dto.ReturnId;
import org.intensive.caruction.model.Auction;
import org.intensive.caruction.service.AuctionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auction")
public class AuctionController {

    AuctionServiceImpl auctionService;

    @Autowired
    public AuctionController(AuctionServiceImpl auctionService) {
        this.auctionService = auctionService;
    }

    @PostMapping("/new")
    public ReturnId createAuction(@RequestBody Auction auction) {
        auctionService.save(auction);
        return new ReturnId(auction.getId());
    }

    @GetMapping("/get/{id}")
    public Auction getAuction(@PathVariable long id) {
        return auctionService.findAuctionById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAuction(@PathVariable long id) {
        auctionService.deleteAuctionById(id);
    }
}
