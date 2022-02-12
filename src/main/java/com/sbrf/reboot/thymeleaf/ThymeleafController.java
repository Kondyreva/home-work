package com.sbrf.reboot.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class ThymeleafController {
   @GetMapping("/user")
    public String getMessage(@RequestParam("name") String userName, Model model) {
       model.addAttribute("name", userName);
       return "welcome";
    }
}
