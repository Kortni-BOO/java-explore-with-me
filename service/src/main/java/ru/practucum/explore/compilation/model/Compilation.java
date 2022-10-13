package ru.practucum.explore.compilation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.practucum.explore.events.model.Event;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "compilations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Compilation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToMany
    @JoinTable(
            name = "compilations_events",
            joinColumns = @JoinColumn(name = "compilation_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    Set<Event> events; //Список событий входящих в подборку(в одном экземпляре)

    @Column(name = "pinned")
    Boolean pinned; //Закреплена ли подборка на главной странице сайта

    @Column(name = "title")
    String title; //Заголовок подборки
}
