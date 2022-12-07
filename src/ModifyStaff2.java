

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ModifyStaff2
 */
@WebServlet("/ModifyStaff2")
public class ModifyStaff2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		//String id=request.getParameter("id");
		String dept=request.getParameter("department");
		String name=request.getParameter("name");
		
		
		String mobile=request.getParameter("mobile");
		
		String password=request.getParameter("password");
		
		try {
			
			String updateId = (String) session.getAttribute("updateId");
			System.out.println("updateId - "+updateId);
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			
			PreparedStatement ps=con.prepareStatement("update pstaff set ID=?,DEPT=?,NAME=?,CONTACT=?,PASSWORD=? where ID='"+updateId+"'");
			
			ps.setString(1,updateId);
			ps.setString(2,dept);
			ps.setString(3,name);
			
			
			ps.setString(4,mobile);
			ps.setString(5,password);
		
			int i=ps.executeUpdate();
			if(i>0) {
				
				//out.println("<html><head></head><body onload=\"alert('Successfully Added')\"></body></html>");
				//out.println("successful");
				RequestDispatcher rd=request.getRequestDispatcher("Admin2.html");
				rd.include(request, response);
			}
			
			
           if(i==0) {
				
			//	out.println("<html><head></head><body onload=\"alert('Error')\"></body></html>");
				out.println("error");
				//RequestDispatcher rd=request.getRequestDispatcher("Admin.html");
				//rd.include(request, response);
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		
	}

}
