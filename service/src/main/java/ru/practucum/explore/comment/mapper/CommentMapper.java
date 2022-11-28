package ru.practucum.explore.comment.mapper;

import lombok.RequiredArgsConstructor;
import ru.practucum.explore.comment.dto.CommentDto;
import ru.practucum.explore.comment.model.Comment;
import ru.practucum.explore.events.mapper.EventMapper;
import ru.practucum.explore.user.mapper.UserMapper;

@RequiredArgsConstructor
public class CommentMapper {
    private final EventMapper eventMapper;
    private final UserMapper userMapper;

    public Comment toComment(CommentDto commentDto) {
        Comment comment = Comment.builder()
                .text(commentDto.getText())
                .event(eventMapper.toEventFromShort(commentDto.getEvent()))
                .user(userMapper.toUserFromUserShort(commentDto.getUser()))
                .build();
        return comment;
    }

    public CommentDto toCommentDto(Comment comment) {
        CommentDto commentDto = CommentDto.builder()
                .text(comment.getText())
                .event(eventMapper.toEventShortDto(comment.getEvent()))
                .user(userMapper.toUserShortDto(comment.getUser()))
                .build();
        return commentDto;
    }
}
