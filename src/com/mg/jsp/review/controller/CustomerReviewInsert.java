package com.mg.jsp.review.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.mg.jsp.admin.model.product.model.dto.AttachmentDTO;
import com.mg.jsp.member.model.dto.MgDTO;
import com.mg.jsp.review.dto.ReviewDTO;
import com.mg.jsp.review.service.ReviewService;

import net.coobird.thumbnailator.Thumbnails;



@WebServlet("/review/insert")
public class CustomerReviewInsert extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/views/review/reviewinsert.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		String writer = request.getParameter("writer");
		int writerMemberNo = ((MgDTO) request.getSession().getAttribute("loginMember")).getNo();
		
		System.out.println("title : " + title);
		System.out.println("body : " + body);
		System.out.println("writer : " + writer);
		System.out.println("writerMemberNo : " + writerMemberNo);
		
		ReviewDTO newReview = new ReviewDTO();
		newReview .setTitle(title);
		newReview .setBody(body);
		newReview .setWriterMemberNo(writerMemberNo);
		
		/*썸네일 */
		if(ServletFileUpload.isMultipartContent(request)) {
		String rootLocation = getServletContext().getRealPath("/");
		int maxFileSize = 1024 * 1024 * 10;  //1024가 1mb 
		String encodingType = "UTF-8";
		
		String fileUploadDirectory = rootLocation + "/resources/upload/original/";
		String thumbnailDirectory = rootLocation + "/resources/upload/thumbnail/";
		
		File directory1 = new File(fileUploadDirectory);
		File directory2 = new File(thumbnailDirectory);
		
		if(!directory1.exists() || !directory2.exists()) {
			System.out.println("원본 저장 폴더 생성 : " + directory1.mkdirs());
			System.out.println("썸네일 저장 폴더 생성 : " + directory2.mkdirs());
		}
		
		Map<String, String> parameter = new HashMap<>();
		List<Map<String, String>> fileList = new ArrayList<>();
		
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		fileItemFactory.setRepository(new File(fileUploadDirectory));
		fileItemFactory.setSizeThreshold(maxFileSize);
		
		ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
		
		try {
			List<FileItem> fileItems = fileUpload.parseRequest(request);
			
			for(FileItem item : fileItems) {
				System.out.println(item);
			}				
			
			for(int i = 0; i < fileItems.size(); i++) {
				
				
				FileItem item = fileItems.get(i);
				
				if(!item.isFormField()) {
					
					if(item.getSize() > 0) {
						String fieldName = item.getFieldName();
						String originFileName = item.getName();
						
						int dot = originFileName.lastIndexOf(".");
						String ext = originFileName.substring(dot);
						
						String randomFileName = UUID.randomUUID().toString().replace("-", "") + ext;
						
						File storeFile = new File(fileUploadDirectory + randomFileName);
						
						item.write(storeFile);
						
						Map<String, String> fileMap = new HashMap<>();
						fileMap.put("fieldName", fieldName);
						fileMap.put("originFileName", originFileName);
						fileMap.put("savedFileName", randomFileName);
						fileMap.put("savePath", fileUploadDirectory);
						
						int width = 0;
						int height = 0;
						if("thumbnailImg1".equals(fieldName)) {
							fileMap.put("fileType", "TITLE");
							
							width = 350;
							height = 200;
						} else {
							fileMap.put("fileType", "BODY");
							
							width = 120;
							height = 100;
						}
						
						Thumbnails.of(fileUploadDirectory + randomFileName)
								.size(width, height)
								.toFile(thumbnailDirectory + "thumbnail_" +randomFileName);
						
						fileMap.put("thumbnailPath", "/resources/upload/thumbnail/thumbnail_" + randomFileName);
						
						fileList.add(fileMap);
						
					}
					
				} else {
					
					parameter.put(item.getFieldName(), new String(item.getString().getBytes("ISO-8859-1"), "UTF-8"));
					
				}
				
			}
			
			System.out.println("parameter : " + parameter);
			System.out.println("fileList : " + fileList);
			/*여기까지 컨트롤러*/
			
			
			ReviewDTO thumbnail = new ReviewDTO();
			thumbnail.setTitle(parameter.get("title"));
			thumbnail.setBody(parameter.get("body"));
			thumbnail.setWriterMemberNo(((MgDTO) request.getSession().getAttribute("loginMember")).getNo());
			System.out.println("system:" + thumbnail);
			thumbnail.setAttachmentList(new ArrayList<AttachmentDTO>());
			
			List<AttachmentDTO> list = thumbnail.getAttachmentList();
			for(int i = 0; i < fileList.size(); i++) {
				Map<String, String> file = fileList.get(i);
				
				AttachmentDTO tempFileInfo = new AttachmentDTO();
				tempFileInfo.setOriginalName(file.get("originFileName"));
				tempFileInfo.setSavedName(file.get("savedFileName"));
				tempFileInfo.setSavePath(file.get("savePath"));
				tempFileInfo.setFileType(file.get("fileType"));
				tempFileInfo.setThumbnailPath(file.get("thumbnailPath"));
				
				list.add(tempFileInfo);
			}
			
			int result = new ReviewService().insertReviewThumbnail(thumbnail);
			System.out.println("결과는");
			String path = "";
			if(result > 0) {
				System.out.println("성공");
				path = "/WEB-INF/views/main/success.jsp";
				request.setAttribute("successCode", "insertReviewThumbnail");
			} else {
				System.out.println("실패");
				path = "/WEB-INF/views/common/failed.jsp";
				request.setAttribute("message", "썸네일 게시판 등록 실패!");
			}
			
			request.getRequestDispatcher(path).forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace(); 
			
			int cnt = 0;
			for(int i = 0; i < fileList.size(); i++) {
				Map<String, String> file = fileList.get(i);
				 
				File deletedFile = new File(fileUploadDirectory + file.get("savedFileName"));
				boolean isDeleted = deletedFile.delete();
				
				if(isDeleted) {
					cnt++;
				}
			}
			
			if(cnt == fileList.size()) {
				System.out.println("업로드에 실패한 사진은 삭제함");
			} else {
				System.out.println("왜 사진 삭제가 실패한거지?");
			}
			
		}
		
			
	}
	}

}


