
	import java.io.*;  
	import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.*;  
	import javax.servlet.http.*;

import java.util.*;
import java.util.Date;
	
	  
	public class ViewIssue extends HttpServlet
	{
	    public void doGet(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException 
			{  
			 response.setContentType("text/html");  
	         PrintWriter pw = response.getWriter();  
	         Connection con;
	         Statement st;
			 
			 try
			 {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
			   con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			   st = con.createStatement(); 
			   ResultSet rs = null;
			   String roll ;
			   
			 
				    rs = st.executeQuery("select * from pissue");
				    
				    //header
				    
				    pw.println("<html>");
					pw.println("<head>");
					pw.println("<style>body {margin: 0;font-family: Arial, Helvetica, sans-serif;}.topnav {overflow: hidden;background-color: #333;}.topnav a {float: left;color: #f2f2f2;text-align: center;padding: 14px 16px;text-decoration: none;font-size: 17px;}.topnav a:hover {background-color: #ddd;color: black;}.topnav a.active {background-color: #04AA6D;color: white;}");
					pw.println("</style>") ;
					pw.println("<link rel=\"stylesheet\" href=\"style.css\" />");
				    pw.println("<title>HP</title>");
					pw.println("</head>");
					pw.println("<body>");
					
					pw.println("<div class=\"before-nav\">");
				      pw.println("<img id=\"university-logo-top\" src=\"images/imgbin_utkal-university.png\" alt=\"UU\" />");
				      pw.println("<div class=\"unv-name\">");
				        pw.println("<h2>fakir mohan chhatrabas</h2>");
				        pw.println("<h3>gent's hostel - 03</h3> <p>\r\n" + 
				        		"					          utkal university, vani vihar, <br />\r\n" + 
				        		"					          bhubaneswar, pin-751004\r\n" + 
				        		"					        </p>\r\n" + 
				        		"					      </div>\r\n" + 
				        		"					    </div>");
				        
					
					pw.println("<div class=\"topnav\"><a class=\"active\" href=\"index.html\">Home"
							+ "</a><a href=\"index.html#about\">About</a><a href=\"index.html#contact\">Contact</a>"
							+ "<a href=\"Sup_login.html\">LOGOUT</a></div><div style=\"padding-left:16px\">");
					
					pw.println("</div><br><br>");
				    
				    //header end
				    
			pw.println("<html><body><center><table border='5' width=30% height=10%><tr><th>RAISED ON</th><th>DEPT</th><th>ROOM NO.</th><th>STATUS</th><th>DETAILS</th><th>CONTACT</th><th>ISSUE ID</th></tr>");
			while(rs.next())
			 {
				
				pw.println("<tr><td>");
//				Calendar cal = null;
//				Date date = new Date();
//				date = rs.getString(1);
//				DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss.SSS000 a");
//				String dateStr = dateFormat.format(date);
				pw.println(rs.getTimestamp(1));
				pw.println("</td>");
				pw.println("<td>");
				pw.println(rs.getString(2));
				pw.println("</td>");
				pw.println("<td>");
				pw.println(rs.getInt(3));
				pw.println("</td>");
				pw.println("<td>");
				pw.println(rs.getString(4));
				pw.println("</td>");
				pw.println("<td>");
				pw.println(rs.getString(5));
				pw.println("</td>");
				pw.println("<td>");
				pw.println(rs.getString(6));
				pw.println("</td>");
				pw.println("<td>");
				pw.println(rs.getString(7));
				pw.println("</td>");
				pw.println("</tr>");
			 }
			pw.println("</table></body></html><br><br>");
			
			
			pw.println("<form action='Admin.html' method='get'>");
			pw.println("<input type='submit' value='BACK' >");
			pw.println("</form>");
			
			pw.println("<form action='Admin_login.html' method='get'>");
			pw.println("<input type='submit' value='LOGOUT' >");
			pw.println("</form>");
			
			pw.println("<form action='index.html' method='get'>");
			pw.println("<input type='submit' value='HOME' >");
			pw.println("</form>");
			
			pw.println("</center></body>");
			pw.println("</html>");

			   
	    }  
	  
			catch (Exception e)
			{
				e.printStackTrace();
				pw.println("ERROR IN VIEW ISSUE");
			} 

	}
	  
	}  