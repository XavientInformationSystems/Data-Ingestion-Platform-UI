package com.xavient.dataingest.controller;

import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.xavient.dataingest.StreamingPlatform;
import com.xavient.dataingest.service.DataIngestionService;

@Controller
public class DataIngestionController {
	@Autowired
	private DataIngestionService service;

	@RequestMapping(value = "/ingestText", method = RequestMethod.POST)
	public String ingest(
			@RequestParam(value = "streamingPlatform", defaultValue = "STORM") StreamingPlatform streamingPlatform,
			@RequestParam("data") String data,RedirectAttributes attributes) {
		service.publishToKafka(Arrays.asList(data.trim().split("\n")),
				streamingPlatform);
		attributes.addFlashAttribute("success", "Message sent to kafka topic");
		return "redirect:/";
	}

	@RequestMapping(value = "/ingestFile", method = RequestMethod.POST)
	public String ingest(
			@RequestParam(value = "streamingPlatform", defaultValue = "STORM") StreamingPlatform streamingPlatform,
			@RequestParam("file") MultipartFile file,RedirectAttributes attributes) throws IOException {
		service.publishToKafka(IOUtils.readLines(file.getInputStream()),
				streamingPlatform);
		attributes.addFlashAttribute("success", "Message sent to kafka topic");
		return "redirect:/";
	}

	@RequestMapping("/")
	public String home() {
		return "ingest-data";
	}

}
