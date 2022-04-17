package br.com.springkafka.controller;

import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.ws.rs.core.MediaType;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.springkafka.People;
import br.com.springkafka.controller.dto.PeopleDTO;
import br.com.springkafka.producer.PeopleProducer;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/peoples")
@AllArgsConstructor
public class PeopleController {
    
    private final PeopleProducer peopleProducer;

    @PostMapping(consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<Void> sendMessage(@RequestBody PeopleDTO peopleDto) {
        var id = UUID.randomUUID().toString();

        var message = People.newBuilder()
                    .setId(id)
                    .setName(peopleDto.getName())
                    .setCpf(peopleDto.getCpf())
                    .setBooks(peopleDto.getBooks().stream().map(x -> (CharSequence) x).collect(Collectors.toList())).build();

        peopleProducer.sendMessage(message);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
