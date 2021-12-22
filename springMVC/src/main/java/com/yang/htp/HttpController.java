package com.yang.htp;

import com.yang.htp.bean.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.UUID;

/**
 * @ProjectName: com.yang.htp
 * @author: ZhangBiBo
 * @description: 请求响应注解
 * @data: 2021/12/20
 */
@Controller
public class HttpController {
    //@RequestBody注解
    @PostMapping("/httpRequest")
    public String httpRequest(@RequestBody String requestBody) {
        System.out.println(requestBody);
        return "success";
    }

    //RequestEntity
    @PostMapping("/httpReqEntity")
    public String httpReqEntity(RequestEntity<String> entity) {
        //entity表示整个请求报文信息
        System.out.println("请求头" + entity.getHeaders());
        System.out.println("请求体" + entity.getBody());
        return "success";
    }

    //@ResponseBody注解
    @RequestMapping("/testResponse")
    @ResponseBody
    public String testResponse() {
        return "testResponse";
    }

    //响应一个对象
    @RequestMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser() {
        return new User("张洋", "男", "学习", "文水县人氏");
    }

    //实现文件下载功能
    @RequestMapping("/fileDownLoad")
    public ResponseEntity<byte[]> fileDownLoad(HttpServletRequest request) throws Exception {

        ServletContext servletContext = request.getServletContext();
        String fileName = "1.jpg";
        String realPath = servletContext.getRealPath("/static/img/" + fileName);//得到文件所在位置
        InputStream in = new FileInputStream(new File(realPath));//将该文件加入到输入流之中
        byte[] body = null;
        body = new byte[in.available()];// 返回下一次对此输入流调用的方法可以不受阻塞地从此输入流读取（或跳过）的估计剩余字节数
        in.read(body);//读入到输入流里面

        fileName = new String(fileName.getBytes("gbk"), "iso8859-1");//防止中文乱码
        HttpHeaders headers = new HttpHeaders();//设置响应头
        headers.add("Content-Disposition", "attachment;filename=" + fileName);
        HttpStatus statusCode = HttpStatus.OK;//设置响应吗
        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body, headers, statusCode);
        return response;
    }

    //上传功能
    @RequestMapping(value = "/testUp", method = RequestMethod.POST)
    public String testUpload(MultipartFile photo,HttpServletRequest request) throws Exception {
        // 判断文件是否为空
        if (!photo.isEmpty()) {
            try {
                String filename = photo.getOriginalFilename();
                //获取上传文件后缀名
                String suffixName = filename.substring(filename.lastIndexOf("."));
                String uuid = UUID.randomUUID().toString();
                filename = uuid+suffixName;
                // 文件保存路径
                String filePath = request.getSession().getServletContext().getRealPath("photo") ;
                System.out.println(filePath);
                File file = new File(filePath);
                if(!file.exists()){
                    file.mkdir();
                }
                // 转存文件separator分割符
                String path = filePath+File.separator+filename;
                System.out.println(path);
                photo.transferTo(new File(path));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 重定向
        return "redirect:/file";
    }
}
