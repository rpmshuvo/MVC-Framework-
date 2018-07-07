package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import framework.DomParser;
import framework.iModel;
/**
 * class des
 * 
 * @author rpm shuvo
 * @version 1.0
 */
public class Login extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("username") != null && req.getParameter("password") != null) {
			if (!req.getParameter("username").equals("") && !req.getParameter("password").equals("")) {
				try {
					iModel model = (iModel) Class.forName(new DomParser().RequestForModel(req)).getConstructor().newInstance();
					ArrayList<?> data = (ArrayList<?>) model.getData();
					
					for(int i=0; i<data.size(); i+=3) {
						if (req.getParameter("username").equals(data.get(i+1)) && req.getParameter("password").equals(data.get(i+2))) {
							req.getSession().setAttribute("loginuser", req.getParameter("username"));
							resp.sendRedirect("home");
							return;
						}
					}
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
			req.getRequestDispatcher(new DomParser().RequestForView(req)).forward(req, resp);
			return;
		}
		req.getRequestDispatcher(new DomParser().RequestForView(req)).forward(req, resp);
		return ;
				
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
