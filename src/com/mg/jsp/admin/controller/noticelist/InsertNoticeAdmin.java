package com.mg.jsp.admin.controller.noticelist;

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

import com.mg.jsp.admin.model.dto.AttaNoticeDTO;
import com.mg.jsp.admin.model.dto.MgAdDTO;
import com.mg.jsp.admin.model.dto.NoticeDTO;
import com.mg.jsp.admin.model.service.NoticeService;

import net.coobird.thumbnailator.Thumbnails;

@WebServlet("/admin/notice/insert")
public class InsertNoticeAdmin extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = "/WEB-INF/views/admin/insertNotice.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(ServletFileUpload.isMultipartContent(request)) {

			String rootLocation = getServletContext().getRealPath("/");
			int maxFileSize = 1024 * 1024 * 10;
			String encodingType = "UTF-8";

			String fileUploadDirectory = rootLocation + "/resources/upload/admin/original/";
			String thumbnailDirectory = rootLocation + "/resources/upload/admin/thumbnail/";

			File directory1 = new File(fileUploadDirectory);
			File directory2 = new File(thumbnailDirectory);

			if(!directory1.exists() || !directory2.exists()) {
				System.out.println("원본 저장 폴더 만듬 : " + directory1.mkdirs());
				System.out.println("썸네일 저장 폴더 생성 : " + directory2.mkdirs());
			}

			Map<String, String> parameter = new HashMap<>();
			List<Map<String, String>> fileList = new ArrayList<>();

			DiskFileItemFactory noticeFileItemFactory = new DiskFileItemFactory();
			noticeFileItemFactory.setRepository(new File(fileUploadDirectory));
			noticeFileItemFactory.setSizeThreshold(maxFileSize);

			ServletFileUpload noticeFileUpload = new ServletFileUpload(noticeFileItemFactory);

			try {
				List<FileItem> fileItems = noticeFileUpload.parseRequest(request);

				for(FileItem item : fileItems) {
					System.out.println("이건 내가 업로드한거 가져온듯 : " + item);
				}

				for(int i = 0; i < fileItems.size(); i++) {

					FileItem item = fileItems.get(i);
					System.out.println(("이게 뭐냐 item : " + item));

					if(!item.isFormField()) {

						if(item.getSize() > 0) {
							String fieldName = item.getFieldName();
							String originalFileName = item.getName();
							
							System.out.println(fieldName);
							System.out.println(originalFileName);
							

							int dot = originalFileName.lastIndexOf(".");
							String dron = originalFileName.substring(dot);

							String raraFileName = UUID.randomUUID().toString().replace("-", "") + dron;

							File createFile = new File(fileUploadDirectory + raraFileName);

							item.write(createFile);

							Map<String, String> fileMap = new HashMap<>();
							fileMap.put("fieldName", fieldName);
							fileMap.put("originalFileName", originalFileName);
							fileMap.put("savedFileName", raraFileName);
							fileMap.put("savePath", fileUploadDirectory);

							int width = 0;
							int height = 0;
							if("thumbnailImg1".equals(fieldName)) {
								fileMap.put("fileType", "TITLE");	//1빠라고 썸네일 이미지 설정해준듯

								width = 350;
								height = 200;
							}

							Thumbnails.of(fileUploadDirectory + raraFileName)
							.forceSize(width,  height)
							.toFile(thumbnailDirectory + "thumbnail_" + raraFileName);

							fileMap.put("thumbnailPath", "/resources/upload/admin/thumbnail/thumbnail_" + raraFileName);

							fileList.add(fileMap);

						}

					} else {

						parameter.put(item.getFieldName(), new String(item.getString().getBytes("ISO-8859-1"), "UTF-8"));

					}
				}

				System.out.println("파라미터 : " + parameter);
				System.out.println("파일리스트 : " + fileList);

				NoticeDTO thumbnail = new NoticeDTO();
				thumbnail.setTitle(parameter.get("title"));
				thumbnail.setBody(parameter.get("body"));
				thumbnail.setWriterMemberNo(((MgAdDTO) request.getSession().getAttribute("loginMember")).getNo());

				thumbnail.setAttaNotiList(new ArrayList<AttaNoticeDTO>());
				List<AttaNoticeDTO> list = thumbnail.getAttaNotiList();
				for(int i = 0; i < fileList.size(); i++) {
					Map<String, String> file = fileList.get(i);
					
					AttaNoticeDTO tempFileInfo = new AttaNoticeDTO();
					tempFileInfo.setOriginalName(file.get("originalFileName"));
					tempFileInfo.setSavedName(file.get("savedFileName"));
					tempFileInfo.setSavePath(file.get("savePath"));
					tempFileInfo.setFileType(file.get("fileType"));
					tempFileInfo.setThumbnailPath(file.get("thumbnailPath"));
					
					list.add(tempFileInfo);
				}
				
				int result = new NoticeService().insertThumbnail(thumbnail);
				
				String path = "";
				if(result > 0) {
					path = "/WEB-INF/views/common/admin/successAd.jsp";
					request.setAttribute("successCode", "insertNotice");
				} else {
					path = "/WEB-INF/views/common/admin/failedAd.jsp";
					request.setAttribute("message", "썸네일 등록 실패함");
					
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



























		/* 기존 인서트 공지사항. */
		//		String title = request.getParameter("title");
		//		String body = request.getParameter("body");
		//		String writer = request.getParameter("writer");
		//		int writerMemberNo = ((MgAdDTO) request.getSession().getAttribute("loginMember")).getNo();
		//		
		//		System.out.println("title : " + title);
		//		System.out.println("body : " + body);
		//		System.out.println("writer : " + writer);
		//		System.out.println("writerMemberNo : " + writerMemberNo);
		//		
		//		NoticeDTO newNotice = new NoticeDTO();
		//		newNotice.setTitle(title);
		//		newNotice.setBody(body);
		//		newNotice.setWriterMemberNo(writerMemberNo);
		//		
		//		int result = new NoticeService().insertNotice(newNotice);
		//		System.out.println("내용좀 보자 : " + newNotice);
		//		String path = "";
		//		if(result > 0) {
		//			path = "/WEB-INF/views/common/admin/successAd.jsp";
		//			request.setAttribute("successCode", "insertNotice");
		//		} else {
		//			path = "/WEB-INF/views/common/failed.jsp";
		//			request.setAttribute("message", "공지사항 등록에 실패하셨습니다.");
		//		}
		//		
		//		request.getRequestDispatcher(path).forward(request, response);

	}

}
