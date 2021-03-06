package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * packageName : hello.servlet.basic.request
 * fileName : RequestParamServlet
 * author : scott
 * date : 2022-01-25
 * description :1.파라미터 전송기능
 * http://localhost:8081/request-param?username=hello&age=20
 * ===========================================================
 * DATE AUTHOR NOTE
 * -----------------------------------------------------------
 * 2022-01-25 scott 최초 생성
 */
@WebServlet(name="requestParamServlet",urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("변경");
        System.out.println("[전체 파라미터 조회]-start");
        request.getParameterNames().asIterator().forEachRemaining(paramName -> System.out.println(paramName + " = " + request.getParameter(paramName)));
        System.out.println("[전체 파라미터 조회]-end");

        System.out.println("[단일 파라미터 조회]:이때 중복된 값을 넣게 되면 첫번째 값만 나오게 된다.");
        String username = request.getParameter("username");
        String age = request.getParameter("age");

        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        String [] usernames = request.getParameterValues("username");
        for(String name : usernames){
            System.out.println("name = " + name);
        }

        response.getWriter().write("ok");

    }
}
