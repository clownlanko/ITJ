package top.genitalbean.itj.commons.web;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ImageResult {
    private Integer success;
    private String message;
    private String url;
}
