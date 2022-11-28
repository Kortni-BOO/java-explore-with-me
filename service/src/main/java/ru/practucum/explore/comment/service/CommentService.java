package ru.practucum.explore.comment.service;

import org.springframework.web.bind.annotation.PathVariable;
import ru.practucum.explore.comment.dto.CommentDto;

public interface CommentService {
    /**
     * Создать комментарий
     * Можно только к опубликованному событию
     */
    CommentDto createComment(CommentDto commentDto, Long userId, Long eventId);

    //Найти комментарий по id
    CommentDto getById(Long commentId);

    /**
     * Редактировать комментарий, может только автор
     */
    CommentDto updateComment(Long userId, Long eventId, CommentDto commentDto);

    //Удалить комментарий
    void deleteCommentById(Long commentId, Long userId);

    void adminDeleteComment(Long commentId);
}
