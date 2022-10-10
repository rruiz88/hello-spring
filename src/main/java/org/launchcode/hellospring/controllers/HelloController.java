package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {
    //path/hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

@RequestMapping(value = "hello", method = RequestMethod.POST)
@ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }
        return createMessage(name, language);
    }
    ///hello/goodbye
    @GetMapping("goodbye")

    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // request /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})

    public String helloParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    ///hello/LaunchCode

    @GetMapping("{name}")

    public String helloPath(@PathVariable String name) {
        return "Goodbye, " + name + "!";
    }

    ///hello/form
    @GetMapping("form")

    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +
                "Enter your name: <input type='text' name='name'>\n" +
                "<select name='language'> <option value=''>" + "--Please choose a language--</option>" +
                "<option value='french'>French</option>\n" +
                "<option value='english'>English</option>\n" +
                "<option value='spanish'>Spanish</option>\n" +
                "<option value='japanese'>Japanese</option>\n" +
                "<option value='german'>German</option>\n" +
                "</select>\n" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    public static String createMessage(String name, String language) {
        String greeting = "";
        if (language.equals("french")) {
            greeting = "Bonjour";
        } else if (language.equals("english")) {
            greeting = "Hello";
        } else if (language.equals("spanish")) {
            greeting = "Hola";
        } else if (language.equals("german")) {
            greeting = "Hallo";
        } else if (language.equals("japanese")) {
            greeting = "Kon'nichiwa";
        }
        return greeting + " " + name;
    }
}