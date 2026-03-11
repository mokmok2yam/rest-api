package com.back.domain.post.comment.controller;

import com.back.domain.post.comment.entity.Comment;
import com.back.domain.post.comment.entity.CommentDto;
import com.back.domain.post.post.entity.Post;
import com.back.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/posts/{postId}/comments")
@RequiredArgsConstructor
public class ApiV1CommentController {
    private final PostService postService;

    //댓글 다건 조회
    @GetMapping
    @ResponseBody
    public List<CommentDto> list(
            @PathVariable int postId
    ) {
        Post post = postService.findById(postId).get();
        List<Comment> comments = post.getComments();
        List<CommentDto> commentDtoToList = comments.stream()
                .map(CommentDto::new)
                .toList();
        return commentDtoToList;
    }
    //댓글 단건 조회
    @GetMapping("/{commentId}")
    @ResponseBody
    public CommentDto detail(@PathVariable int postId, @PathVariable int commentId){
        Post post = postService.findById(postId).get();
        Comment comment =post.findCommentById(commentId).get();
        return new CommentDto(comment);
    }
    //댓글 삭제
    @GetMapping("/{commentId}/delete")
    @ResponseBody
    @Transactional
    public String delete(
            @PathVariable int postId,
            @PathVariable int commentId
    ){
        Post post = postService.findById(postId).get();
        post.deleteComment(commentId);
        return "%d댓글이 삭제되었습니다.".formatted(commentId);
    }


}
