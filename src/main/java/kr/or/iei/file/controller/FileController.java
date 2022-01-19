package kr.or.iei.file.controller;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.iei.file.model.service.FileService;
import kr.or.iei.member.model.vo.Member;

@Controller
public class FileController {

	@Autowired
	@Qualifier(value="fService")
	private FileService fService;
	
	@Autowired
	private ServletContext context;
	
	
	@RequestMapping(value="/file/fileUploadPage.do", method = RequestMethod.GET)
	public String fileUploadPage() {
		
		return "file/fileUploadPage";
	}
	
	
	@RequestMapping(value="/file/fileUpload.do",method = RequestMethod.GET)
	public void fileupload(HttpServletRequest request, @SessionAttribute Member member) throws IOException {
		//1.
		String uploadPath = "/WEB-INF/upload/";
		String uploadFilePath = context.getRealPath(uploadPath); 
		//2.
		int fileSizeLimit = 50* 1024* 1024;
		//3.
		String encType = "UTF-8";
		
		//4.
		MultipartRequest multi = new MultipartRequest(request,
													uploadFilePath,
													fileSizeLimit,
													encType,
													new DefaultFileRenamePolicy());
		
		//5.
		String originalFileName = multi.getFilesystemName("file");
		//6.
		String userId = member.getUserId();
		//7.
		long currentTime = Calendar.getInstance().getTimeInMillis();
		//8.
		File folder = new File(uploadFilePath+"\\"+userId);
		folder.mkdir();
		
		//9.
		File file = new File(uploadFilePath+"\\"+originalFileName);
		file.renameTo(new File(uploadFilePath+"\\"+userId+"\\"+currentTime+"_kh"));
		
		//10.
		String changeFileName = currentTime+"_kh";
		
		
		
			
			
	}
	
}
