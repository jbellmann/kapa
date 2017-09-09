package de.jbellmann.kapapa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/app")
    public String appIndex() {
        return "app/index";
    }

    @GetMapping("/admin")
    public String redirectRoot() {
        return "admin/index";
    }
}
