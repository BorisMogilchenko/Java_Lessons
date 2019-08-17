package ru.quazar.l03;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Book {
    private String title;
    private Boolean isBusy;
}
