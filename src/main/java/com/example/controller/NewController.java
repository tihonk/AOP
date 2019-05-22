package com.example.controller;

import com.example.service.CreatingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class NewController
{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    @Resource
    private CreatingService createService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getExample(Model model)
    {

        String example = createService.createString();
        model.addAttribute("result", example);
        System.out.println(ANSI_PURPLE + "This text is red!" + ANSI_RESET);
        return "hello";
    }
}
