package top.genitalbean.itj.pojo;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class UserEntity {
    private Integer userId;
    @NonNull
    private String account;
    @NonNull
    private String password;
    private String nickname;
    private String headPhoto;
    private String autograph;
    private Date joinTime;
    private Date modifyTime;

    @Override
    public boolean equals(Object obj) {
        if(obj==null)
            return false;
        if(obj.getClass()!=UserEntity.class)
            return false;
        if(obj instanceof UserEntity){
            UserEntity user= (UserEntity) obj;
            if(this.account.equals(user.getAccount()) &&
                this.password.equals(user.getPassword()))
                return true;
        }
        return super.equals(obj);
    }
}
