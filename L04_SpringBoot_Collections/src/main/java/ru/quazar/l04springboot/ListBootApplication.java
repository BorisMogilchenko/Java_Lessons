package ru.quazar.l04springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.quazar.l04springboot.model.CustomList;
import ru.quazar.l04springboot.repository.CustomListRepository;
import ru.quazar.l04springboot.service.CheckArgsService;
import ru.quazar.l04springboot.service.MaximumClassService;
import ru.quazar.l04springboot.service.MinimumClassService;

import java.util.Random;

/**
 * Make generic class with parameter T. source file by path, find substring "Hello, guys!".
 * Write to the file "homework_02_output.txt" twenty symbols behind and
 * twenty symbols after finding substring.
 *
 * @version $Id: ListBootApplication.java,v 1.0 2019-08-15 23:30:42 Exp $
 * @author  <A HREF="mailto:boris.mogilchenko@yandex.ru">Boris Mogilchenko</A>
 */

@SpringBootApplication
public class ListBootApplication {

//    private MinimumClass minClass;
//    private MaximumClass maxClass;
    private static final int minRange = 0;
    private static final int maxRange = 999;

    public static void main(String[] args) {
        SpringApplication.run(ListBootApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(CustomListRepository repository) {
        return args -> {
            final int cycleCounter = CheckArgsService.checkIteration(args);
            CustomList list = new CustomList();
            for (int i = minRange; i < cycleCounter; i++) {
                Random rnd = new Random();
                int rndNumber = minRange + rnd.nextInt(maxRange - minRange + 1);
                list.add(rndNumber);
            }
            repository.save(list);

            MinimumClassService<Integer> minClass = new MinimumClassService<>();
            MaximumClassService<Integer> maxClass = new MaximumClassService<>();

            System.out.println("Минимальное значение:  " + (int) minClass.minElement(list));
            System.out.println("Максимальное значение: " + (int) maxClass.maxElement(list));
        };
    }
}
