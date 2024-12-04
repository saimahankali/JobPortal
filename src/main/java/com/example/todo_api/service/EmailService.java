package com.example.todo_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
    
    @Autowired
    private JavaMailSender mailSender;

    public void sendPasswordResetEmail(String to, String token) {
        String link = "http://localhost:3000/reset-password?token=" + token;

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);  // true for HTML

            helper.setTo(to);
            helper.setSubject("Password Reset Request");

            // HTML content with embedded CSS for styling
            String htmlContent = "<html><head>"
                    + "<style>"
                    + "body { font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 0; }"
                    + ".container { max-width: 600px; margin: 0 auto; background-color: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); }"
                    + ".header { background-color: #007bff; color: #fff; padding: 10px; text-align: center; border-radius: 8px 8px 0 0; }"
                    + ".content { margin-top: 20px; padding: 20px; font-size: 16px; color: #333; }"
                    + ".button { display: inline-block; background-color: #007bff; color: white; padding: 12px 20px; text-align: center; text-decoration: none; border-radius: 5px; font-size: 16px; }"
                    + ".footer { margin-top: 30px; text-align: center; font-size: 12px; color: #777; }"
                    + "</style>"
                    + "</head><body>"
                    + "<div class=\"container\">"
                    + "<div class=\"header\">"
                    + "<h2>Password Reset Request</h2>"
                    + "</div>"
                    + "<div class=\"content\">"
                    + "<p>Dear User,</p>"
                    + "<p>We received a request to reset your password. Please click the button below to reset your password:</p>"
                    + "<p><a href=\"" + link + "\" class=\"button\" target=\"_blank\">Reset Password</a></p>"
                    + "<p><em>Note: The link is valid for 2 minutes.</em></p>"
                    + "</div>"
                    + "<div class=\"footer\">"
                    + "<p>If you did not request this password reset, please ignore this email.</p>"
                    + "</div>"
                    + "</div>"
                    + "</body></html>";

            helper.setText(htmlContent, true);  // true means it's an HTML email

            // Send the email
            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exception, maybe log the error or send a failure response
        }
    }
}
