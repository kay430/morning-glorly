package com.jihunh.jsp.admin.controller.product;

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

import com.jihunh.jsp.admin.model.dto.MgAdDTO;
import com.jihunh.jsp.admin.model.product.model.dto.AttachmentDTO;
import com.jihunh.jsp.admin.model.product.model.dto.MgGoodsDTO;
import com.jihunh.jsp.admin.model.product.model.dto.MgGoodsTypeDTO;
import com.jihunh.jsp.admin.model.product.model.service.MgGoodsService;

import net.coobird.thumbnailator.Thumbnails;


@WebServlet("/admin/registProduct")
public class RegistProductServlet extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String path = "/WEB-INF/views/admin/registProduct.jsp";
      request.getRequestDispatcher(path).forward(request, response);
   }


   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


      if(ServletFileUpload.isMultipartContent(request)) {

         //web으로 root위치를 잡음
         String rootLocation = getServletContext().getRealPath("/");
         //파일 사이즈 크기 조정   
         int maxFileSize = 1024 * 1024 * 10;

         String encodingType = "UTF-8";


         //file 경로설정
         String fileUploadDirectory = rootLocation + "/resources/upload/original/";
         String thumbnailDirectory = rootLocation + "/resources/upload/thumbnail/";

         //위에 있는 파일경로가 현재 존재하지않으므로 아래 객체를 생성
         File directory1 = new File(fileUploadDirectory);
         File directory2 = new File(thumbnailDirectory);

         if(!directory1.exists() || !directory2.exists()) {
            //폴더생성
            System.out.println("원본저장폴더 생성 : "  + directory1.mkdirs());
            System.out.println("썸네일저장폴더 생성  : " + directory2.mkdirs());
         }

         //파일외에 다른걸 담기위해 MAP을 사용

         //body라는 키로 parameter로 전달받은 값을 넣어둘거다
         Map<String, String> parameter = new HashMap<>();
         //파일에대한 정보저장하고 아래는 key value방식으로 저장할거다 . 파일이여러개면 List방식으로 저장
         List<Map<String, String>> fileList = new ArrayList<>();

         //실제저장을 할수 있는 그 설정을 위한 인스턴스 생성
         DiskFileItemFactory   fileItemFactory = new DiskFileItemFactory();
         fileItemFactory.setRepository(new File(fileUploadDirectory));
         fileItemFactory.setSizeThreshold(maxFileSize);

         //위에걸 근거로 서블릿 파일 업로드라는 인스턴스르 생성
         ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);

         try {
            List<FileItem> fileItems = fileUpload.parseRequest(request);

            for(FileItem item : fileItems) {
               System.out.println("item : " + item);
            }
            for(int i = 0; i<fileItems.size(); i++) {

               FileItem item = fileItems.get(i);

               if(!item.isFormField()) {

                  //파일이 들어오면 0보다 크기떄문에 파일이들어올떄만 처리
                  if(item.getSize() > 0 ) {
                     String fieldName = item.getFieldName();
                     String originFileName = item.getName();

                     //파일원본이름을 그대로저장하지않고 파일이름을 변환해야한다. 
                     // 확장자를 뗴고 변환하고 다시확장자를 붙여준다 즉 확장자 분리를 먼저하자

                     int dot = originFileName.lastIndexOf(".");
                     String ext = originFileName.substring(dot);

                     String randomFileName = UUID.randomUUID().toString().replace("-", "") + ext ;

                     File storeFile = new File(fileUploadDirectory + randomFileName);

                     item.write(storeFile);

                     Map<String, String> fileMap = new HashMap<>();
                     fileMap.put("fieldName", fieldName);
                     fileMap.put("originFileName", originFileName);
                     fileMap.put("savedFileName", randomFileName);
                     fileMap.put("savePath" , fileUploadDirectory);

                     int width = 0;
                     int height = 0;
                     if("thumbnailImg1".equals(fieldName)) {
                        fileMap.put("fileType", "TITLE");

                        width = 350;
                        height = 200;
                     }else {
                        fileMap.put("fileType", "BODY");

                        width = 120;
                        height = 100;

                     }
                     Thumbnails.of(fileUploadDirectory + randomFileName)
                     .size(width, height)
                     .toFile(thumbnailDirectory + "thumbnail_" + randomFileName);

                     fileMap.put("thumbnailPath", "/resources/upload/thumbnail/thumbnail_" + randomFileName);

                     fileList.add(fileMap);


                  } 
               } else {

                  parameter.put(item.getFieldName(), new String(item.getString().getBytes("ISO-8859-1"), "UTF-8"));

               }

            }

            System.out.println("parameter : " + parameter);
            System.out.println("fileList : " + fileList);

            MgGoodsDTO thumbnail = new MgGoodsDTO();
            thumbnail.setName(parameter.get("productType"));
            thumbnail.setGoodsTypeNo(new MgGoodsTypeDTO());
               thumbnail.getGoodsTypeNo().setNo(Integer.parseInt(parameter.get("productCode")));
            thumbnail.setName(parameter.get("productName"));
            thumbnail.setPrice(Integer.parseInt(parameter.get("price")));
         //   thumbnail.setCreatedDate(java.sql.Date.valueOf(parameter.get("registDate")));
         //   thumbnail.setStatus(parameter.get("status"));
               thumbnail.setWriterMemberNo(((MgAdDTO) request.getSession().getAttribute("loginMember")).getNo());

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

            int result = new MgGoodsService().insertThumbnail(thumbnail);

            String path = "";
            if(result > 0) {
               path = "/WEB-INF/views/main/success.jsp";
               request.setAttribute("successCode", "insertThumbnail");
            } else {
               path = "/WEB-INF/views/main/failed.jsp";
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

   


   

/*   else {
                     //parameter값이 getFieldName의 키값이된다
                     parameter.put(item.getFieldName(), new String(item.getString().getBytes("ISO-8859-1"), "UTF-8"));
                  }
               }
               System.out.println("parameter : " + parameter);
               System.out.println("fileList : " +  fileList);

               MgGoodsDTO thumbnail = new MgGoodsDTO();
               thumbnail.setWriterMemberNo(((MgAdDTO) request.getSession().getAttribute("loginMember")).getNo());

               for(int i =0 ; i < fileList.size(); i++) {
                  Map



            } catch (FileUploadException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            } catch (Exception e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }



         }
         //      String producyType = request.getParameter("productType");
         //      String productCode = request.getParameter("productCode");
         //      String productName = request.getParameter("productName");
         //      int price = Integer.parseInt(request.getParameter("price"));
         //       Date registDate = java.sql.Date.valueOf(request.getParameter("registDate"));
         //       String status = request.getParameter("status");


         doGet(request, response);
   }
 */


            //            thumbnail.setAttachmentList(new ArrayList<AttachmentDTO>());
//            List<AttachmentDTO> list = thumbnail.getAttachmentList();
//            for(int i = 0; i < fileList.size(); i++) {
//               Map<String, String> file = fileList.get(i);
//
//               AttachmentDTO tempFileInfo = new AttachmentDTO();
//               tempFileInfo.setOriginalName(file.get("originFileName"));
//               tempFileInfo.setSavedName(file.get("savedFileName"));
//               tempFileInfo.setSavePath(file.get("savePath"));
//               tempFileInfo.setFileType(file.get("fileType"));
//               tempFileInfo.setThumbnailPath(file.get("thumbnailPath"));
//
//               list.add(tempFileInfo);
//            }
//
//            int result = new MgGoodsService().insertThumbnail(thumbnail);
//
//            String path = "";
//            if(result > 0) {
//               path = "/WEB-INF/views/common/success.jsp";
//               request.setAttribute("successCode", "insertThumbnail");
//            } else {
//               path = "/WEB-INF/views/common/failed.jsp";
//               request.setAttribute("message", "썸네일 게시판 등록 실패!");
//            }
//
//            request.getRequestDispatcher(path).forward(request, response);
//
//         } catch (Exception e) {
//            e.printStackTrace();
//
//            int cnt = 0;
//            for(int i = 0; i < fileList.size(); i++) {
//               Map<String, String> file = fileList.get(i);
//
//               File deletedFile = new File(fileUploadDirectory + file.get("savedFileName"));
//               boolean isDeleted = deletedFile.delete();
//
//               if(isDeleted) {
//                  cnt++;
//               }
//            }
//
//            if(cnt == fileList.size()) {
//               System.out.println("업로드에 실패한 사진 모두 삭제 완료!");
//            } else {
//               System.out.println("사진 삭제 실패!");
//            }
//         }
//
//
//      }

//   }

//}
/*   else {
                     //parameter값이 getFieldName의 키값이된다
                     parameter.put(item.getFieldName(), new String(item.getString().getBytes("ISO-8859-1"), "UTF-8"));
                  }
               }
               System.out.println("parameter : " + parameter);
               System.out.println("fileList : " +  fileList);

               MgGoodsDTO thumbnail = new MgGoodsDTO();
               thumbnail.setWriterMemberNo(((MgAdDTO) request.getSession().getAttribute("loginMember")).getNo());

               for(int i =0 ; i < fileList.size(); i++) {
                  Map



            } catch (FileUploadException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            } catch (Exception e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }



         }
         //      String producyType = request.getParameter("productType");
         //      String productCode = request.getParameter("productCode");
         //      String productName = request.getParameter("productName");
         //      int price = Integer.parseInt(request.getParameter("price"));
         //       Date registDate = java.sql.Date.valueOf(request.getParameter("registDate"));
         //       String status = request.getParameter("status");


         doGet(request, response);
   }
 */

