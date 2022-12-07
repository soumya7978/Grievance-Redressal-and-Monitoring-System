

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


@WebServlet("/AddStaff")
public class AddStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String department=request.getParameter("department");
		
		String mobile=request.getParameter("mobile");
		
		String password=request.getParameter("password");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			
			PreparedStatement ps=con.prepareStatement("insert into PSTAFF values(?,?,?,?,?)");
			
			ps.setString(1,id);
			ps.setString(2,department);
			ps.setString(3,name);
			
		
			ps.setString(4,mobile);
			ps.setString(5,password);
			
			int i=ps.executeUpdate();
			if(i>0) {
				
//				out.println("<html><head></head><body onload=\"alert('Successfully Added')\"></body></html>");
				//out.println("");
				RequestDispatcher rd=request.getRequestDispatcher("Admin2.html");
				rd.include(request, response);
			}
			
			
           if(i==0) {
				
				//out.println("<html><head></head><body onload=\"alert('Error')\"></body></html>");
				out.println("UnSuccessful");
				RequestDispatcher rd=request.getRequestDispatcher("Admin.html");
				rd.include(request, response);
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
