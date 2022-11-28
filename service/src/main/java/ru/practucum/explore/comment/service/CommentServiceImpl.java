package ru.practucum.explore.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practucum.explore.comment.dto.CommentDto;
import ru.practucum.explore.comment.mapper.CommentMapper;
import ru.practucum.explore.comment.model.Comment;
import ru.practucum.explore.comment.repository.CommentRepository;
import ru.practucum.explore.events.enums.State;
import ru.practucum.explore.events.model.Event;
import ru.practucum.explore.events.service.EventService;
import ru.practucum.explore.exception.NoAccessException;
import ru.practucum.explore.exception.ObjectNotFoundException;
import ru.practucum.explore.user.mapper.UserMapper;
import ru.practucum.explore.user.model.User;
import ru.practucum.explore.user.service.UserService;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final EventService eventService;
    private final UserService userService;
    private final UserMapper userMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Long userId, Long eventId) {
        Event event = eventService.getById(eventId);
        User user = userMapper.toUser(userService.getById(userId));
        if (!event.getState().equals(State.PUBLISHED)) {
            throw new NoAccessException("Нельзя написать комментарий к неопубликованному событию");
        }
        Comment comment = commentMapper.toComment(commentDto);
        comment.setCreated(LocalDateTime.now());
        comment.setEvent(event);
        comment.setUser(user);
        commentRepository.save(comment);
        return commentMapper.toCommentDto(comment);
    }

    @Override
    public CommentDto getById(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> {
            throw  new ObjectNotFoundException(String.format("Комментарий с id %d не найден", commentId));
        });
        return commentMapper.toCommentDto(comment);
    }

    @Override
    public CommentDto updateComment(Long userId, Long eventId, CommentDto commentDto) {
        Event event = eventService.getById(eventId);
        User user = userMapper.toUser(userService.getById(userId));
        if (event.getInitiator().getId() != userId) {
            throw new NoAccessException(String.format(
                    "Данный комментарий не создавал пользователь с id %d.", userId)
            );
        }
        Comment comment = commentMapper.toComment(commentDto);
        comment.setCreated(LocalDateTime.now());
        comment.setEvent(event);
        comment.setUser(user);
        commentRepository.save(comment);
        return commentMapper.toCommentDto(comment);
    }

    @Override
    public void deleteCommentById(Long commentId, Long userId) {
        Comment comment = commentMapper.toComment(getById(commentId));
        if (comment.getUser().getId() != userId) {
            throw new NoAccessException(String.format(
                    "Данный комментарий не создавал пользователь с id %d.", userId)
            );
        }
        commentRepository.deleteById(commentId);
    }

    @Override
    public void adminDeleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
