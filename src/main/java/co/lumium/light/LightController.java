package co.lumium.light;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LightController {

    private static final Logger log = LoggerFactory.getLogger(LightController.class);

    @GetMapping("/light")
    public Map<String, String> light(HttpServletRequest request) {
        String client = request.getHeader("x-client");
        String company = request.getHeader("x-company");
        log.info("Received request to light with headers: client={}, company={}", client, company);
        return Map.of(
                "result", "Light result",
                "client", client != null ? client : "n/a",
                "company", company != null ? company : "n/a"
        );
    }
}
