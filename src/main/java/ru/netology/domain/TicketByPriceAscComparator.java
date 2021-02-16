package ru.netology.domain;

import java.util.Comparator;

public class TicketByPriceAscComparator implements Comparator<Ticket> {
        public int compare(Ticket t1, Ticket t2) {
            return t1.getPrice() - t2.getPrice();
        }
    }

