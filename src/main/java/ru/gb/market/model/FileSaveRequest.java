package ru.gb.market.model;

import lombok.Data;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;

@Data
public class FileSaveRequest {

    private String nameFile;
    private String text;
}
