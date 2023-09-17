package geek_java_oop_lesson5.presenters;

// Импорт зависимостей
import geek_java_oop_lesson5.models.Table;

import java.util.Collection;
import java.util.Date;

// Интерфейс Model, представляющий модель в архитектуре MVP
public interface Model {
    // Метод для загрузки таблиц
    Collection<Table> loadTables();

    // Метод для бронирования стола
    int reservationTable(Date reservationDate, int tableNo, String name);
}
