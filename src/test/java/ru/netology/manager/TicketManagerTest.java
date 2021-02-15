package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private TicketManager manager = new TicketManager();
    private Ticket first = new Ticket(1, "DME", "LED", 180, 750);
    private Ticket second = new Ticket(2, "ANT", "SVO", 300, 750);
    private Ticket third = new Ticket(3, "LED", "DME", 250, 700);
    private Ticket forth = new Ticket(4, "SVO", "ANT", 310, 780);
    private Ticket fifth = new Ticket(5, "ANT", "LDE", 120, 500);
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
    void shouldSearchFindAll() {
        String from = "LDE";
        String to = "SVO";
        Ticket[] expected = new Ticket[]{six};
        Ticket[] actual = manager.findAll(from, to);
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchFindAllOtherTicket() {
        String from = "DME";
        String to = "LED";
        Ticket[] expected = new Ticket[]{first};
        Ticket[] actual = manager.findAll(from, to);
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchFindAllManyTicket() {

        String from = "ANT";
        String to = "SVO";
        Ticket[] expected = new Ticket[]{second,seven};
        Ticket[] actual = manager.findAll(from, to);
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldFindNothing() {

        String from = "KZN";
        String to = "LED";
        Ticket[] expected = {};
        Ticket[] actual = manager.findAll(from, to);
        assertArrayEquals(expected, actual);
    }
}