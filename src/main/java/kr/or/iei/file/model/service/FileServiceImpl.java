package kr.or.iei.file.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.or.iei.file.model.dao.FileDAO;

@Service(value="fService")
public class FileServiceImpl implements FileService {
	
	
	@Autowired
	@Qualifier(value="fDAO")
	private FileDAO fDAO;

}
