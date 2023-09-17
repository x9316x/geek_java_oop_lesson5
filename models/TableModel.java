package geek_java_oop_lesson5.models;

import geek_java_oop_lesson5.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

// Класс TableModel реализует интерфейс Model и представляет собой модель данных столов
public class TableModel implements Model {

    // Коллекция столов
    private Collection<Table> tables;

    /**
     * Получить список всех столиков
     * @return коллекция столиков
     */
    public Collection<Table> loadTables(){
        // Если таблицы еще не были инициализированы, инициализировать их
        if (tables == null){
            tables = new ArrayList<>();
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }

    /**
     * Бронирование столика
     * @param reservationDate дата
     * @param tableNo номер столика
     * @param name имя клиента
     * @return номер брони
     */
    public int reservationTable(Date reservationDate, int tableNo, String name){
        for (Table table : loadTables()) {
            if (table.getNo() == tableNo){
                Reservation reservation = new Reservation(reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        return -1;
    }

    /**
     * Поменять бронь столика
     * @param oldReservation номер старого резерва (для снятия)
     * @param reservationDate дата резерва столика
     * @param tableNo номер столика
     * @param name Имя
     */
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){
        // Ищем столик с указанным номером
        Optional<Table> tableOpt = tables.stream().filter(t -> t.getNo() == tableNo).findFirst();

        if (tableOpt.isPresent()) { // Если столик найден
            Table table = tableOpt.get();

            // Удаляем старое бронирование
            table.getReservations().removeIf(r -> r.getId() == oldReservation);

            // Создаем новое бронирование и добавляем его к столику
            Reservation newReservation = new Reservation(reservationDate, name);
            table.getReservations().add(newReservation);

            return newReservation.getId(); // Возвращаем идентификатор нового бронирования
        }
        return -1; // Возвращаем -1 в случае ошибки
    }

}
