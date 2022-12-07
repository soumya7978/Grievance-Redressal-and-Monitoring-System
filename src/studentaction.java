
	import java.io.*;  
	import java.sql.*;
	import javax.servlet.*;  
	import javax.servlet.http.*;  
	  
	public class studentaction extends HttpServlet
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
			   
			   String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
			   pw.println(docType +
			   "<html>\n" +
	           "<head></head>\n" +
			   "<body>\n" +
	           
				"<br>"+
	           
 				//RAISE ISSUE START
 
				"<form action='IssueRaise.html' method='get'>"+
                  
				"<h2 class='h2'><center><p>--SELECT OPTION--</p>  </center> </h2>" +
				"<br>"+"<br>"+"<br>"+
			   "<center><input type='submit' name='ri' value='RAISE ISSUE'></center>"+
			   
			   "</form>"+
			   
			   //RASIE ISSUE END
               "<br>"+
			   "<form action='studentcheckaction' method='get'>"+
	           
	             
			   "<center><input type='submit' name='ih' value='ISSUE HISTORY'> </center>"+
			   
			   "</form>"+
			   
"<br>"+
"<form action='Student_login.html' method='get'>"+

  
"<center><input type='submit' name='ih' value='LOG OUT'> </center>"+

"</form>"+
			   
			  			   
			   "</body>" +
			   "</html>" );
			   	   
	    }  
	  
			 
			 
			 
			catch (Exception e)
			{
				e.printStackTrace();
			} 

	}
	  
	}  