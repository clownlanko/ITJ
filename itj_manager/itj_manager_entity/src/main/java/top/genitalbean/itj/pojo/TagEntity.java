package top.genitalbean.itj.pojo;

import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
public class TagEntity {
    @NonNull
    private Integer tagId;
    @NonNull
    private String tagName;
    private boolean exists;
}
