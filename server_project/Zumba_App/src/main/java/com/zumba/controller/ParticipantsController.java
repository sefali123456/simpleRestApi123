package com.zumba.controller;

import com.zumba.bean.batch;
import com.zumba.bean.participants;
import com.zumba.service.BatchService;
import com.zumba.service.ParticipantsService;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;
import java.util.List;


@WebServlet("/ParticipantsController")
public class ParticipantsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    ParticipantsService ps = new ParticipantsService();
    BatchService bs = new BatchService();
    public ParticipantsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter pw= response.getWriter();
		List<batch> listOfBatc = bs.findAllBatch();
		HttpSession hs = request.getSession();
		hs.setAttribute("listOfBatch", listOfBatc);
		response.sendRedirect("addParticipants.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String operation = request.getParameter("operation");
		if(operation.equals("add")) {
			String pname = request.getParameter("pname");
			int age = Integer.parseInt(request.getParameter("age"));
			String phonenumber = request.getParameter("phonenumber");
			int batchid = Integer.parseInt(request.getParameter("batchid"));
			participants pp = new participants();
			pp.setPname(pname);
			pp.setAge(age);
			pp.setPhonenumber(phonenumber);
			pp.setBatchid(batchid);
			String result = ps.storeParticipant(pp);
			pw.println(result);
			RequestDispatcher rd = request.getRequestDispatcher("addParticipants.jsp");
			rd.include(request, response);
		}else if(operation.equals("update")) {
			int id = Integer.parseInt(request.getParameter("participantid"));
			
			int age = Integer.parseInt(request.getParameter("age"));
			participants pp = new participants();
			pp.setParticipantid(id);
			
			pp.setAge(age);
			
			// Then we can pass those value to service layer and base upon service layer result we can move to next view page. 
			ParticipantsService es = new ParticipantsService();
			String result = es.updateParticipant(pp);
			pw.println(result);
			
			RequestDispatcher rd = request.getRequestDispatcher("updateParticipant.jsp");
			rd.include(request, response);
			
			
		}else if(operation.equals("delete")) {
			int id = Integer.parseInt(request.getParameter("participantid"));
			
			// Then we can pass those value to service layer and base upon service layer result we can move to next view page. 
			ParticipantsService es = new ParticipantsService();
			String result = es.deleteParticipant(id);
			pw.println(result);
			
			RequestDispatcher rd = request.getRequestDispatcher("deleteParticipant.jsp");
			rd.include(request, response);
			
		}else {
			pw.println("Wrong operation");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
		response.setContentType("text/html");
	}

}
