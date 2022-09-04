package ru.gb.market.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import ru.gb.market.services.StatTimeServices;

import java.util.HashMap;

@Aspect
@Component
@Slf4j
public class StatTimeAspect {

    private StatTimeServices stSevices = new StatTimeServices();

    @Pointcut("execution(* ru.gb.market.services.*.*(..))")
    private void getName() {
    }

    //    @Around("@annotation(ru.gb.market.aspect.BenchMark)")
    @Around("getName()")
    public Object timeRun (ProceedingJoinPoint joinPoint)  throws Throwable{
        StopWatch clock = new StopWatch(joinPoint.toString());
        int pointRun =0;
        try {
            clock.start(joinPoint.toShortString());
            pointRun++;
            return joinPoint.proceed();
        } finally {
            clock.stop();
            Long timeStat = Long.valueOf(clock.prettyPrint());
            stSevices.benchMarkAdd(joinPoint.getTarget(),timeStat);
        }
    }

    // Вариант2
//    @Before("@annotation(ru.gb.market.aspect.BenchMark)")
//    public void startTime (JoinPoint joinPoint){ timeStart = System.currentTimeMillis();   }
//
//    @After("@annotation(ru.gb.market.aspect.BenchMark)")
//    public void endTime(JoinPoint joinPoint){    timeEnd = System.currentTimeMillis();   }


}
