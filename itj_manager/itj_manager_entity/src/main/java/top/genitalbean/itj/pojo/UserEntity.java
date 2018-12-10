package top.genitalbean.itj.pojo;

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
}
