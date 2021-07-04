package com.airxelerate.challenge.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;

/**
 * This controller is used by Swagger UI
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@ApiIgnore
public class HomeController
{
    @RequestMapping("/home")
    @PreAuthorize("permitAll()")
    public String home()
    {
        // This serves the Swagger UI page upon call to "/"
        return "redirect:swagger-ui.html";
    }

}
