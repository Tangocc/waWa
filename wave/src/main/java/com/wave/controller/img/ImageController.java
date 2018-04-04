package com.wave.controller.img;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Random;

/**
 * @author tango
 * @create 2018-04-03 下午10:57
 * @desc ${DESCRIPTION}
 **/
@Controller
public class ImageController {



    @RequestMapping(value = "/img/upload",method = RequestMethod.POST)
    @ResponseBody
    public String uploadImg(@RequestParam(value="file",required=false)MultipartFile file, HttpServletRequest request){

        File targetFile=null;
        String msg="";//返回存储路径

        //1.验证图片是否已经存在
        try {
            InputStream inputStream = file.getInputStream();


        }catch (IOException e){
            e.printStackTrace();
        }


        String fileName=file.getOriginalFilename();//获取文件名加后缀
        if(fileName!=null&&fileName!=""){
            String returnUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() +"/upload/imgs/";//存储路径
            String path = request.getSession().getServletContext().getRealPath("upload/imgs"); //文件存储位置
            String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());//文件后缀
            fileName=new Date().getTime()+"_"+new Random().nextInt(1000)+fileF;//新的文件名

            //先判断文件是否存在
            String fileAdd = DateUtil.format(new Date(),"yyyyMMdd");
            File file1 =new File(path+"/"+fileAdd);
            //如果文件夹不存在则创建
            if(!file1 .exists()  && !file1 .isDirectory()){
                file1 .mkdir();
            }
            targetFile = new File(file1, fileName);
//          targetFile = new File(path, fileName);
            try {
                file.transferTo(targetFile);
//              msg=returnUrl+fileName;
                msg=returnUrl+fileAdd+"/"+fileName;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return JSON.toJSONString(ResponseResult.result(code, msg));
    }
}
}
