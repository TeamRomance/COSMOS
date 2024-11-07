package teamromance.cosmos.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import teamromance.cosmos.dto.EmailRequestDTO;
import teamromance.cosmos.service.email.EmailService;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class ContactUsController {

    private final EmailService emailService;

    @PostMapping("/contactUs")
    public ResponseEntity<Void> contactUs(@RequestBody EmailRequestDTO emailRequest) {
        emailService.sendEmail(
                emailRequest.getUserEmail(),
                emailRequest.getTo(),
                emailRequest.getSubject(),
                emailRequest.getText()
        );
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/docs/contactUs")
    public String getContactUs() {
        return "forward:/docs/contact-us.html";
    }
}
