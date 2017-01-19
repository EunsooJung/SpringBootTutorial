package ej.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by eunsoojung on 8/31/16.
 */
@Controller
public class IndexController {

    @RequestMapping({"/", ""})
    public String index() {
        return "index";
    }

    // S12_L72 Login Form for Spring Security
    @RequestMapping("/access_denied")
    public String notAuth() {
        return "access_denied";
    }

    @RequestMapping("login")
    public String loginForm() {
        return "login";
    }

}
