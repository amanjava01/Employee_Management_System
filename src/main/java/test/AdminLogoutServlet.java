package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/logout")
public class AdminLogoutServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg","Session Expired....<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
			hs.removeAttribute("abean");
			hs.removeAttribute("alist");
			hs.invalidate();
			req.setAttribute("msg", "Admin loggedout Successfully....<br>");
			req.getRequestDispatcher("AdminLogout.jsp").forward(req, res);
		}
		
	}
	

}
