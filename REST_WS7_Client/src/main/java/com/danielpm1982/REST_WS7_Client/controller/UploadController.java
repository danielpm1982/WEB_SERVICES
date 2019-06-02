package com.danielpm1982.REST_WS7_Client.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.danielpm1982.REST_WS7_Client.helper.Helper;
import com.danielpm1982.REST_WS7_Client.helper.HelperImpl;

@Controller
public class UploadController {
	@Value("${upload_url}")
	private String uploadURL;
	@GetMapping("/upload1")
	public String showUpload1(Model model) {
		return "upload1";
	}
	@GetMapping("/upload2")
	public String showUpload2(Model model) {
		model.addAttribute("uploadURL",uploadURL);
		return "upload2";
	}
	@RequestMapping("/upload")
	public String upload(@Value("${source_local_folder}") String sourceLocalFolder, @RequestParam("fileName") String fileName, Model model) {
		Helper helper = new HelperImpl();
		helper.upload(uploadURL, sourceLocalFolder+fileName);
		model.addAttribute("uploadURL", uploadURL);
		model.addAttribute("filePathString", sourceLocalFolder+fileName);
		return "uploadResult";
	}
}
