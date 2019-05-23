package com.example.service;

import org.springframework.stereotype.Component;

@Component
public class MyLogger
{
    public void init()
    {
        System.out.println("init");
    }

    public void close()
    {
        String s = "close";
        System.out.println(s);
    }

    public void printResult(Object object)
    {
        System.out.println(object);
    }


}
