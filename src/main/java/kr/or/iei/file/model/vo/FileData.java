package kr.or.iei.file.model.vo;

import java.sql.Timestamp;

public class FileData {
	private int fileNo;
	private String originalFileName;
	private String changedFIleName;
	private String filePath;
	private long fileSize;
	private String fileUser;
	private Timestamp uploadTime;
	private char delYN;
	
	
	
	
	@Override
	public String toString() {
		return "FileData [fileNo=" + fileNo + ", originalFileName=" + originalFileName + ", changedFIleName="
				+ changedFIleName + ", filePath=" + filePath + ", fileSize=" + fileSize + ", fileUser=" + fileUser
				+ ", uploadTime=" + uploadTime + ", delYN=" + delYN + "]";
	}
	public FileData(int fileNo, String originalFileName, String changedFIleName, String filePath, long fileSize,
			String fileUser, Timestamp uploadTime, char delYN) {
		super();
		this.fileNo = fileNo;
		this.originalFileName = originalFileName;
		this.changedFIleName = changedFIleName;
		this.filePath = filePath;
		this.fileSize = fileSize;
		this.fileUser = fileUser;
		this.uploadTime = uploadTime;
		this.delYN = delYN;
	}
	public FileData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	public String getChangedFIleName() {
		return changedFIleName;
	}
	public void setChangedFIleName(String changedFIleName) {
		this.changedFIleName = changedFIleName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileUser() {
		return fileUser;
	}
	public void setFileUser(String fileUser) {
		this.fileUser = fileUser;
	}
	public Timestamp getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}
	public char getDelYN() {
		return delYN;
	}
	public void setDelYN(char delYN) {
		this.delYN = delYN;
	}
	
	
	
}
