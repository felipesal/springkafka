package br.com.springkafka.controller.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class PeopleDTO {
    private String name;
    private String cpf;

    private List<String> books;
}
