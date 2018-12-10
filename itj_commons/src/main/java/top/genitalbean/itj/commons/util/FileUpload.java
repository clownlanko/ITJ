package top.genitalbean.itj.commons.util;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUpload {
    public String saveFile(String account, CommonsMultipartFile temp) throws IOException {
        //创建用户文件夹，保存文件
        File dir = new File("/user_img", account);
        if(!dir.exists()){
            dir.mkdir();
        }
        System.out.println(dir.exists());
        File file = new File(dir, System.currentTimeMillis()+"_"+temp.getSize()+"."+temp.getStorageDescription());
        temp.transferTo(file);
        return file.getAbsolutePath();
    }
}
