package swu606309.swuFind.web.servlet;

import swu606309.swuFind.domain.Category;
import swu606309.swuFind.service.CategoryService;
import swu606309.swuFind.service.impl.CategoryServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/category/findAll")
public class CategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryService service = new CategoryServiceImpl();
        // 1.调用service查询所有
        List<Category> cs = service.findAll();
        //输出调试结果
//        System.out.println(cs);
        //2.序列化json返回
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper mapper =new ObjectMapper();
        mapper.writeValue(response.getWriter(),cs);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
