package ba.fit.java.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;

@Controller
public class HomeController {
    public File _jsonDbFile;

    @GetMapping("/")
    public ModelAndView index()
    {
        return new ModelAndView("home/index");
    }

}
