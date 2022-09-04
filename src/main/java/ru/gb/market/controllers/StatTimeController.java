package ru.gb.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.market.services.StatTimeServices;

import java.util.HashMap;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class StatTimeController {
    private final StatTimeServices statTimeServices = new StatTimeServices();

    @GetMapping("/statistic")
    public void statTime(){
        statTimeServices.statTime();
    }
}
