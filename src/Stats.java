
	import java.io.*;  
	import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.*;  
	import javax.servlet.http.*;

import java.util.*;
import java.util.Date;
	
	  
	public class Stats extends HttpServlet
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
			   
			 
				    rs = st.executeQuery("select count(iid) from pissue");
				    
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
							+ "</div><div style=\"padding-left:16px\">");
					
					pw.println("</div><br><br>");
				    
				    //header end
			
					//total no. of issues
			while(rs.next())
			 {
//				pw.println("<html><body><center><table border='5' width=30% height=10%><tr><th>TOTAL NO. OF ISSUES</th></tr>");
//				
//				pw.println("<tr><td>");
//				pw.println("<center>"+rs.getInt(1)+"</center>");
//				pw.println("</td>");
				
				pw.println("<div class=\"count-cards\">");
				pw.println("<div class=\"count-card\">");
				pw.println("Total Issues");
				pw.println("<span class=\"issue-no\">"+ rs.getInt(1) + "</span>");
				pw.println("<div>");
						pw.println("<div>");
				
			 }
//			pw.println("</table></body></html><br><br>");
			
			
			//solved issues
			rs = st.executeQuery("select count(iid) from pissue where status ='S'");
			while(rs.next())
			 {
//				pw.println("<html><body><center><table border='5' width=30% height=10%><tr><th>SOLVED NO. OF ISSUES</th></tr>");
//				
//				pw.println("<tr><td>");
//				pw.println("<center>"+rs.getInt(1)+"</center>");
//				pw.println("</td>");
				
				pw.println("<div class=\"count-cards\">");
				pw.println("<div class=\"count-card\">");
				pw.println("Solved Issues");
				pw.println("<span class=\"issue-no\">"+ rs.getInt(1) + "</span>");
				pw.println("<div>");
						pw.println("<div>");
				
			 }
//			pw.println("</table></body></html><br><br>");
			
			
			//pending issues
			rs = st.executeQuery("select count(iid) from pissue where status ='P'");
			while(rs.next())
			 {
//				pw.println("<html><body><center><table border='5' width=30% height=10%><tr><th>PENDING NO. OF ISSUES</th></tr>");
//				
//				pw.println("<tr><td>");
//				pw.println("<center>"+rs.getInt(1)+"</center>");
//				pw.println("</td>");
				
//			 }	
//			pw.println("</table>");
			
			
			pw.println("<div class=\"count-cards\">");
			pw.println("<div class=\"count-card\">");
			pw.println("Pending Issues");
			pw.println("<span class=\"issue-no\">"+ rs.getInt(1) + "</span>");
			pw.println("<div>");
					pw.println("<div>");
			 }
			
			pw.println("</body></html><br><br>");
			
			
			
			   
	    }  
	  
			catch (Exception e)
			{
				e.printStackTrace();
				pw.println("ERROR IN STATS");
			} 

	}
	  
	}  
