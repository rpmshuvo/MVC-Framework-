package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import framework.DomParser;

public class Registration extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//resp.getWriter().println("write reg");
		//System.out.println("registration controller");
		
		req.getRequestDispatcher(new DomParser().RequestForView(req)).forward(req, resp);
		//resp.sendRedirect(new DomParser().RequestForView(req));
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
