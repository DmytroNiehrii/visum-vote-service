package com.visum.vote.controller;

import com.visum.vote.dto.InVoteDto;
import com.visum.vote.dto.OutVoteDto;
import com.visum.vote.service.VoteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vote")
public class VoteController {

    @Autowired
    private ConversionService conversionService;
    @Autowired
    private VoteService voteService;

    @PostMapping
    public ResponseEntity<OutVoteDto> save(@RequestBody InVoteDto dto) {
        return new ResponseEntity(conversionService.convert(voteService.save(dto), OutVoteDto.class), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<OutVoteDto>> findAll(Pageable pageable) {
        return new ResponseEntity(voteService.findAll(pageable)
            .map(source -> conversionService.convert(source, OutVoteDto.class)), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OutVoteDto> findById(@PathVariable Long id) {
        return new ResponseEntity(conversionService.convert(voteService.findById(id), OutVoteDto.class), HttpStatus.OK);
    }
}
