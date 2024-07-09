package gift.member.dto;

import gift.member.domain.*;

public record MemberServiceDto(Long id, MemberType memberType, Email email, Password password, NickName nickName) {
    public Member toMember() {
        return new Member(id, memberType, email, password, nickName);
    }
}