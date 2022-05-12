package hello.servlet.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    private Long id;
    private String userName;
    private int age;

    @Builder
    public Member(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }
}
