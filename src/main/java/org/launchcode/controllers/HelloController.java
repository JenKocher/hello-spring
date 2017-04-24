package org.launchcode.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Jen on 3/22/2017.
 */
@Controller
//@RequestMapping(value = "hello")
public class HelloController {
    @RequestMapping(value = "")
    @ResponseBody
    public String index(HttpServletRequest request) {
        String name = request.getParameter("name");

        //return "Hello World";

        if (name == null) {
            name = "World";
        }
        return "Hello " + name;

    }

    @RequestMapping(value = "hello", method=RequestMethod.GET)
    @ResponseBody
    public String helloForm() {

        /*String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<input type='submit' value='Greet Me!' />" +
                "</form>";
        */

        //This is the in-class Studio
        String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<select name='language'>" +
                    "<option value='spanish'>Spanish</option>" +
                    "<option value='english' seleeted>English</option>" +
                    "<option value='french'>French</option>" +
                    "<option value='german'>German</option>" +
                    "<option value='italian'>Italian</option>" +
                "</select>" +
                "<input type='submit' value='Greet Me!' />" +
                "</form>";

        return html;
    }

    @RequestMapping(value = "hello", method=RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request) {
        String name = request.getParameter("name");
        //add code for Studio
        String language = request.getParameter("language");
        String greeting;

        if (name == null) {
            name = "World";
        }

        //English, Spanish, French, German, Italian

        if (language.equals("english")) {
            greeting = "Hello";
        } else if (language.equals("spanish")) {
            greeting = "Hola";
        } else if (language.equals("french")) {
            greeting = "Bon jour";
        } else if (language.equals("german")) {
            greeting = "Guten tag";
        } else greeting = "Ciao";


        return greeting + ", " + name;
    }

    @RequestMapping(value="hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "goodbye")
    //@ResponseBody
    //public String goodbye() {
    //    return "Goodbye";
    public String goodbye() {
        return "redirect:/";
    }
}
