package com.mg.jsp.question.model.dto;

public class AttaQuestionDTO implements java.io.Serializable{
	
	private int no;
	private int refQnaNo;
	private String originalName;
	private String savedName;
	private String savedPath;
	private String fileType;
	private String thumbnailPath;
	private String status;
	
	public AttaQuestionDTO() {}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getRefQnaNo() {
		return refQnaNo;
	}

	public void setRefQnaNo(int refQnaNo) {
		this.refQnaNo = refQnaNo;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public String getSavedName() {
		return savedName;
	}

	public void setSavedName(String savedName) {
		this.savedName = savedName;
	}

	public String getSavedPath() {
		return savedPath;
	}

	@Override
	public String toString() {
		return "AttaQuestionDTO [no=" + no + ", refQnaNo=" + refQnaNo + ", originalName=" + originalName
				+ ", savedName=" + savedName + ", savedPath=" + savedPath + ", fileType=" + fileType
				+ ", thumbnailPath=" + thumbnailPath + ", status=" + status + "]";
	}

	public void setSavedPath(String savedPath) {
		this.savedPath = savedPath;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public AttaQuestionDTO(int no, int refQnaNo, String originalName, String savedName, String savedPath,
			String fileType, String thumbnailPath, String status) {
		super();
		this.no = no;
		this.refQnaNo = refQnaNo;
		this.originalName = originalName;
		this.savedName = savedName;
		this.savedPath = savedPath;
		this.fileType = fileType;
		this.thumbnailPath = thumbnailPath;
		this.status = status;
	}

	public String getThumbnailPath() {
		return thumbnailPath;
	}

	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
