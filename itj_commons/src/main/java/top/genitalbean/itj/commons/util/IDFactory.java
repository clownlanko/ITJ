package top.genitalbean.itj.commons.util;

import lombok.NonNull;

public class IDFactory {
    public static String generateCommontId(@NonNull Integer articleId){
        return "itj_"+articleId+"_"+System.currentTimeMillis();
    }
}
