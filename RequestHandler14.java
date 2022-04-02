/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
import java.io.PrintWriter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class RequestHandler14 implements ServletRequestListener, HttpSessionListener 
{
    static int cnt,sc;
    public void requestDestroyed(ServletRequestEvent sre)
    {
        throw new UnsupportedOperationException("Not Supported");
    }
    public void requestInitialized(ServletRequestEvent sre)
    {
        cnt++;
    }
    public void sessionCreated(HttpSessionEvent se)
    {
        sc++;
    }
    public void sessionDestroyed(HttpSessionEvent se)
    {
        sc--;
    }
    
    public static int getreqcnt()
    {
        
        return cnt;
    }
    
    public static int getreqsc()
    {
        return sc;
    }
}
