package test;

import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditEmployeeServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "session expired....<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);

		} else {

			@SuppressWarnings("unchecked")
			ArrayList<EmployeeBean> al = (ArrayList<EmployeeBean>) hs.getAttribute("alist");

			String eId = req.getParameter("eid");
			Iterator<EmployeeBean> it = al.iterator();

			while (it.hasNext()) {
				EmployeeBean eb = (EmployeeBean) it.next();
				if (eId.equals(eb.geteId())) {
					req.setAttribute("ebean", eb);
					req.getRequestDispatcher("EditEmployee.jsp").forward(req, res);
					break;
					
				} // end of elseif

			} // end of loop
		}

	}

}
