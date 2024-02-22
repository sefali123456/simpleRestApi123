package com.zumba.controller;

import com.zumba.bean.batch;
import com.zumba.service.BatchService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/BatchController")
public class BatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      BatchService bs= new BatchService(); 
    
    public BatchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter pw = response.getWriter();
		List<Object[]> listOfBatchAndStudentInfo = bs.findBatchAndStudentInfo();
		HttpSession hs = request.getSession();
		hs.setAttribute("listBP", listOfBatchAndStudentInfo);
		response.sendRedirect("BatchAndParticipantsInfo.jsp");
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter pw = response.getWriter();
		
		String operation = request.getParameter("operation");
		if(operation.equals("store")) {
		int batchid = Integer.parseInt(request.getParameter("batchid"));
		String typeofbatch = request.getParameter("typeofbatch");
		String time = request.getParameter("time");
		
		batch batch = new batch(batchid, typeofbatch, time);
		String result = bs.storeBatch(batch);
		pw.println(result);
		RequestDispatcher rd = request.getRequestDispatcher("addBatch.jsp");
		rd.include(request, response);
		}else if(operation.equals("update")) {
			int id = Integer.parseInt(request.getParameter("batchid"));
			
			String Typeofbatch = request.getParameter("typeofbatch");
			batch batch = new batch();
			batch.setBatchid(id);
			
			batch.setTypeofbatch(Typeofbatch);
			
			// Then we can pass those value to service layer and base upon service layer result we can move to next view page. 
			BatchService es = new BatchService();
			String result = es.updateBatch(batch);
			pw.println(result);
			
			RequestDispatcher rd = request.getRequestDispatcher("updateBatch.jsp");
			rd.include(request, response);
			
			
		}else if(operation.equals("delete")) {
			int id = Integer.parseInt(request.getParameter("batchid"));
			
			// Then we can pass those value to service layer and base upon service layer result we can move to next view page. 
			BatchService es = new BatchService();
			String result = es.deleteBatch(id);
			pw.println(result);
			
			RequestDispatcher rd = request.getRequestDispatcher("deleteBatch.jsp");
			rd.include(request, response);
			
		}else {
			pw.println("Wrong operation");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
		response.setContentType("text/html");
	}

}
