package top.genitalbean.itj.commons.util;

import org.springframework.util.Base64Utils;
import org.springframework.util.DigestUtils;

public class DigestContent {
    public static String encode(String content){
        return DigestUtils.md5DigestAsHex(Base64Utils.encode(content.getBytes()));
    }
}
