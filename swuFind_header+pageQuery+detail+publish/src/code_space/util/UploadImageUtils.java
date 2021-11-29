package code_space.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class UploadImageUtils {
    //工具类
    public static String upload(Part part, HttpServletRequest request, HttpServletResponse response,String url){

        String photo = part.getSubmittedFileName();//获取文件名
        photo= UUID.randomUUID()+photo;//为防止重名。加uid
        String[] aa = photo.split(".");//判断类型
        if(!(photo.endsWith("jpg")||photo.endsWith("png")||photo.endsWith("jpeg"))){
            request.setAttribute("type","err");
            photo="";
        }
//        String path="D:/img_test";//本地目录
        String path=url+"/"+"images";
        File file = new File(path);
        if(!file.exists()){//如果目录不存在就新建一个
            System.out.println("images文件夹不存在，新建");
            file.mkdirs();
        }
        try {
            part.write(path+"/"+photo);//本地名字+文件名字  将文件的名字写入本地
        } catch (IOException e) {
            e.printStackTrace();
        }
        String image="images"+"/"+photo;
        return image;//返回图片的名字
    }
}
