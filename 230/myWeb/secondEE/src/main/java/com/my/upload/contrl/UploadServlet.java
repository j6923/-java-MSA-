package com.my.upload.contrl;

import java.io.IOException;
import java.util.Collection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String saveDirecory="c:\\files";
//		DiskFileItemFactory fileItemFactory  = new DiskFileItemFactory();
		String saveDirectory = "c:\\files";
   		try {
//   		    Part part = request.getPart("f");
//   		   	String fileName = part.getSubmittedFileName();
//   		   	System.out.println(fileName);
//		    part.write(saveDirectory+"\\" + fileName);
		    Collection<Part> parts=request.getParts();
		    for(Part part:parts) {
		    	if("f".equals(part.getName())) {
		    		String fileName= part.getSubmittedFileName();
		    		System.out.println(fileName);
		    	}
		    }
   		       		    
   		} catch (Exception e) {
   		    e.printStackTrace();
   		}

	}

}
