
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
import javax.servlet.http.HttpSession;


@WebServlet("/ModifyStudent")

public class ModifyStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Connection con ;
		
		String roll=request.getParameter("roll");
		//id=request.setAttribute("id", id);
		out.println("<html><body>");
		
		HttpSession session = request.getSession();
		session.setAttribute("updateroll", roll);
		System.out.println("session - "+session.toString());
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");			
			PreparedStatement ps=con.prepareStatement("select *from pstudent where ROLLNO=?");
			
			
			ps.setString(1,roll);
			//int i=ps.executeUpdate();
			
			ResultSet rs=ps.executeQuery();
			
//header
		    
		    out.println("<html>");
			out.println("<head>");
			out.println("<style>body {margin: 0;font-family: Arial, Helvetica, sans-serif;}.topnav {overflow: hidden;background-color: #333;}.topnav a {float: left;color: #f2f2f2;text-align: center;padding: 14px 16px;text-decoration: none;font-size: 17px;}.topnav a:hover {background-color: #ddd;color: black;}.topnav a.active {background-color: #04AA6D;color: white;}");
			out.println("</style>") ;
			out.println("<link rel=\"stylesheet\" href=\"style.css\" />");
		    out.println("<title>HP</title>");
			out.println("</head>");
			out.println("<body>");
			
			out.println("<div class=\"before-nav\">");
		      out.println("<img id=\"university-logo-top\" src=\"images/imgbin_utkal-university.png\" alt=\"UU\" />");
		      out.println("<div class=\"unv-name\">");
		        out.println("<h2>fakir mohan chhatrabas</h2>");
		        out.println("<h3>gent's hostel - 03</h3> <p>\r\n" + 
		        		"					          utkal university, vani vihar, <br />\r\n" + 
		        		"					          bhubaneswar, pin-751004\r\n" + 
		        		"					        </p>\r\n" + 
		        		"					      </div>\r\n" + 
		        		"					    </div>");
		        
			
			out.println("<div class=\"topnav\"><a class=\"active\" href=\"index.html\">Home"
					+ "</a><a href=\"index.html#about\">About</a><a href=\"index.html#contact\">Contact</a>"
					+ "<a href=\"Sup_login.html\">LOGOUT</a></div><div style=\"padding-left:16px\">");
			
			out.println("</div><br><br>");
		    
		    //header end
			
			out.println(" <center><table border=2 width=50% height=20%");
			out.println("<tr><th>ROLLNO</th><th>NAME</th><th>DEPT</th><th>PERIOD</th><th>ROOMNO</th><th>CONTACT</th><th>PASSWORD</th>");
			
			while(rs.next()) {
				
				String rollc=rs.getString(1);
				String name=rs.getString(2);
				String dept=rs.getString(3);
				String period=rs.getString(4);
				int roomno=rs.getInt(5);
				String mobile=rs.getString(6);
				String password=rs.getString(7);
				
				
				out.println("<tr><td>"+rollc+"</td><td>"+name+"</td><td>"+dept+"</td><td>"+period+"</td><td>"+roomno+"</td><td>"+mobile+"</td><td>"+password+"</td></tr>");
				
			}
			out.println("</center></table>");
			
			out.println("<br>");
			out.println("<br>");
			out.println("<br>");
			
			out.println("<form action='ModifyStudent2' method='get'>");
			out.println("<input type='text' name='name' placeholder='FULL NAME' <br>");
			out.println("<br>");
			out.println("<select name='department' >");
			out.println("<option>--SELECT DEPARTMENT--</option>");
			out.println("<option value='MCA'>MCA</option>");
			out.println("<option value='IMCA'>IMCA</option>");
			out.println("<option value='CS'>CS</option>");
			out.println("<option value='ODIA'>ODIA</option>");
			out.println("<option value='HISTORY'>HISTORY</option>");
			out.println("<option value='SANSKRIT'>SANSKRIT</option>");
			out.println("<option value='ECO'>ECO</option>");
			out.println("<option value='ZOOLOGY'>ZOOLOGY</option>");
			out.println("<option value='ENGLISH'>ENGLISH</option>");

          out.println("</select>");
			
			
			out.println("<br>");
			
			out.println("<input type='text' name='period' placeholder='PERIOD' <br>  ");
			out.println("<br>");
			out.println("<input type='text' name='roomno' placeholder='ROOMNO' <br>  ");
			out.println("<br>");
			out.println("<input type='text' name='mobile' placeholder='MOBILE NUMBER' <br> ");
			out.println("<br>");
			out.println("<input type='text' name='password' placeholder='PASSWORD' <br>");
			out.println("<br>");
			out.println("<br>");
			out.println("<br>");
			

			
			out.println("<input type='submit' value='UPDATE' />");
			out.println("</form");
			
			out.println("<br><br>");
			
			out.println("<form action='Modify_student1.html' method='get'>");
			out.println("<input type='submit' value='BACK' >");
			out.println("</form>");
			
			out.println("<br><br>");
			
			out.println("<form action='Admin_login.html' method='get'>");
			out.println("<input type='submit' value='LOGOUT' >");
			out.println("</form>");
			
			out.println("<br><br>");
			
			out.println("<form action='index.html' method='get'>");
			out.println("<input type='submit' value='HOME' >");
			out.println("</form");
 
//			out.println("</table>");
			out.println("</body></html>");
			
			
			
		}
		catch(Exception e) {
			System.out.println("error");
			
		}
		
	}

}
