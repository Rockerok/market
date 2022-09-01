package ru.gb.market.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StatTimeController {
    private Long

    @Before("@annotation(ru.gb.market.aspect.BenchMark)")
    public void startTime (JoinPoint joinPoint){

    }

    @After("@annotation(ru.gb.market.aspect.BenchMark)")
    public void endTime(JoinPoint joinPoint){

    }
}
