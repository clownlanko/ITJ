package top.genitalbean.itj.commons.web;

import lombok.*;
import org.springframework.web.bind.annotation.ResponseBody;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseResult <T>{
	private Integer state;
	private String message;
    private T data;
    public ResponseResult(T t){
    	this.data=t;
	}
	public ResponseResult(Integer state,String message){
    	this.state=state;
    	this.message=message;
	}
	public ResponseResult(Integer state,T data){
    	this.state=state;
    	this.data=data;
	}
}
