package pageQuery.servlet;

import pageQuery.domain.PageBean;
import pageQuery.domain.User;
import pageQuery.service.UserService;
import pageQuery.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//request从前段获取消息数据，截取的是字符串
@WebServlet("/findUserByPageServlet")
//servlet掌控全局，相当于介于前段后端之间
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取参数
        String currentPage=request.getParameter("currentPage");
        String rows = request.getParameter("rows");

        //2.调用service查询PageBean(相当于伪页面，包含页面展示所需要的所有数据)
        UserService service=new UserServiceImpl();
        PageBean<User> pb=service.findUserByPage(currentPage,rows);
        //3.将pagebean存入request
        request.setAttribute("pb",pb);
        //4.转发到list.jsp
        System.out.println(pb);
       // request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
