package teamromance.cosmos.service.email;

public interface EmailService {
    void sendEmail(String userEmail, String to, String subject, String text);
}
