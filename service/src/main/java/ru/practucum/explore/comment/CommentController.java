package ru.practucum.explore.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.practucum.explore.comment.dto.CommentDto;
import ru.practucum.explore.comment.mapper.CommentMapper;
import ru.practucum.explore.comment.model.Comment;
import ru.practucum.explore.comment.service.CommentService;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;


    @PostMapping("/{userId}/events/{eventId}/comments")
    public CommentDto create(@PathVariable Long userId, @PathVariable Long eventId,
                             @Valid @RequestBody CommentDto commentDto) {
        return commentService.createComment(commentDto, userId, eventId);
    }

    @DeleteMapping("/users/{userId}/comments/{commentId}")
    public void deleteById(@PathVariable Long userId, @PathVariable Long commentId) {
        commentService.deleteCommentById(commentId, userId);
    }

    @PatchMapping("/{userId}/events/{eventId}/comments")
    public CommentDto update(@PathVariable Long userId, @PathVariable Long eventId,
                             @Valid @RequestBody CommentDto commentDto) {
        return commentService.updateComment(userId, eventId, commentDto);
    }
}
