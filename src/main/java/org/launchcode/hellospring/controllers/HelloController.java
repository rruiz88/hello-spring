package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    // request /hello?name=LaunchCode
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String helloParam(@RequestParam String name, Model model) {
        String localGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", localGreeting);
        return "hello";
    }

    ///hello/LaunchCode
    @GetMapping("hello{name}")
    public String helloPath(@PathVariable String name, Model model) {
        String localGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", localGreeting);
        return "hello";
    }

    ///hello/form
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("Java");
        names.add("JV");
        names.add("LaunchCode");
        model.addAttribute("names", names);
        return "hello-list";
    }

//    public static String createMessage(String name, String language) {
//        String greeting = "";
//        if (language.equals("french")) {
//            greeting = "Bonjour";
//        } else if (language.equals("english")) {
//            greeting = "Hello";
//        } else if (language.equals("spanish")) {
//            greeting = "Hola";
//        } else if (language.equals("german")) {
//            greeting = "Hallo";
//        } else if (language.equals("japanese")) {
//            greeting = "Kon'nichiwa";
//        }
//        return greeting + " " + name;
//    }
}