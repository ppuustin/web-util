package quid.pro.quo;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

public class ResponseDecorator
{
    public static void print( HttpServletResponse response, String string ) 
        throws IOException
    {
        //response.addHeader( "Access-Control-Allow-Origin", "*" ); //No 'Access-Control-Allow-Origin' header 
        response.setContentType( "application/json" );
        response.setCharacterEncoding( "utf-8" );
        
        if ( string != null )
        {
            response.getOutputStream().print( string );
        }        
    }
}
