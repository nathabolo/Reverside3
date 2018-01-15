package com.reverside.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.reverside.auth.model.Employee;

@Service
public class NotificationService {
	
	private JavaMailSender javaMailSender;
	
	@Autowired
	public NotificationService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendNotification(Employee employee) throws MailException {
		//send our email here
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(employee.getEmail());
		mail.setFrom("nathabolo@gmail.com");
		mail.setSubject("Employee Timesheet");
		mail.setText("Please checkout for an Employee Timesheet");
		
		javaMailSender.send(mail);
	}

}
