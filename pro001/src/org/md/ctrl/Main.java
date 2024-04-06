package org.md.ctrl;


//Controller 사용자 요청을 어떻게 처리할지 결정하는 파트이며,
//Main class 만든 이유 : main페이지의 사용자 요청을 처리할 서블릿 ctrl을 만듬
//doget dopost service 
//서블렛 클래스는 클라이언트에서 요청받은 방식에 따라 doget,dopost 메서드를 호출한다.
//service는 doget, dopost 둘다 사용할때 사용한다.
//post는 폼에서 요청하고 있다. 폼은 자신의 페이지를 요청한다. 따라서 action 속성이 필요없다.
//main 페이지는 doget(a태그) dopost(폼) 을 둘다 받아야 함으로 service를 사용한다.
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pro001")//pro01로 접근하면 service 호출
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Main() {
        super();
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext appliction = request.getServletContext();	
			//ServletContext 는 애플리케이션의 정보 인터페이스
			//애플리케이션 전역에서 데이터를 저장하고 공유할 수 있다.
			//https://java117.tistory.com/18
		String realPath = request.getSession().getServletContext().getRealPath("/");
			//"/" 현재 웹애플리케이션 루트 디렉토리 나타냄
			// 루트 디렉토리에 대한 실제 파일 시스템 경로 지정
			// request.getSession() : 클라이언트와 서버간의 데이터 공유를 위해 사용
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
			//index.jsp 전달하기 위한 구문 서블릿이나 jsp 반환 및 전달하는 인터페이스
		view.forward(request, response);
	}

}
