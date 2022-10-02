package com.vvvital.Service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {

    private final Map<String,Integer> cookiesMap=new ConcurrentHashMap<>();

    //Return user's id by cookie
    //need to add assert notNull
    public Integer getIdByCookie(String cookie){
        Integer id=cookiesMap.get(cookie);
        return Objects.requireNonNullElse(id, -1);
    }

    public void addCookies(String cookie, Integer id){
        cookiesMap.put(cookie,id);
    }

}
