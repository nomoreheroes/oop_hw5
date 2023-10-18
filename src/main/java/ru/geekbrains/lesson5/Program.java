package ru.geekbrains.lesson5;

import ru.geekbrains.lesson5.models.TableModel;
import ru.geekbrains.lesson5.presenters.BookingPresenter;
import ru.geekbrains.lesson5.presenters.Model;
import ru.geekbrains.lesson5.presenters.View;
import ru.geekbrains.lesson5.views.BookingView;

import java.util.Date;

public class Program {

    /**
     * TODO: ДОМАШНЯЯ РАБОТА
     *  метод changeReservationTable должен заработать!
     * @param args
     */
    public static void main(String[] args) {

        Model tableModel = new TableModel();
        View bookingView = new BookingView();
        BookingPresenter presenter = new BookingPresenter(tableModel, bookingView);
        presenter.updateUIShowTables();
        bookingView.reservationTable(new Date(), 2, "Станислав");
        bookingView.deleteReservationTable(1001);
        bookingView.reservationTable(new Date(), 2, "Андрей");
        bookingView.changeReservationTable(1002, new Date(), 3, "Андрей");

    
    }

}

abstract class Fruit{

}

class Apple extends Fruit{

}

class Orange extends Fruit{

}

class Box<T extends Fruit>{

    public void move(Box<T> otherBox){
        //...
    }

}
