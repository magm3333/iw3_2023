package ar.edu.iua.iw3.backend.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EmailBusiness {
	@Autowired
	private JavaMailSender emailSender;

	public void sendSimpleMessage(String to, String subject, String text) {
		log.trace("Enviando mail subject={} a: {}", subject, to);
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("noreply@magm.com.ar");
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text + "  " + new Date().toString());
		emailSender.send(message);
	}
}
