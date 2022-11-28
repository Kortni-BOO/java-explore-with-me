package ru.practucum.explore.comment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practucum.explore.events.model.Event;
import ru.practucum.explore.user.model.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "text", columnDefinition = "text")
    private String text;

    @ManyToOne()
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;

    @ManyToOne()
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    User user;

    @Column(name = "created")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime created;
}
