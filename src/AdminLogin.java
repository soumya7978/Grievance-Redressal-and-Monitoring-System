

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLogin extends HttpServlet{
	

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
			
			String id = req.getParameter("id");
			String password = req.getParameter("pwd");
			
//			System.out.println("id - "+roll+" password - "+password);
			
//			select * from pstaff where id ='110' and password='a' and dept='ADMIN' ;
			ResultSet rs = st.executeQuery("select * from pstaff where id ='"+ id +"' and password ='" +password +"' and dept = 'ADMIN'");
			
			if(!rs.next())
			  {
//				   pw.println("Login unsuccessful");
//				   System.out.println("un successful");
				
//				pw.println("<html><head></head><body onload = \"alert('CREDENTIALS MISMATCH')\"></body></html>");
				
				   RequestDispatcher rd=req.getRequestDispatcher("error.html");
			       rd.include(req,res);
			  }
			
			    else
			   {
			    	rs = st.executeQuery("select * from pstaff where id ='"+ id +"' and password ='" +password +"' and dept = 'ADMIN'");			     while(rs.next())
				 { 
			       String idc = rs.getString(1);
			       String deptc = rs.getString(2);
			       String namec = rs.getString(3);
			       String pwdc = rs.getString(5);
//				   
//				   pw.println(rollc);
//				   pw.println(namec);
//				   pw.println(roomc);
			
	  		       if((id.equals(idc))&&(password.equals(pwdc)))
			        {
	  		    	   System.out.println("success..");
	  		    	   
	  		    	  	  		    	 
			        	//RequestDispatcher rd=req.getRequestDispatcher("/FrontEnd/IssueRaise.html");
			        	RequestDispatcher rd=req.getRequestDispatcher("Admin.html");
						rd.include(req,res);
					}
	  		       
	  		       else
	  		       {
	  		    	 RequestDispatcher rd=req.getRequestDispatcher("error.html");
						rd.include(req,res);
	  		       }
				 }
			   }	 
		}
		 
		 catch (Exception e)
		    {
			 System.out.println("error...");
			 e.printStackTrace();
		    }
	  }

}
