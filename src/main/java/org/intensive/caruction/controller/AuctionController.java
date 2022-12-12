package org.intensive.caruction.controller;

import org.intensive.caruction.dto.AuctionDTO;
import org.intensive.caruction.model.Auction;
import org.intensive.caruction.security.UserDetailsImpl;
import org.intensive.caruction.service.AuctionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/auction")
@PreAuthorize("hasRole('USER')")
public class AuctionController {

    AuctionServiceImpl auctionService;

    @Autowired
    public AuctionController(AuctionServiceImpl auctionService) {
        this.auctionService = auctionService;
    }

    @PostMapping("/new")
    public void createAuction(@Valid @RequestBody AuctionDTO auctionDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        auctionService.save(Auction.builder()
                .startDate(auctionDTO.getStartDate())
                .endDate(auctionDTO.getEndDate())
                .user(userDetails.getUser())
                .description(auctionDTO.getDescription())
                .build());
    }

    @GetMapping("/get/{id}")
    public Auction getAuction(@PathVariable long id) {
        return auctionService.findAuctionById(id);
    }

    @GetMapping
    public List<Auction> getAllAuction() {
        return auctionService.getAllAuction();
    }

    @GetMapping("/get_active")
    public List<Auction> getActiveAuction() {
        return auctionService.getActiveAuction();
    }

    @PostMapping("/auction/start/{id}")
    public void startAuction(@PathVariable long id) {
        Auction auction = auctionService.findAuctionById(id);
        auction.setStatus(true);
        auctionService.save(auction);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAuction(@PathVariable long id) {
        auctionService.deleteAuctionById(id);
    }
}
