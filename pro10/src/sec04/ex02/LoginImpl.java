package sec04.ex02;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class LoginImpl
 *
 */
@WebListener
public class LoginImpl implements HttpSessionListener {
	String user_id;
	String user_pw;
	static int total_user=0;
	
    /**
     * Default constructor. 
     */
    public LoginImpl() {
        // TODO Auto-generated constructor stub
    }
    
    public LoginImpl(String user_id, String user_pw) {
        // TODO Auto-generated constructor stub
    	this.user_id = user_id;
    	this.user_pw = user_pw;
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { //���� ���� �� �̺�Ʈ ó��
         System.out.println("���� ����");
         ++total_user; //���� ���� �� ������ ���� 1 ����
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { //���� �Ҹ� �� �̺�Ʈ ó��
         System.out.println("���� �Ҹ�");
         --total_user; //���� �Ҹ� �� ������ ���� 1 ����
    }
	
}
