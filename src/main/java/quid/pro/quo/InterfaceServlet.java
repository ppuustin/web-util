package quid.pro.quo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet(name = "InterfaceServlet", urlPatterns = {
    "/get-method-1", 
    "/get-method-2" })
public class InterfaceServlet extends HttpServlet
{    
    // -------------------------------------------------------------
	 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
 
    @Override
    public String getServletInfo() {
        return this.getClass().getName();
    }
    
    // ------------------------------------------------------------- 
	
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException 
    {
        String url = request.getRequestURL().toString();
        
        try {
        
            JSONArray jsa = null;
            JSONObject jso = null;

            if( url.contains( "/get-method-1" ) )
            {                
                jso = new JSONObject();
                jso.put( "hello", "there!" );
            } 
            else if( url.contains( "/get-method-2" ) )
            {
                jsa = new JSONArray();

                JSONObject json1 = new JSONObject();
                json1.put( "hello", "there-1" );

                JSONObject json2 = new JSONObject();
                json2.put( "hello", "there-2" );
                
                jsa.put(json1); 
                jsa.put(json2); 
            }
            else {
                ResponseDecorator.print( response, null );            
                throw new ServletException( "unsupported pattern: " + url );
            }

            ResponseDecorator.print( response, 
                jso == null ? jsa.toString() : jso.toString() );
        
        } catch( Exception e ) {

            System.out.println( e.toString() );  
            throw new ServletException(e);
        }     
        
    }
    
}
