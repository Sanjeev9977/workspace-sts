package contorller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProfileController {

    @Value("${msgTxt}")
    private String msg;

    @GetMapping("/hi")  // Ensure the correct mapping
    @ResponseBody
    public String loadMsg() {
        return msg;
    }
}
 