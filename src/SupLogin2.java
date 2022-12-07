
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SupLogin2 extends HttpServlet{
	

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		 res.setContentType("text/html");
		 PrintWriter pw = res.getWriter();
		 Connection con;
		 Statement st;
		
		    try
		  {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			st = con.createStatement();
			
			String dept = req.getParameter("department");
			
			
			System.out.println("dept - "+dept);
			
			ResultSet rs = st.executeQuery("select * from pissue where dept ='"+dept+"'");
			
			if(!rs.next())
			  {
//				   pw.println("Login unsuccessful");
//				   System.out.println("un successful");
				
				pw.println("<html><head></head><body onload = \"alert('NO RECORD FOUND')\"></body></html>");
				
				   RequestDispatcher rd=req.getRequestDispatcher("SupLogin");
			       rd.include(req,res);
			  }
			
			    else
			   {
			    	rs = st.executeQuery("select * from pissue where dept ='"+dept+"'");
			    	
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
					
					pw.println("<center><table border='5' width=20% height=5%\"><tr><th>RAISED ON</th><th>DEPT</th><th>ROOM NO.</th><th>STATUS</th><th>DETAILS</th><th>CONTACT</th><th>ISSUE ID</th></tr>");

			    	 
									
						while(rs.next())
						 {
							
//							pw.println("<center><table border='5' width=20% height=5%\"><tr><th>RAISED ON</th><th>DEPT</th><th>ROOM NO.</th><th>STATUS</th><th>DETAILS</th><th>CONTACT</th><th>ISSUE ID</th></tr>");

							
							pw.println("<tr><td>");
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
						 
//						pw.println("</table><br><br>");
				}	
						
						pw.println("</table><br><br>");

						
//						pw.println("<form action='SupLogin2' method='get'>");
//						pw.println("<br>");
//						pw.println("<select name='department' >");
//						pw.println("<option>--SELECT DEPARTMENT--</option>");
//						pw.println("<option value='ADMIN'>ADMIN</option>");
//						pw.println("<option value='CARPENTER'>CARPENTER</option>");
//						pw.println("<option value='ELECTRICIAN'>ELECTRICIAN</option>");
//						pw.println("<option value='JANITOR'>JANITOR</option>");
//						pw.println("<option value='MASON'>MASON</option>");
//						pw.println("<option value='PAINTER'>PAINTER</option>");
//						pw.println("<option value='PLUMBER'>PLUMBER</option>");
//						pw.println("<option value='SECURITY'>SECURITY</option>");
//						pw.println("<option value='WARDBOY'>WARDBOY</option>");
//
//			            pw.println("</select>");
//			            
//			            pw.println("<input type='submit' value='SORT BY' />");
//						pw.println("</form><br><br>");

						
//						pw.println("<form action='SupLogin' method='get'>");
//						pw.println("<input type='submit' value='BACK' >");
//						pw.println("</form>");
						
						pw.println("<form action='Sup_login.html' method='get'>");
						pw.println("<input type='submit' value='LOGOUT' >");
						pw.println("</form>");
						
						pw.println("<form action='index.html' method='get'>");
						pw.println("<input type='submit' value='HOME' >");
						pw.println("</form");
						
//						pw.println("</table><br><br>");

						pw.println("</center></body></html>");
						
						//issue table end
					}
//				 }
			   	 
		}
		 
		 catch (Exception e)
		    {
			 System.out.println("error in SupLogin2");
			 e.printStackTrace();
		    }
		    
	}
}