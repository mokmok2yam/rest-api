package com.back.global.rsData;

import com.back.domain.post.comment.entity.CommentDto;

public record RsData (
        String msg,
        String resultCode,
        CommentDto data
)
{}
