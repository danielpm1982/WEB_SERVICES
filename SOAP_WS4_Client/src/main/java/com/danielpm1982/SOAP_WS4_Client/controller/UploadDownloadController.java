package com.danielpm1982.SOAP_WS4_Client.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.danielpm1982.SOAP_WS4_Client.helper.UploadDownloadHelper;

@Controller
@RequestMapping("/controller")
public class UploadDownloadController {
	@RequestMapping("/testUpload")
	public String testUpload() {
		UploadDownloadHelper.upload();
		return "uploadResult";
	}
	@RequestMapping("/testDownload")
	public String testDownload() {
		UploadDownloadHelper.download();
		return "downloadResult";
	}
}
