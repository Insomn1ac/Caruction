package org.intensive.caruction.controller;

import org.intensive.caruction.model.Auction;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auction")
public class AuctionController {

    @PostMapping("/new")
    public String createAuction() {
        // TODO add logic for creation

        return "auction was created";
    }

    @GetMapping("/get/{id}")
    public Auction getAuction(@RequestParam long id) {

        // TODO add logic get by id

        return null;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAuction(@RequestParam long id) {
        // TODO add logic for deletion
    }


}
