package nl.gamereview.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameController {

    @RequestMapping("/gamereview")
    public String home() {
        return "reviewlist";
    }
}
