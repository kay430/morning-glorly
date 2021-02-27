package com.mg.jsp.admin.model.dto;

public class AttaNoticeDTO {

	private int no;
	private int refNotiNo;
	private String originalName;
	private String savedName;
	private String savePath;
	private String fileType;
	private String thumbnailPath;
	private String status;
	
	public AttaNoticeDTO() {}

	public AttaNoticeDTO(int no, int refNotiNo, String originalName, String savedName, String savePath, String fileType,
			String thumbnailPath, String status) {
		super();
		this.no = no;
		this.refNotiNo = refNotiNo;
		this.originalName = originalName;
		this.savedName = savedName;
		this.savePath = savePath;
		this.fileType = fileType;
		this.thumbnailPath = thumbnailPath;
		this.status = status;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getRefNotiNo() {
		return refNotiNo;
	}

	public void setRefNotiNo(int refNotiNo) {
		this.refNotiNo = refNotiNo;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AttaNotice [no=" + no + ", refNotiNo=" + refNotiNo + ", originalName=" + originalName + ", savedName="
				+ savedName + ", savePath=" + savePath + ", fileType=" + fileType + ", thumbnailPath=" + thumbnailPath
				+ ", status=" + status + "]";
	}
	
}
