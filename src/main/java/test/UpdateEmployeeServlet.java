package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateEmployeeServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) 
			              throws ServletException, IOException{
		HttpSession hs= req.getSession();
		if(hs==null) {
			req.setAttribute("msg", "session Expired....");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
			@SuppressWarnings("unchecked")
			ArrayList<EmployeeBean>al = (ArrayList<EmployeeBean>)hs.getAttribute("alist");
			String eId= req.getParameter("eId");
			Iterator<EmployeeBean> it =al.iterator();
			while(it.hasNext()) {
				EmployeeBean eb = (EmployeeBean)it.next();
				if(eId.equals(eb.geteId())) {
					int bsal=Integer.parseInt(req.getParameter("bsal"));
					float hra = 0.78F*bsal;
					float da= 0.61F*bsal;
					float totSal = bsal+ hra+da;
					eb.setbSal(bsal);
					eb.setHra(hra);
					eb.setDa(da);
					eb.setTotSal(totSal);
					int k = new UpdateEmployeeDAO().update(eb);
					if(k>0) {
						req.setAttribute("msg", "Employee update sucessfully....<br>");
						req.getRequestDispatcher("UpdateEmployee.jsp.").forward(req,res);
					}// end of if
			
					break;
					
				}// end of if
				
			}// end of While loop 
			
		}
		
	}

}
