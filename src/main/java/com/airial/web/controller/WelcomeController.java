package com.airial.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by scambour on 18/04/14.
 */
@Controller
@RequestMapping("/")
public class WelcomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String welcome() {
        return "index";
    }
}
