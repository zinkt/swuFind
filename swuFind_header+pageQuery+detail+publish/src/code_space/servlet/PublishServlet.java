package code_space.servlet;

import code_space.domain.Publish_info;
import code_space.service.PublishService;
import code_space.service.impl.PublishServiceImpl;
import code_space.util.UploadImageUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "PublishServlet", value = "/PublishServlet")
@MultipartConfig
public class PublishServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("PublishServlet is done");
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取参数
        //2.1获取图片
        Part part = request.getPart("rimage");
        //2.2获取文本内容
        Map<String, String[]> map = request.getParameterMap();
        //3.封装对象为Javabean
        //3.1设置Javabean对象中的文本内容（此时设置的图片文件内容为null）
        Publish_info publish_info = new Publish_info();
        try {
            BeanUtils.populate(publish_info,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //3.2设置Javabean中的图片内容
        //获取当前工程的路径
        String url=request.getSession().getServletContext().getRealPath("");
        //调用UploadImageutil将图片保存到本地，返回图片的相对路径
        String rimage = UploadImageUtils.upload(part,request,response,url);
        publish_info.setRimage(rimage);
        //输出表单提交的对象
        System.out.println(publish_info);
       // 4.调用Service保存
        PublishService service = new PublishServiceImpl();
        service.publish(publish_info);
        /*
        5.跳转到/findByPageServlet进行内容刷新，request.getContextPath（）是获取虚拟目录
         */
        //        response.sendRedirect(request.getContextPath()+"/findByPageServlet");
        /*
        跳转到publish_ok页面
         */
        response.sendRedirect("publish_ok.html");
    }
}
