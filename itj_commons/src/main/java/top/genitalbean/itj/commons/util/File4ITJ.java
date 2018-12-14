package top.genitalbean.itj.commons.util;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class File4ITJ {
    public static String generateFileName(CommonsMultipartFile file){
        String suffix = file.getOriginalFilename();
        suffix=suffix.substring(suffix.lastIndexOf('.'));
        return System.currentTimeMillis() + "_" + file.getSize() + suffix;
    }
}
