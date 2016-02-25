package cl.mac;

import java.io.IOException;

import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HolaMundo extends HttpServlet {

    public void init(ServletConfig conf)
      throws ServletException {
      super.init(conf);
    }
    
    /*
    public void service(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException  {
      res.setContentType("text/html");
      PrintWriter out = res.getWriter();

      String cadena = req.getParameter("TEXTO"); 

        System.out.println("cadena"+cadena);

      out.println("<html>");
      out.println("<body>");
      out.println("<h1>service:"+cadena+"</h1>");
      out.println("</body>");
      out.println("</html>");
    }*/
    
    public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException  {
      res.setContentType("text/html");
      PrintWriter out = res.getWriter();

      String cadena = req.getParameter("TEXTO"); 

        System.out.println("cadena"+cadena);


        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            Connection conexion = DriverManager.getConnection(
                        "jdbc:oracle:thin:@alamo.magallanes.cl:1521/beta", "MACWEB", "WEB");
            
            System.out.println("conexion:"+conexion);
            
            Statement sentencia=conexion.createStatement();
            
            ResultSet resultados=sentencia.executeQuery("SELECT * FROM MACANA.ESTADO_BITACORA_VIG");
            
            out.println("<html>");
            out.println("<body>");
            
            while(resultados.next()) { 
                       out.println("<br>Nombre="+resultados.getString("EBV_ID")+
                                   " Descripcion="+resultados.getString("EBV_DESCRIPCION")
                                   );
                    }//Fin while

            
            out.println("</body>");
            out.println("</html>");


            
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        

    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException  {
        
      UsuarioBean usuarioBean = new UsuarioBean();  
        
      RequestDispatcher a = null;  
      res.setContentType("text/html");
      //PrintWriter out = res.getWriter();

      String user = req.getParameter("user"); 
      String password = req.getParameter("password"); 

      if (user.equals("user") && password.equals("password")){
          usuarioBean.setNombre("Carlos");
          req.setAttribute("usuario", usuarioBean);
          a = req.getRequestDispatcher("home.jsp");
      }
      else{
          a = req.getRequestDispatcher("errorLogin.jsp");
      }
      a.forward(req, res);
    }
    

}
