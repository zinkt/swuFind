package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    //声明service变量，用于整个过程
    private UserService service = new UserServiceImpl();

    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //验证码校验
        String check = req.getParameter("check");
        //从session中获取验证码
        HttpSession session = req.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        //保证验证码只生成一次
        session.removeAttribute("CHECKCODE_SERVER");
        //比较
        if (checkcode_server == null || !checkcode_server.equalsIgnoreCase(check)){
            ResultInfo info = new ResultInfo();
            info.setFlag(false);
            info.setErrorMsg("验证码错误！");
            //将info对象序列化为json
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(info);
            //将json数据写回客户端
            //设置content type
            resp.setContentType("application/json;charset=utf-8");
            resp.getWriter().write(json);
            return;
        }

        //1获取数据
        Map<String,String[]> map = req.getParameterMap();
        //2封装对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        //3调用service方法完成注册
        //UserService service = new UserServiceImpl();
        boolean flag = service.regist(user);
        ResultInfo info = new ResultInfo();
        //4响应结果
        if (flag){
            info.setFlag(true);
        }else{
            info.setFlag(false);
            info.setErrorMsg("注册失败！");
        }
        //4.1将info对象序列化为json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(info);
        //4.2将json数据写回客户端
        //4.2.1设置content type
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(json);
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //验证码校验
        String check = req.getParameter("check");
        //从session中获取验证码
        HttpSession session = req.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        //保证验证码只生成一次
        session.removeAttribute("CHECKCODE_SERVER");
        //比较
        if (checkcode_server == null || !checkcode_server.equalsIgnoreCase(check)){
            ResultInfo info = new ResultInfo();
            info.setFlag(false);
            info.setErrorMsg("验证码错误！");
            //将info对象序列化为json
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(info);
            //将json数据写回客户端
            //设置content type
            resp.setContentType("application/json;charset=utf-8");
            resp.getWriter().write(json);
            return;
        }

        Map<String, String[]> parameterMap = req.getParameterMap();
        // 封装user对象
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用service查询
        //UserService service = new UserServiceImpl();
        User u = service.login(user);
        ResultInfo info = new ResultInfo();

        if (u==null){
            info.setFlag(false);
            info.setErrorMsg("用户名或密码错误");
        }
        if (u!=null && !"Y".equals(u.getStatus())){
            info.setFlag(false);
            info.setErrorMsg("您尚未激活");
        }
        if (u!=null && "Y".equals(u.getStatus())){
            info.setFlag(true);
            req.getSession().setAttribute("user",u);
        }
        //响应数据
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json;charset=utf-8");
        mapper.writeValue(resp.getOutputStream(),info);
    }

    public void findOneUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从session获取登录用户
        Object user = req.getSession().getAttribute("user");
        //将user写回客户端
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json;charset=utf-8");
        mapper.writeValue(resp.getOutputStream(),user);
    }

    public void exit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //销毁自己
        req.getSession().invalidate();
        //跳转
        resp.sendRedirect(req.getContextPath()+"/login.html");

    }

    /*
    用户激活
     */
    public void active(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1获取激活码
        String code = req.getParameter("code");
        if (code != null){
            //UserService service = new UserServiceImpl();
            boolean flag = service.active(code);
            String msg = null;
            if (flag){
                //激活成功
                msg="激活成功，请<a href='login.html'>登录</a>";
            }else {
                //激活失败
                msg="激活失败，请联系管理员";
            }
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write(msg);
        }
    }
}
