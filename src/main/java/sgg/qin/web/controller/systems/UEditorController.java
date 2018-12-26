package sgg.qin.web.controller.systems;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baidu.ueditor.ActionEnter;
import com.baidu.ueditor.define.ActionMap;

@Controller
public class UEditorController {
	//@RequestMapping中填写config.json目录
	@RequestMapping("static/ueditor/config")  
    public void baiduEdit(HttpServletRequest request, HttpServletResponse response) {  
        try {  
            request.setCharacterEncoding("utf-8");  
            response.setHeader("Content-Type", "text/html");  
              
            String rootPath = request.getServletContext().getRealPath("/");  
            System.out.println(">>>>>>>>>>>>"+rootPath);
            //针对配置百度上传附件读取配置文件  
            ActionMap.mapping.put("config", ActionMap.CONFIG);  
            //上传文件  
            ActionMap.mapping.put("uploadfile", ActionMap.UPLOAD_FILE);  
            ActionEnter actionEnter = new ActionEnter(request, rootPath);  
            response.getWriter().write(actionEnter.exec());  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    } 
}
