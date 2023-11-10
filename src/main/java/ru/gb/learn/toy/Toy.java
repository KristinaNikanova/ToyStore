package ru.gb.learn.toy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Toy {
    private String name;
    private float weight;
    @Setter
    private int amount;
}
