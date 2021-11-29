package code_space.servlet;

import code_space.domain.list_info;
import code_space.service.detailService;
import code_space.service.impl.detailServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "detailServlet", value = "/detailServlet")
public class detailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收did
        String did=request.getParameter("did");
        //处理did
        if(did == null || "".equals(did))
        {
            System.out.println("did is null!");
            did="1";
        }
        //调用service查询数据
        list_info info=null;
        detailService detailService=new detailServiceImpl();
        info=detailService.findDetail(did);
        System.out.println("detailServlet is done");
        System.out.println(info);
        //将查询到的数据序列化为Jason ，并且写回客户端
        ObjectMapper mapper =new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),info);
    }
}
