package ru.practucum.explore.events.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import ru.practucum.explore.category.model.Category;
import ru.practucum.explore.events.enums.State;
import ru.practucum.explore.user.model.User;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventFullDto {
    long id;

    @NonNull
    @NotBlank
    String annotation; //Краткое описание

    @NonNull
    Category category; //Категория

    long confirmedRequests; //Количество одобренных заявок на участие в данном событии

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime createdOn; //Дата и время создания события

    String description; //Полное описание события

    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime eventDate; //Дата и время на которые намечено событие

    @NonNull
    User initiator; //Пользователь (краткая информация) UserShortDto

    /**
     * @NonNull
     *
     * location - разобраться
     */

    @NonNull
    Boolean paid; //Нужно ли оплачивать участие

    int participantLimit; //Ограничение на количество участников. Значение 0 - означает отсутствие ограничения

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime publishedOn; //Дата и время публикации события

    Boolean requestModeration; //Нужна ли пре-модерация заявок на участие

    private State state; //Список состояний жизненного цикла события

    @NonNull
    @NotBlank
    String title; //Заголовок

    long views; //Количество просмотров события
}
