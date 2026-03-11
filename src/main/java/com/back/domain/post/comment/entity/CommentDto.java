package com.back.domain.post.comment.entity;

import java.time.LocalDateTime;

public record CommentDto(
        int id,
        String content,
        LocalDateTime createDate,
        LocalDateTime modifyDate
){
    public CommentDto(Comment comment)
    {
        this(
                comment.getId(),
                comment.getContent(),
                comment.getCreateDate(),
                comment.getModifyDate()
        );
    }
}
