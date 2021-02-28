package com.mg.jsp.question.controller;

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

import com.mg.jsp.member.model.dto.MgDTO;
import com.mg.jsp.question.model.dto.AttaQuestionDTO;
import com.mg.jsp.question.model.dto.QuestionDTO;
import com.mg.jsp.question.model.service.QuestionService;

import net.coobird.thumbnailator.Thumbnails;


@WebServlet("/question/insert")
public class QuestionInsertServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/customerservice/qnainsert.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		System.out.println("여기");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			if(ServletFileUpload.isMultipartContent(request)) {
			
			String rootLocation = getServletContext().getRealPath("/");
			int maxFileSize = 1024 * 1024 * 10;
			String encodingType = "UTF-8";
			
			String fileUploadDirectory = rootLocation + "/resources/upload/original/";
			String thumbnailDirectory = rootLocation + "/resources/upload/thumbnail/";
			
			File directory1 = new File(fileUploadDirectory);
			File directory2 = new File(thumbnailDirectory);
			
			System.out.println("=======================================================================================" + directory1);
			
			if(!directory1.exists() || !directory2.exists()) {
				System.out.println("원본 저장 폴더 생성 : " + directory1.mkdirs());
				System.out.println("썸네일 저장 폴더 생성 : " + directory2.mkdirs());
			}

			Map<String, String> parameter = new HashMap<>();
			List<Map<String, String>> fileList = new ArrayList<>();
			
			DiskFileItemFactory queFileItemFactory = new DiskFileItemFactory();
			queFileItemFactory.setRepository(new File(fileUploadDirectory));
			queFileItemFactory.setSizeThreshold(maxFileSize);
			
			ServletFileUpload fileUpload = new ServletFileUpload(queFileItemFactory);
			
			try {
				List<FileItem> fileItems = fileUpload.parseRequest(request);
				
				for(FileItem item : fileItems) {
					System.out.println("업로드한거 확인" + item);
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
							if("QuethumbnailImg1".equals(fieldName)) {
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
				
				QuestionDTO thumbnail = new QuestionDTO();
//				thumbnail.setMgDTO(new MgDTO());
//				thumbnail.getMgDTO().setName(parameter.get("loginMember"));
//				thumbnail.setNo(Integer.parseInt(parameter.get("no")));
//				thumbnail.getMgDTO().setName(((MgDTO) request.getSession().getAttribute("loginMember")).getName());
				thumbnail.setTitle(parameter.get("title"));
				thumbnail.setBody(parameter.get("body"));
				thumbnail.setCategoryCode(Integer.parseInt((parameter.get("qnaCode"))));
				thumbnail.setWriterMemberNo(((MgDTO) request.getSession().getAttribute("loginMember")).getNo());
				
				System.out.println(thumbnail);
				
				      
				thumbnail.setAttaQueList(new ArrayList<AttaQuestionDTO>());
				List<AttaQuestionDTO> list = thumbnail.getAttaQueList();
				for(int i = 0; i < fileList.size(); i++) {
					Map<String, String> file = fileList.get(i);
					
					AttaQuestionDTO tempFileInfo = new AttaQuestionDTO();
					tempFileInfo.setOriginalName(file.get("originFileName"));
					tempFileInfo.setSavedName(file.get("savedFileName"));
					tempFileInfo.setSavedPath(file.get("savePath"));
					tempFileInfo.setFileType(file.get("fileType"));	
					tempFileInfo.setThumbnailPath(file.get("thumbnailPath"));
					
					list.add(tempFileInfo);
				} 
				
				int result = new QuestionService().insertThumbnail(thumbnail);
				System.out.println("list : " + list);
				System.out.println("result "  + result);
				String path = "";
				if(result > 0) {
					path = "/WEB-INF/views/main/success.jsp";
					request.setAttribute("successCode", "insertQueThumbnail");
				} else {
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
					System.out.println("업로드에 실패한 사진 모두 삭제 완료!");
				} else {
					System.out.println("사진 삭제 실패!");
				}
			}
			
			
		}
		
	}

}

	

