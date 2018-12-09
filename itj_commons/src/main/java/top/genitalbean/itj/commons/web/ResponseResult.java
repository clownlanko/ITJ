package top.genitalbean.itj.commons.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.ResponseBody;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResult <T>{
	private Integer state=-1;
	private String message="好像什么都没有发生哦";
    private T data;
    public ResponseResult(T t){
    	this.data=t;
	}
	public ResponseResult(Integer state,String message){
    	this.state=state;
    	this.message=message;
	}
}
