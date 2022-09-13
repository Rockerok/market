package ru.gb.market.back.controllers;

import lombok.RequiredArgsConstructor;
import ru.gb.market.back.services.StatTimeServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
