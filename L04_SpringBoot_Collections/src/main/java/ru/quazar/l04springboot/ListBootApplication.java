package ru.quazar.l04springboot;

import lombok.Data;
import ru.quazar.l04springboot.model.CustomList;
import ru.quazar.l04springboot.service.MinimumClassService;
import ru.quazar.l04springboot.service.MaximumClassService;

import java.util.Random;

/**
 * Make generic class with parameter T. source file by path, find substring "Hello, guys!".
 * Write to the file "homework_02_output.txt" twenty symbols behind and
 * twenty symbols after finding substring.
 *
 * @version $Id: FileToStream.java,v 1.0 2019-08-15 23:30:42 Exp $
 * @author  <A HREF="mailto:boris.mogilchenko@yandex.ru">Boris Mogilchenko</A>
 */

@Data
public class ListBootApplication {

    private MinimumClass minClass;
    private MaximumClass maxClass;
    private static final int minRange = 0;
    private static final int maxRange = 999;
    private static final int cycleCounter = 100;

    public static void main(String[] args) {
        int rndNumber;

        CustomList list = new CustomList();
        for (int i = minRange; i < cycleCounter; i++) {
            Random rnd = new Random();
            rndNumber = minRange + rnd.nextInt(maxRange - minRange + 1);
            list.add(rndNumber);
        }

        MinimumClass<Integer> minClass = new MinimumClass<>();
        MaximumClass<Integer> maxClass = new MaximumClass<>();

        System.out.println("Минимальное значение:  " + (int) minClass.minElement(list));
        System.out.println("Максимальное значение: " + (int) maxClass.maxElement(list));
    }
}
