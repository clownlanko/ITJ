package top.genitalbean.itj.commons.util;

public class IDFactory {
    public static String generateCommontId(Integer articleId){
        return "itj_"+articleId+"_"+System.currentTimeMillis();
    }
}
