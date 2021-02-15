package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Ticket implements Comparable<Ticket> {
    private int id;
    private String departure;
    private String arrival;
    private int runTime;
    private int price;
    @Override
    public int compareTo(Ticket o) {
        return price - o.price;
    }

}
