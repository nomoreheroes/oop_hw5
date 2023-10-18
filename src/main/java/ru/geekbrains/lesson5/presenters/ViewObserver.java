package ru.geekbrains.lesson5.presenters;

import java.util.Date;

public interface ViewObserver {

    void onReservationTable(Date orderDate, int tableNo, String name);
    void onDeleteReservationTable(int reservationNo);
    void onChangeReservationTable(int oldReservation, Date orderDate, int tableNo, String name);
}
