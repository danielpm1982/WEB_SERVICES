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
public class DownloadController {
	@Value("${download_base_url}")
	private String downloadBaseURL; //folder downloads will be saved at
	@GetMapping("/download1")
	public String showDownload1() {
		return "download1";
	}
	@GetMapping("/download2")
	public String showDownload2(Model model) {
		model.addAttribute("downloadBaseURL", downloadBaseURL);
		return "download2";
	}
	@RequestMapping("/download")
	public String download(@Value("${destine_local_folder}") String destineLocalFolder, @RequestParam("fileName") String fileName, Model model) {
		Helper helper = new HelperImpl();
		helper.download(downloadBaseURL, destineLocalFolder, fileName);
		model.addAttribute("downloadURL", downloadBaseURL+"/"+fileName);
		model.addAttribute("destineLocalFolder", destineLocalFolder);
		return "downloadResult";
	}
}
