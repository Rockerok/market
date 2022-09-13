package ru.gb.market.back.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatTimeServices{
    public HashMap <Class,Long> benchMarkMap = new HashMap<>();
    private String name = StatTimeServices.class.getCanonicalName();
    public String getName(){
        return name;
    }

    public void benchMarkAdd(Object target, Long timeStat) {
        if (benchMarkMap.containsKey(target.getClass())){
            benchMarkMap.put(target.getClass(),benchMarkMap.get(target.getClass())+timeStat);
        }else{
            benchMarkMap.put(target.getClass(),timeStat);
        }
    }

    public String statTime() {
        return String.valueOf(benchMarkMap);
    }
}
