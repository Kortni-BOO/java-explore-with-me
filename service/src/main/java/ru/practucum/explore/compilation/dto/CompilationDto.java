package ru.practucum.explore.compilation.dto;

import lombok.*;
import ru.practucum.explore.events.model.Event;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompilationDto {
    long id;

    Set<Event> events; ////Список событий входящих в подборку

    @NonNull
    Boolean pinned; //Закреплена ли подборка на главной странице сайта

    @NonNull
    @NotBlank
    String title; //Заголовок подборки
}
