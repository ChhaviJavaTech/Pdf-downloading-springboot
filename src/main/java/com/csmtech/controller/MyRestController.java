package com.csmtech.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csmtech.model.Prescription_tbl;
import com.csmtech.service.PatientService;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.io.codec.Base64;



@RestController
public class MyRestController {
	
	@Autowired
	public PatientService paServ;
	
	@GetMapping("/getPatientDetailes")
	public List getPatientDetailesByMobile(@RequestParam("mbn") String mbn) {
		System.out.println("in property master");
		List result= new ArrayList();
		System.out.println(mbn);
		result = paServ.getPatientDetailes(mbn);
		System.out.println(result+ "in controller");
		return result;
		
	}
	@GetMapping("/getPatientHistory")
	public String getPatientHistoryByPid(@RequestParam("pid") String pid) {
		System.out.println("in pat master");
		List<Map<String,String>> result= new ArrayList();
		System.out.println(pid);
		result = paServ.getPatientHistoryByPid(pid);
		System.out.println(result);
		StringBuilder html=new StringBuilder();
		String gd=(result.get(0).get("gender").equalsIgnoreCase("f")?"Female":"Male");
		html.append("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "	<meta charset=\"utf-8\">\r\n"
				+ "	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "	<title></title>\r\n"
				+ "</head>");
		html.append("<body>\r\n"
				+ "<div style=\"margin-inline: 60px;padding: 10px;\">\r\n"
				+ "	<table style=\"width: 100%;\" >\r\n"
				+ "		<tr>\r\n"
				+ "			<th>\r\n"
				+ "				<img src=\"C:\\Users\\root\\Desktop\\Wikimedia-logo.png\" style=\"width:150px;height: 150px;\" alt=\"NA\" ></th>\r\n"
				+ "			</th>\r\n"
				+ "			<th>\r\n"
				+ "				<h1 style=\"color:red;text-align: center;\">Patient Medical History</h1>\r\n"
				+ "				<table style=\"width: 100%;text-align: left;\" >\r\n"
				+ "					<tr>\r\n"
				+ "						<td><span style=\"font-size: 24px;font-weight: bold;\">Name:"+result.get(0).get("name")+"</span ></td>\r\n"
				+ "\r\n"
				+ "					</tr>\r\n"
				+ "					<tr>\r\n"
				+ "						<td><span style=\"font-size: 24px;font-weight: bold;\">Date Of birth:"+result.get(0).get("dob")+"</span ></td>\r\n"
				+ "						<td><span style=\"font-size: 24px;font-weight: bold;\">Gender:"+gd+"</span ></td>\r\n"
				+ "					</tr>\r\n"
				+ "\r\n"
				+ "				</table>\r\n"
				+ "			</th>\r\n"
				+ "		</tr>");
		
		
		
		

		
		for(Map obj:result) {

			html.append("<tr >\r\n"
					+ "	<td colspan=2>\r\n"
					+ "						<fieldset >\r\n"
					+ "							<legend><h2>"+obj.get("dov")+"</h2></legend>\r\n"
					+ "							<div>\r\n"
					+ "							<b>Disease Name:-</b>"+obj.get("disease")+"<br>\r\n"
					+ "							<b>Prescription:-</b>"+obj.get("prescription")+"\r\n"
					+ "							</div>\r\n"
					+ "							\r\n"
					+ "						</fieldset>\r\n"
					+ "						</td>\r\n"
					+ "					</tr>");
			
		}

		html.append("	</table>\r\n"
				+ "<center><b>------End Of Report------</b></center>\r\n"
				+ "</div>\r\n"
				+ "</body>\r\n"
				+ "</html>");

		OutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream("D:\\MyFile\\string-output.pdf");
			HtmlConverter.convertToPdf(html.toString(), fileOutputStream);
			FileInputStream fi=new FileInputStream("D:\\MyFile\\string-output.pdf");
			byte[] readAllBytes = fi.readAllBytes();
			String encodeBytes = Base64.encodeBytes(readAllBytes);
			
			return encodeBytes;
					} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
		System.out.println(result+ "in controller");
		return null;
		
	}

}
