package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.domain.TicketByPriceAscComparator;

import static org.junit.jupiter.api.Assertions.*;

class TicketAndPriceManagerTest {
    private TicketManager manager = new TicketManager();
    private Ticket first = new Ticket(1, "DME", "LED", 180, 750);
    private Ticket second = new Ticket(2, "ANT", "SVO", 300, 750);
    private Ticket third = new Ticket(3, "ANT", "SVO", 250, 700);
    private Ticket forth = new Ticket(4, "SVO", "ANT", 310, 780);
    private Ticket fifth = new Ticket(5, "ANT", "SVO", 120, 500);
    private Ticket six = new Ticket(6, "LDE", "SVO", 150, 600);
    private Ticket seven = new Ticket(7, "ANT", "SVO", 320, 850);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(six);
        manager.add(seven);
    }
    @Test
    void shouldFindAll() {
        Ticket[] actual = manager.findAll("ANT", "SVO", new TicketByPriceAscComparator());
        Ticket[] expected = {
              fifth, third, second,seven
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindNothing() {
        Ticket[] actual = manager.findAll("KZN", "LED", new TicketByPriceAscComparator());
        Ticket[] expected = {};
        assertArrayEquals(expected, actual);
    }

}