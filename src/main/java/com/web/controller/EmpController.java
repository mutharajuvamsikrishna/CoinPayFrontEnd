package com.web.controller;

import java.util.Properties;
import java.util.UUID;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.Converter;
import com.web.model.Otp;
import com.web.repo.OtpRepo;
import com.web.repo.ProRepo;
import com.web.repo.RegisterRepo;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class EmpController {

	@Autowired
	private ProRepo repo1;

	@Autowired
	private RegisterRepo repo5;
	@Autowired
	private OtpRepo otprepo;

	@PostMapping("/walletsave")
	public String walletsave(@RequestBody Converter con) {

		String email = con.getEmail();
		System.out.println(email);
		String otp = generateOTP();
		String otpId = UUID.randomUUID().toString();
		System.out.println(otp);
// Save the OTP to the database using the Otp class

		Otp otpEntity = new Otp(otpId, otp);
		otprepo.save(otpEntity);

		try {
			// Send OTP via email
			sendEmail12(email, "OTP Verification",
					"Hello, \n\nYour OTP is: " + otp + " and it is valid for 5 minutes.");
			System.out.println("Email sent successfully.");
		} catch (MessagingException e) {
			// Handle any exceptions that occurred during email sending
			e.printStackTrace();
			return "otperror";
		}

		return "walletotp";
	}

	private String generateOTP() {
		// Generate a random 6-digit OTP
		int otp = (int) (Math.random() * 900000) + 100000;
		return String.valueOf(otp);
	}

	private void sendEmail12(String recipientEmail, String subject, String body) throws MessagingException {
		// Replace with your email and password
		String senderEmail = "slrvamsikrishna@gmail.com";
		String senderPassword = "zugweogflidhqcyi";

		// Set properties
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		// Create session
		Session session = Session.getInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, senderPassword);
			}
		});

		// Create message
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(senderEmail));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
		message.setSubject(subject);
		message.setText(body);

		// Send message
		Transport.send(message);
		System.out.println("Email sent successfully.");
	}

	@PostMapping("/walletotp")
	public String submitOTP1(@RequestParam String otp, ModelMap model) {

		if (otp == null) {
			System.out.println("otp is null1");
		} else {
			System.out.println("otp is Entered" + otp);
		}

		Otp otp2 = otprepo.findByOtpValue(otp);
		if (otp2 == null) {
			return "inotp";
		}
		String otp3 = otp2.getOtpValue();
		if (otp != null) {
			System.out.println("Stored otp is not null" + otp3);
		}

		// Check if newRegister object is found in the session and OTP is correct
		if (otp != null && otp.equals(otp3)) {
			// Save the newRegister object using the repository

			otprepo.delete(otp2);
			return "regsucess";
		} else {
			// newRegister object not found in session or OTP is incorrect, return
			// registration failure page
			return "inotp";
		}
	}

	@PostMapping("/userwallet")
	public String userWallet(@RequestBody Converter emp, ModelMap m) {
		repo1.save(emp);
		return "Details Saved SucessFully";
	}

}
