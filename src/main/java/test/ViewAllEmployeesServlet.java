package test;
import java.io.*;
import java.util.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewAllEmployeesServlet extends HttpServlet{
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		HttpSession hs = req.getSession(false);
		
		if(hs==null) {
			req.setAttribute("msg", "session Expired...<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
			
		}else {
			ArrayList<EmployeeBean> al = new ViewAllEmployeesDAO().retrieve();
			  hs.setAttribute("alist", al);
			  req.getRequestDispatcher("viewAllEmployees.jsp").forward(req, res);
			  
		}
    	
	}
}
