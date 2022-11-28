package ru.practucum.explore.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practucum.explore.comment.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
