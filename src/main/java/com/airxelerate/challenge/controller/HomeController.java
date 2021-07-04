package com.airxelerate.challenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;

/**
 * This controller is used by Swagger UI
 */
@Controller
@ApiIgnore
public class HomeController
{
    @RequestMapping("/")
    public String home()
    {
        // This serves the Swagger UI page upon call to "/"
        return "redirect:swagger-ui.html";
    }

}
