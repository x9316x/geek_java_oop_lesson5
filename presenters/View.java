package geek_java_oop_lesson5.presenters;

import geek_java_oop_lesson5.models.Table;

import java.util.Collection;

// Интерфейс View, представляющий представление (View) в архитектуре MVP
public interface View {

    /**
     * Отобразить список столиков в представлении
     * @param tables список столиков
     */
    void showTables(Collection<Table> tables);

    /**
     * Регистрация наблюдателя
     * @param observer наблюдатель
     */
    void setObserver(ViewObserver observer);

    /**
     * Распечатать результат бронирования столика
     * @param reservationNo номер бронирования
     */
    void printReservationTableResult(int reservationNo);
}
