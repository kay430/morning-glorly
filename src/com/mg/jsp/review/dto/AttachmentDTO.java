package com.mg.jsp.review.dto;

public class AttachmentDTO implements java.io.Serializable{

	private int no;
	private int notiNo;
	private String originalName;
	private String savedName;
	private String savePath;
	private String fileType;
	private String thumbnailPath;
	private String attachmentStatus;
	
	public AttachmentDTO() {}

	public AttachmentDTO(int notiNo, int no, String originalName, String savedName, String savePath, String fileType,
			String thumbnailPath, String attachmentStatus) {
		super();
		this.notiNo = notiNo;
		this.no = no;
		this.originalName = originalName;
		this.savedName = savedName;
		this.savePath = savePath;
		this.fileType = fileType;
		this.thumbnailPath = thumbnailPath;
		this.attachmentStatus = attachmentStatus;
	}

	@Override
	public String toString() {
		return "AttachmentDTO [no=" + no + ", notiNo=" + notiNo + ", originalName=" + originalName + ", savedName="
				+ savedName + ", savePath=" + savePath + ", fileType=" + fileType + ", thumbnailPath=" + thumbnailPath
				+ ", attachmentStatus=" + attachmentStatus + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getNotiNo() {
		return notiNo;
	}

	public void setNotiNo(int notiNo) {
		this.notiNo = notiNo;
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

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getThumbnailPath() {
		return thumbnailPath;
	}

	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}

	public String getAttachmentStatus() {
		return attachmentStatus;
	}

	public void setAttachmentStatus(String attachmentStatus) {
		this.attachmentStatus = attachmentStatus;
	}

	
}