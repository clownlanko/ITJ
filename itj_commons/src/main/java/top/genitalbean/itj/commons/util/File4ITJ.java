package top.genitalbean.itj.commons.util;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class File4ITJ {
    public static String generateFileName(CommonsMultipartFile file){
        String suffix = file.getOriginalFilename();
        suffix=suffix.substring(suffix.lastIndexOf('.'));
        return System.currentTimeMillis() + "_" + file.getSize() + suffix;
    }
    public static File saveImageToFile(CommonsMultipartFile image, File folder) throws IOException {
        String fileName = generateFileName(image);
        File file = new File(folder, fileName);
        BufferedImage img = ImageIO.read(image.getInputStream());
        BufferedImage bi = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = bi.createGraphics();
        g2.clearRect(0,0,bi.getWidth(),bi.getHeight());
        g2.drawImage(img,0,0,bi.getWidth(),bi.getHeight(),null);
        ImageIO.write(bi,"jpeg",file);
        return file;
    }
}
