package com.nkserviemail.app.model;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class AppController {

	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/send_text_email")
	public String sendPlainTextEmail(Model model) {
		String from = "codejava.net@gmail.com";
		String to = "vonealmar@gmail.com";
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject("This is a plain text email");
		message.setText("Hello guys! This is a plain text email.");
		
		mailSender.send(message);
		
		model.addAttribute("message", "A plain text email has been sent");
		return "result";
	}
	
	@GetMapping("/send_html_email")
	public String sendHTMLEmail(Model model) throws MessagingException {
		String from = "codejava.net@gmail.com";
		String to = "vonealmar@gmail.com";
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		helper.setSubject("Creación de usuario");
		helper.setFrom(from);
		helper.setTo(to);

		boolean html = true;
		helper.setText("<!doctype html>\r\n"
				+ "<html>\r\n"
				+ "  <head>\r\n"
				+ "    <meta name='viewport' content='width=device-width'>\r\n"
				+ "    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>\r\n"
				+ "    <title>Simple Transactional Email</title>\r\n"
				+ "    <style>\r\n"
				+ "    /* -------------------------------------\r\n"
				+ "        INLINED WITH htmlemail.io/inline\r\n"
				+ "    ------------------------------------- */\r\n"
				+ "    /* -------------------------------------\r\n"
				+ "        RESPONSIVE AND MOBILE FRIENDLY STYLES\r\n"
				+ "    ------------------------------------- */\r\n"
				+ "    @media only screen and (max-width: 620px) {\r\n"
				+ "      table[class=body] h1 {\r\n"
				+ "        font-size: 28px !important;\r\n"
				+ "        margin-bottom: 10px !important;\r\n"
				+ "      }\r\n"
				+ "      table[class=body] p,\r\n"
				+ "            table[class=body] ul,\r\n"
				+ "            table[class=body] ol,\r\n"
				+ "            table[class=body] td,\r\n"
				+ "            table[class=body] span,\r\n"
				+ "            table[class=body] a {\r\n"
				+ "        font-size: 16px !important;\r\n"
				+ "      }\r\n"
				+ "      table[class=body] .wrapper,\r\n"
				+ "            table[class=body] .article {\r\n"
				+ "        padding: 10px !important;\r\n"
				+ "      }\r\n"
				+ "      table[class=body] .content {\r\n"
				+ "        padding: 0 !important;\r\n"
				+ "      }\r\n"
				+ "      table[class=body] .container {\r\n"
				+ "        padding: 0 !important;\r\n"
				+ "        width: 100% !important;\r\n"
				+ "      }\r\n"
				+ "      table[class=body] .main {\r\n"
				+ "        border-left-width: 0 !important;\r\n"
				+ "        border-radius: 0 !important;\r\n"
				+ "        border-right-width: 0 !important;\r\n"
				+ "      }\r\n"
				+ "      table[class=body] .btn table {\r\n"
				+ "        width: 100% !important;\r\n"
				+ "      }\r\n"
				+ "      table[class=body] .btn a {\r\n"
				+ "        width: 100% !important;\r\n"
				+ "      }\r\n"
				+ "      table[class=body] .img-responsive {\r\n"
				+ "        height: auto !important;\r\n"
				+ "        max-width: 100% !important;\r\n"
				+ "        width: auto !important;\r\n"
				+ "      }\r\n"
				+ "    }\r\n"
				+ "    /* -------------------------------------\r\n"
				+ "        PRESERVE THESE STYLES IN THE HEAD\r\n"
				+ "    ------------------------------------- */\r\n"
				+ "    @media all {\r\n"
				+ "      .ExternalClass {\r\n"
				+ "        width: 100%;\r\n"
				+ "      }\r\n"
				+ "      .ExternalClass,\r\n"
				+ "            .ExternalClass p,\r\n"
				+ "            .ExternalClass span,\r\n"
				+ "            .ExternalClass font,\r\n"
				+ "            .ExternalClass td,\r\n"
				+ "            .ExternalClass div {\r\n"
				+ "        line-height: 100%;\r\n"
				+ "      }\r\n"
				+ "      .apple-link a {\r\n"
				+ "        color: inherit !important;\r\n"
				+ "        font-family: inherit !important;\r\n"
				+ "        font-size: inherit !important;\r\n"
				+ "        font-weight: inherit !important;\r\n"
				+ "        line-height: inherit !important;\r\n"
				+ "        text-decoration: none !important;\r\n"
				+ "      }\r\n"
				+ "      #MessageViewBody a {\r\n"
				+ "        color: inherit;\r\n"
				+ "        text-decoration: none;\r\n"
				+ "        font-size: inherit;\r\n"
				+ "        font-family: inherit;\r\n"
				+ "        font-weight: inherit;\r\n"
				+ "        line-height: inherit;\r\n"
				+ "      }\r\n"
				+ "      .btn-primary table td:hover {\r\n"
				+ "        background-color: #34495e !important;\r\n"
				+ "      }\r\n"
				+ "      .btn-primary a:hover {\r\n"
				+ "        background-color: #34495e !important;\r\n"
				+ "        border-color: #34495e !important;\r\n"
				+ "      }\r\n"
				+ "    }\r\n"
				+ "    </style>\r\n"
				+ "  </head>\r\n"
				+ "  <body class='' style='background-color: #f6f6f6; font-family: sans-serif; -webkit-font-smoothing: antialiased; font-size: 14px; line-height: 1.4; margin: 0; padding: 0; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;'>\r\n"
				+ "    <table border='0' cellpadding='0' cellspacing='0' class='body' style='border-collapse: separate; mso-table-lspace: 0pt; mso-table-rspace: 0pt; width: 100%; background-color: #f6f6f6;'>\r\n"
				+ "      <tr>\r\n"
				+ "        <td style='font-family: sans-serif; font-size: 14px; vertical-align: top;'>&nbsp;</td>\r\n"
				+ "        <td class='container' style='font-family: sans-serif; font-size: 14px; vertical-align: top; display: block; Margin: 0 auto; max-width: 580px; padding: 10px; width: 580px;'>\r\n"
				+ "          <div class='content' style='box-sizing: border-box; display: block; Margin: 0 auto; max-width: 580px; padding: 10px;'>\r\n"
				+ "\r\n"
				+ "            <!-- START CENTERED WHITE CONTAINER -->\r\n"
				+ "            <span class='preheader' style='color: transparent; display: none; height: 0; max-height: 0; max-width: 0; opacity: 0; overflow: hidden; mso-hide: all; visibility: hidden; width: 0;'>This is preheader text. Some clients will show this text as a preview.</span>\r\n"
				+ "            <table class='main' style='border-collapse: separate; mso-table-lspace: 0pt; mso-table-rspace: 0pt; width: 100%; background: #ffffff; border-radius: 3px;'>\r\n"
				+ "\r\n"
				+ "              <!-- START MAIN CONTENT AREA -->\r\n"
				+ "              <tr>\r\n"
				+ "                <td class='wrapper' style='font-family: sans-serif; font-size: 14px; vertical-align: top; box-sizing: border-box; padding: 20px;'>\r\n"
				+ "                  <table border='0' cellpadding='0' cellspacing='0' style='border-collapse: separate; mso-table-lspace: 0pt; mso-table-rspace: 0pt; width: 100%;'>\r\n"
				+ "                    <tr>\r\n"
				+ "                      <td style='font-family: sans-serif; font-size: 14px; vertical-align: top;'>\r\n"
				+ "                        <p style='font-family: sans-serif; font-size: 14px; font-weight: normal; margin: 0; Margin-bottom: 15px;'>$subject</p>\r\n"
				+ "                        <p style='font-family: sans-serif; font-size: 14px; font-weight: normal; margin: 0; Margin-bottom: 15px;'>$content</p>\r\n"
				+ "                        <table border='0' cellpadding='0' cellspacing='0' class='btn btn-primary' style='border-collapse: separate; mso-table-lspace: 0pt; mso-table-rspace: 0pt; width: 100%; box-sizing: border-box;'>\r\n"
				+ "                          <tbody>\r\n"
				+ "                            <tr>\r\n"
				+ "                              <td align='left' style='font-family: sans-serif; font-size: 14px; vertical-align: top; padding-bottom: 15px;'>\r\n"
				+ "                                <table border='0' cellpadding='0' cellspacing='0' style='border-collapse: separate; mso-table-lspace: 0pt; mso-table-rspace: 0pt; width: auto;'>\r\n"
				+ "                                  <tbody>\r\n"
				+ "                                    <tr>\r\n"
				+ "                                      <td style='font-family: sans-serif; font-size: 14px; vertical-align: top; background-color: #3498db; border-radius: 5px; text-align: center;'> <a href='http://htmlemail.io' target='_blank' style='display: inline-block; color: #ffffff; background-color: #3498db; border: solid 1px #3498db; border-radius: 5px; box-sizing: border-box; cursor: pointer; text-decoration: none; font-size: 14px; font-weight: bold; margin: 0; padding: 12px 25px; text-transform: capitalize; border-color: #3498db;'>Ingresar</a> </td>\r\n"
				+ "                                    </tr>\r\n"
				+ "                                  </tbody>\r\n"
				+ "                                </table>\r\n"
				+ "                              </td>\r\n"
				+ "                            </tr>\r\n"
				+ "                          </tbody>\r\n"
				+ "                        </table>\r\n"
				+ "                        <p style='font-family: sans-serif; font-size: 14px; font-weight: normal; margin: 0; Margin-bottom: 15px;'>A continuación encontrará la clave asignada al usuario. Its sole purpose is to get the recipient to click the button with no distractions.</p>\r\n"
				+ "                        <p style='font-family: sans-serif; font-size: 14px; font-weight: normal; margin: 0; Margin-bottom: 15px;'>Good luck! Hope it works.</p>\r\n"
				+ "                      </td>\r\n"
				+ "                    </tr>\r\n"
				+ "                  </table>\r\n"
				+ "                </td>\r\n"
				+ "              </tr>\r\n"
				+ "\r\n"
				+ "            <!-- END MAIN CONTENT AREA -->\r\n"
				+ "            </table>\r\n"
				+ "\r\n"
				+ "            <!-- START FOOTER -->\r\n"
				+ "            <div class='footer' style='clear: both; Margin-top: 10px; text-align: center; width: 100%;'>\r\n"
				+ "              <table border='0' cellpadding='0' cellspacing='0' style='border-collapse: separate; mso-table-lspace: 0pt; mso-table-rspace: 0pt; width: 100%;'>\r\n"
				+ "                <tr>\r\n"
				+ "                  <td class='content-block' style='font-family: sans-serif; vertical-align: top; padding-bottom: 10px; padding-top: 10px; font-size: 12px; color: #999999; text-align: center;'>\r\n"
				+ "                    <span class='apple-link' style='color: #999999; font-size: 12px; text-align: center;'>Nota: La información transmitida a través de este correo electrónico es confidencial y esta dirigida únicamente a su destinatario. Su reproducción, lectura o uso está prohibido.</span>\r\n"
		
				+ "                  </td>\r\n"
				+ "                </tr>\r\n"
				+ "                <tr>\r\n"
				+ "                  <td class='content-block powered-by' style='font-family: sans-serif; vertical-align: top; padding-bottom: 10px; padding-top: 10px; font-size: 12px; color: #999999; text-align: center;'>\r\n"
				+ "                    Copyright <a href='http://htmlemail.io' style='color: #999999; font-size: 12px; text-align: center; text-decoration: none;'>Nk-System Corporation S.A.</a> - 2021\r\n"
				+ "                  </td>\r\n"
				+ "                </tr>\r\n"
				+ "              </table>\r\n"
				+ "            </div>\r\n"
				+ "            <!-- END FOOTER -->\r\n"
				+ "\r\n"
				+ "          <!-- END CENTERED WHITE CONTAINER -->\r\n"
				+ "          </div>\r\n"
				+ "        </td>\r\n"
				+ "        <td style='font-family: sans-serif; font-size: 14px; vertical-align: top;'>&nbsp;</td>\r\n"
				+ "      </tr>\r\n"
				+ "    </table>\r\n"
				+ "  </body>\r\n"
				+ "</html>\r\n"
				+ "\r\n"
				+ "", html);

		mailSender.send(message);
		
		model.addAttribute("message", "An HTML email has been sent");
		return "result";		
	}
	
	@PostMapping("/send_email_crear")
	public ResponseEntity<?> sendEmailCrearUser(@RequestBody User email) throws MessagingException {
		
		//InternetAddress cAddress = new InternetAddress( email, true );
	    //System.out.println( cAddress.toString() );
		String from = "vonealmar@gmail.com";
		String to = email.getEmail();
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		helper.setSubject("Creación de usuario");
		helper.setFrom(from);
		helper.setTo(to);

		boolean html = true;
		helper.setText("<!doctype html>\r\n"
				+ "<html>\r\n"
				+ "  <head>\r\n"
				+ "    <meta name='viewport' content='width=device-width'>\r\n"
				+ "    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>\r\n"
				+ "    <title>Email confirmacion de creacion de usuario</title>\r\n"
				+ "    <style>\r\n"
				+ "    /* -------------------------------------\r\n"
				+ "        INLINED WITH htmlemail.io/inline\r\n"
				+ "    ------------------------------------- */\r\n"
				+ "    /* -------------------------------------\r\n"
				+ "        RESPONSIVE AND MOBILE FRIENDLY STYLES\r\n"
				+ "    ------------------------------------- */\r\n"
				+ "    @media only screen and (max-width: 620px) {\r\n"
				+ "      table[class=body] h1 {\r\n"
				+ "        font-size: 28px !important;\r\n"
				+ "        margin-bottom: 10px !important;\r\n"
				+ "      }\r\n"
				+ "      table[class=body] p,\r\n"
				+ "            table[class=body] ul,\r\n"
				+ "            table[class=body] ol,\r\n"
				+ "            table[class=body] td,\r\n"
				+ "            table[class=body] span,\r\n"
				+ "            table[class=body] a {\r\n"
				+ "        font-size: 16px !important;\r\n"
				+ "      }\r\n"
				+ "      table[class=body] .wrapper,\r\n"
				+ "            table[class=body] .article {\r\n"
				+ "        padding: 10px !important;\r\n"
				+ "      }\r\n"
				+ "      table[class=body] .content {\r\n"
				+ "        padding: 0 !important;\r\n"
				+ "      }\r\n"
				+ "      table[class=body] .container {\r\n"
				+ "        padding: 0 !important;\r\n"
				+ "        width: 100% !important;\r\n"
				+ "      }\r\n"
				+ "      table[class=body] .main {\r\n"
				+ "        border-left-width: 0 !important;\r\n"
				+ "        border-radius: 0 !important;\r\n"
				+ "        border-right-width: 0 !important;\r\n"
				+ "      }\r\n"
				+ "      table[class=body] .btn table {\r\n"
				+ "        width: 100% !important;\r\n"
				+ "      }\r\n"
				+ "      table[class=body] .btn a {\r\n"
				+ "        width: 100% !important;\r\n"
				+ "      }\r\n"
				+ "      table[class=body] .img-responsive {\r\n"
				+ "        height: auto !important;\r\n"
				+ "        max-width: 100% !important;\r\n"
				+ "        width: auto !important;\r\n"
				+ "      }\r\n"
				+ "    }\r\n"
				+ "    /* -------------------------------------\r\n"
				+ "        PRESERVE THESE STYLES IN THE HEAD\r\n"
				+ "    ------------------------------------- */\r\n"
				+ "    @media all {\r\n"
				+ "      .ExternalClass {\r\n"
				+ "        width: 100%;\r\n"
				+ "      }\r\n"
				+ "      .ExternalClass,\r\n"
				+ "            .ExternalClass p,\r\n"
				+ "            .ExternalClass span,\r\n"
				+ "            .ExternalClass font,\r\n"
				+ "            .ExternalClass td,\r\n"
				+ "            .ExternalClass div {\r\n"
				+ "        line-height: 100%;\r\n"
				+ "      }\r\n"
				+ "      .apple-link a {\r\n"
				+ "        color: inherit !important;\r\n"
				+ "        font-family: inherit !important;\r\n"
				+ "        font-size: inherit !important;\r\n"
				+ "        font-weight: inherit !important;\r\n"
				+ "        line-height: inherit !important;\r\n"
				+ "        text-decoration: none !important;\r\n"
				+ "      }\r\n"
				+ "      #MessageViewBody a {\r\n"
				+ "        color: inherit;\r\n"
				+ "        text-decoration: none;\r\n"
				+ "        font-size: inherit;\r\n"
				+ "        font-family: inherit;\r\n"
				+ "        font-weight: inherit;\r\n"
				+ "        line-height: inherit;\r\n"
				+ "      }\r\n"
				+ "      .btn-primary table td:hover {\r\n"
				+ "        background-color: #34495e !important;\r\n"
				+ "      }\r\n"
				+ "      .btn-primary a:hover {\r\n"
				+ "        background-color: #34495e !important;\r\n"
				+ "        border-color: #34495e !important;\r\n"
				+ "      }\r\n"
				+ "    }\r\n"
				+ "    </style>\r\n"
				+ "  </head>\r\n"
				+ "  <body class='' style='background-color: #f6f6f6; font-family: sans-serif; -webkit-font-smoothing: antialiased; font-size: 14px; line-height: 1.4; margin: 0; padding: 0; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;'>\r\n"
				+ "    <table border='0' cellpadding='0' cellspacing='0' class='body' style='border-collapse: separate; mso-table-lspace: 0pt; mso-table-rspace: 0pt; width: 100%; background-color: #f6f6f6;'>\r\n"
				+ "      <tr>\r\n"
				+ "        <td style='font-family: sans-serif; font-size: 14px; vertical-align: top;'>&nbsp;</td>\r\n"
				+ "        <td class='container' style='font-family: sans-serif; font-size: 14px; vertical-align: top; display: block; Margin: 0 auto; max-width: 580px; padding: 10px; width: 580px;'>\r\n"
				+ "          <div class='content' style='box-sizing: border-box; display: block; Margin: 0 auto; max-width: 580px; padding: 10px;'>\r\n"
				+ "\r\n"
				+ "            <!-- START CENTERED WHITE CONTAINER -->\r\n"
				+ "            <span class='preheader' style='color: transparent; display: none; height: 0; max-height: 0; max-width: 0; opacity: 0; overflow: hidden; mso-hide: all; visibility: hidden; width: 0;'>Cracion de usuario en el portal Nk-System Administrativo.</span>\r\n"
				+ "            <table class='main' style='border-collapse: separate; mso-table-lspace: 0pt; mso-table-rspace: 0pt; width: 100%; background: #ffffff; border-radius: 3px;'>\r\n"
				+ "\r\n"
				+ "              <!-- START MAIN CONTENT AREA -->\r\n"
				+ "              <tr>\r\n"
				+ "                <td class='wrapper' style='font-family: sans-serif; font-size: 14px; vertical-align: top; box-sizing: border-box; padding: 20px;'>\r\n"
				+ "                  <table border='0' cellpadding='0' cellspacing='0' style='border-collapse: separate; mso-table-lspace: 0pt; mso-table-rspace: 0pt; width: 100%;'>\r\n"
				+ "                    <tr>\r\n"
				+ "                      <td style='font-family: sans-serif; font-size: 14px; vertical-align: top;'>\r\n"
				+ "                        <p style='font-family: sans-serif; font-size: 14px; font-weight: normal; margin: 0; Margin-bottom: 15px;'> Hola "+email.getUsername()+"</p>\r\n"
				+ "                        <p align='center' style='font-family: sans-serif; font-size: 14px; font-weight: normal; margin: 0; Margin-bottom: 15px;'>El Usuario "+ email.getEmail() +" puede acceder al sistema.</p>\r\n"
				+ "                        <table border='0' cellpadding='0' cellspacing='0' class='btn btn-primary' style='border-collapse: separate; mso-table-lspace: 0pt; mso-table-rspace: 0pt; width: 100%; box-sizing: border-box;'>\r\n"
				+ "                          <tbody>\r\n"
				+ "                            <tr>\r\n"
				+ "                              <td align='center' style='font-family: sans-serif; font-size: 14px; vertical-align: top; padding-bottom: 15px;'>\r\n"
				+ "                                <table border='0' cellpadding='0' cellspacing='0' style='border-collapse: separate; mso-table-lspace: 0pt; mso-table-rspace: 0pt; width: auto;'>\r\n"
				+ "                                  <tbody>\r\n"
				+ "                                    <tr>\r\n"
				+ "                                      <td style='font-family: sans-serif; font-size: 14px; vertical-align: top; background-color: #3498db; border-radius: 5px; text-align: center;'> <a href='http://localhost:4200/login' target='_blank' style='display: inline-block; color: #ffffff; background-color: #3498db; border: solid 1px #3498db; border-radius: 5px; box-sizing: border-box; cursor: pointer; text-decoration: none; font-size: 14px; font-weight: bold; margin: 0; padding: 12px 25px; text-transform: capitalize; border-color: #3498db;'>Ingresar</a> </td>\r\n"
				+ "                                    </tr>\r\n"
				+ "                                  </tbody>\r\n"
				+ "                                </table>\r\n"
				+ "                              </td>\r\n"
				+ "                            </tr>\r\n"
				+ "                          </tbody>\r\n"
				+ "                        </table>\r\n"
				+ "                        <p align='center' style='font-family: sans-serif; font-size: 14px; font-weight: normal; margin: 0; Margin-bottom: 15px;'>A continuación encontrará la clave asignada al usuario.</p>\r\n"
				+ "                        <p align='center' style='font-family: sans-serif; font-size: 24px; font-weight: normal; margin: 0; Margin-bottom: 15px;'>123456</p>\r\n"
				+ "                      </td>\r\n"
				+ "                    </tr>\r\n"
				+ "                  </table>\r\n"
				+ "                </td>\r\n"
				+ "              </tr>\r\n"
				+ "\r\n"
				+ "            <!-- END MAIN CONTENT AREA -->\r\n"
				+ "            </table>\r\n"
				+ "\r\n"
				+ "            <!-- START FOOTER -->\r\n"
				+ "            <div class='footer' style='clear: both; Margin-top: 10px; text-align: center; width: 100%;'>\r\n"
				+ "              <table border='0' cellpadding='0' cellspacing='0' style='border-collapse: separate; mso-table-lspace: 0pt; mso-table-rspace: 0pt; width: 100%;'>\r\n"
				+ "                <tr>\r\n"
				+ "                  <td class='content-block' style='font-family: sans-serif; vertical-align: top; padding-bottom: 10px; padding-top: 10px; font-size: 12px; color: #999999; text-align: center;'>\r\n"
				+ "                    <span class='apple-link' style='color: #999999; font-size: 12px; text-align: center;'>Nota: La información transmitida a través de este correo electrónico es confidencial y esta dirigida únicamente a su destinatario. Su reproducción, lectura o uso está prohibido.</span>\r\n"
		
				+ "                  </td>\r\n"
				+ "                </tr>\r\n"
				+ "                <tr>\r\n"
				+ "                  <td class='content-block powered-by' style='font-family: sans-serif; vertical-align: top; padding-bottom: 10px; padding-top: 10px; font-size: 12px; color: #999999; text-align: center;'>\r\n"
				+ "                    Copyright <a href='http://htmlemail.io' style='color: #999999; font-size: 12px; text-align: center; text-decoration: none;'>Nk-System Corporation S.A.</a> - 2021\r\n"
				+ "                  </td>\r\n"
				+ "                </tr>\r\n"
				+ "              </table>\r\n"
				+ "            </div>\r\n"
				+ "            <!-- END FOOTER -->\r\n"
				+ "\r\n"
				+ "          <!-- END CENTERED WHITE CONTAINER -->\r\n"
				+ "          </div>\r\n"
				+ "        </td>\r\n"
				+ "        <td style='font-family: sans-serif; font-size: 14px; vertical-align: top;'>&nbsp;</td>\r\n"
				+ "      </tr>\r\n"
				+ "    </table>\r\n"
				+ "  </body>\r\n"
				+ "</html>\r\n"
				+ "\r\n"
				+ "", html);

		mailSender.send(message);
		return new ResponseEntity<>(HttpStatus.OK);		
	}
	
	
	@GetMapping("/send_email_attachment")
	public String sendHTMLEmailWithAttachment(Model model) throws MessagingException {
		
		String from = "codejava.net@gmail.com";
		String to = "hainatu@gmail.com";
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		helper.setSubject("Here's your e-book");
		helper.setFrom(from);
		helper.setTo(to);
		
		helper.setText("<b>Dear friend</b>,<br><i>Please find the book attached.</i>", true);
		
		FileSystemResource file = new FileSystemResource(new File("g:\\MyEbooks\\Freelance for Programmers\\SuccessFreelance-Preview.pdf"));
		helper.addAttachment("FreelanceSuccess.pdf", file);

		mailSender.send(message);
		
		model.addAttribute("message", "An HTML email with attachment has been sent");
		return "result";		
	}
	
	@GetMapping("/send_email_inline_image")
	public String sendHTMLEmailWithInlineImage(Model model) throws MessagingException {
		
		String from = "codejava.net@gmail.com";
		String to = "hainatu@gmail.com";
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		helper.setSubject("Here's your pic");
		helper.setFrom(from);
		helper.setTo(to);
		
		String content = "<b>Dear guru</b>,<br><i>Please look at this nice picture:.</i>"
							+ "<br><img src='cid:image001'/><br><b>Best Regards</b>"; 
		helper.setText(content, true);
		
		FileSystemResource resource = new FileSystemResource(new File("g:\\MyEbooks\\Freelance for Programmers\\images\\admiration.png"));
		helper.addInline("image001", resource);

		mailSender.send(message);
		
		model.addAttribute("message", "An HTML email with inline image has been sent");
		return "result";		
	}	
}
