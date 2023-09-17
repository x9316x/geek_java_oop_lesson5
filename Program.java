package geek_java_oop_lesson5;

import geek_java_oop_lesson5.models.TableModel;
import geek_java_oop_lesson5.presenters.BookingPresenter;
import geek_java_oop_lesson5.views.BookingView;

import java.util.Date;

public class Program {

    /**
     * Главная точка входа в программу.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        // Создание модели и представления
        TableModel model = new TableModel();
        BookingView view = new BookingView();

        // Создание презентера и связывание его с моделью и представлением
        BookingPresenter bookingPresenter = new BookingPresenter(model, view);

        // Обновление интерфейса с информацией о столиках
        bookingPresenter.updateTablesUI();

        // Бронирование столика
        view.reservationTable(new Date(), 1, "Элендил");
        view.reservationTable(new Date(), 2, "Вениамин");
        view.reservationTable(new Date(), 3, "Исильдур");

        System.out.println("---------------------------");

        // Изменение бронирование
        int newReservationNo = view.changeReservationTable(101, new Date(), 1, "Станислав");
        if (newReservationNo > 0) {
            System.out.println("Бронирование успешно изменено. Новый номер бронирования: " + newReservationNo);
        } else {
            System.out.println("Ошибка при изменении бронирования.");
        }
    }
}
