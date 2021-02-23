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

   }
}