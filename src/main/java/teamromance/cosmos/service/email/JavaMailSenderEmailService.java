package teamromance.cosmos.service.email;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JavaMailSenderEmailService implements EmailService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private final JavaMailSender emailSender; // 설정 잘 되었는데 IDE 오류 같아서 경고 제거

    @Override
    public void sendEmail(String userEmail, String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("cosmos.x.server@gmail.com"); // 서버의 이메일 주소
        message.setTo(to); // 수신자 이메일 주소
        message.setSubject(subject); // 제목
        message.setText("From: " + userEmail + "\n\n" + text); // 내용에 클라이언트 이메일 주소 포함
        emailSender.send(message);
    }
}
