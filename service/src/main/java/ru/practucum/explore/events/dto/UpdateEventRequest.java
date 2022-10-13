package ru.practucum.explore.events.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.practucum.explore.category.model.Category;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEventRequest {
    long id;

    String annotation; //Краткое описание

    Category category; //Категория

    String description; //Полное описание события

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime eventDate; //Дата и время на которые намечено событие

    int eventId;

    Boolean paid; //Нужно ли оплачивать участие

    int participantLimit; //Ограничение на количество участников. Значение 0 - означает отсутствие ограничения

    String title; //Заголовок
}
