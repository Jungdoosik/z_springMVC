package kr.or.iei.file.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.iei.file.model.service.FileService;

@Controller
public class FileController {

	@Autowired
	@Qualifier(value="fService")
	private FileService fService;
	
	
	@RequestMapping(value="/file/fileUploadPage.do")
	public String fileUploadPage() {
		
		return "file/fileUploadPage";
	}
}
