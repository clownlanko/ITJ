package top.genitalbean.itj.commons.util;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUpload {
    public String saveFile(String account, CommonsMultipartFile temp) throws IOException {
        File dir = new File("/user_img", account);
        if(!dir.exists()){
            dir.mkdir();
        }
        File file = new File(dir, System.currentTimeMillis() + temp.getName());
        temp.transferTo(file);
        return file.getAbsolutePath();
    }
}
