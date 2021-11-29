package code_space.servlet;

import code_space.domain.PageBean;
import code_space.domain.list_info;
import code_space.service.impl.pageQueryImpl;
import code_space.service.pageQuery;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//request从前段获取消息数据，截取的是字符串
@WebServlet("/findByPageServlet")
//servlet掌控全局，相当于介于前段后端之间
public class pageQueryServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取参数
        String currentPage=request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        //类别id，eg:港澳游
        String cid = request.getParameter("cid");


        //处理参数
        if(cid == null || "".equals(cid))
            cid = "1";
        if(currentPage == null || "".equals(currentPage))
            currentPage = "1";
        if(rows == null || "".equals(rows))
            rows = "8";

        //2.调用service查询PageBean(相当于伪页面，包含页面展示所需要的所有数据)
        PageBean<list_info> pb= null;
        try {
            pageQuery service=new pageQueryImpl();
            pb = service.findUserByPage(cid,currentPage,rows);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't get the pb Object");
        }
        //3.将pagebean存入request
        request.setAttribute("pb",pb);
        System.out.println(pb);
        //5.将传入的对象序列化为Jason ，并且写回客户端
        ObjectMapper mapper =new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),pb);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
