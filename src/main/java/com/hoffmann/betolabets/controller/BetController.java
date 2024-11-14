package com.hoffmann.betolabets.controller;

import com.hoffmann.betolabets.domain.request.BetRequest;
import com.hoffmann.betolabets.domain.response.BetResponse;
import com.hoffmann.betolabets.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("bet")
public class BetController {

    @Autowired
    private BetService betService;

    @PostMapping("/insert")
    public ResponseEntity<Void> cadastraAposta(@RequestBody BetRequest request, Long userID) {
        betService.cadastraAposta(request, userID);
        return new ResponseEntity<>(CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<List<BetResponse>> buscaAposta(@RequestParam Long userID){
        return ResponseEntity.ok().body(betService.buscaAposta(userID));
    }

}
