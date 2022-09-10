package ru.gb.market.model;

import lombok.Data;
import ru.gb.market.repositories.ProductRepository;

import java.util.HashMap;

@Data
public class FileSaveRequest {
    private String name;
    private String text;

}
