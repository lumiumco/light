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

    @GetMapping("/light/public")
    public Map<String, String> publicLight(HttpServletRequest request) {
        String client = request.getHeader("x-client");
        String company = request.getHeader("x-company");
        log.info("Received public light request: client={}, company={}", client, company);

        return Map.of(
                "type", "public",
                "result", "Light result (public)",
                "client", client != null ? client : "n/a",
                "company", company != null ? company : "n/a"
        );
    }

    @GetMapping("/light/private")
    public Map<String, String> privateLight(HttpServletRequest request) {
        String client = request.getHeader("x-client");
        String company = request.getHeader("x-company");
        log.info("Received private light request: client={}, company={}", client, company);

        return Map.of(
                "type", "private",
                "result", "Light result (private)",
                "client", client != null ? client : "n/a",
                "company", company != null ? company : "n/a"
        );
    }
}
