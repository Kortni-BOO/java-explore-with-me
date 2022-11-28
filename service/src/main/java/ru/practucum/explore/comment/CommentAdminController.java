package ru.practucum.explore.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.practucum.explore.comment.dto.CommentDto;
import ru.practucum.explore.comment.service.CommentService;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class CommentAdminController {
    private final CommentService commentService;

    @GetMapping("/comments/{commentId}")
    public CommentDto getById(@PathVariable Long commentId) {
        return commentService.getById(commentId);
    }

    @DeleteMapping("/comments/{commentId}")
    public void deleteById(@PathVariable Long commentId) {
        commentService.adminDeleteComment(commentId);
    }
}
