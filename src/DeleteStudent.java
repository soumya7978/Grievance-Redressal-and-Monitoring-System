
import java.sql.*;
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


@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection con ;
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String roll=request.getParameter("roll");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			
			PreparedStatement ps=con.prepareStatement("delete from pstudent where ROLLNO=?");
			
			ps.setString(1, roll);
			int i=ps.executeUpdate();
			if(i>0) {
				//out.print("Successfully Issue Raised");
				//out.println("<html><head></head><body onload=\"alert('Successfully Deleted')\"></body></html>");
//				out.println("Successful...");
				RequestDispatcher rd=request.getRequestDispatcher("Admin2.html");
				rd.include(request, response);
			}
			else {
				out.println("Error...");
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
	}

}
