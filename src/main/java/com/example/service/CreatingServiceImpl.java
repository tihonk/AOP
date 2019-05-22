package com.example.service;

import com.example.dao.HelloDao;
import org.springframework.stereotype.Component;

@Component
public class CreatingServiceImpl implements CreatingService
{
    public String createString()
    {
        HelloDao hello = new HelloDao();
        hello.setExample("Hello world!");
        return hello.getExample();
    }
}
