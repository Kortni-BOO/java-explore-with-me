package ru.practucum.explore.participationRequest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.practucum.explore.events.model.Event;
import ru.practucum.explore.participationRequest.enums.Status;
import ru.practucum.explore.user.model.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParticipationRequestDto {
    long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime created; //Дата и время создания заявки

    Event event; //Идентификатор события

    User requester; //Идентификатор пользователя, отправившего заявку

    Status status;//Статус заявки
}
