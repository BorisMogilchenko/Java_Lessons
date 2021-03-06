package ru.quazar.l05springboot.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Model IoStream witch links controller with services, repositories.
 *
 * @version $Id: IoStream.java,v 1.0 2019-08-20 23:30:42 Exp $
 * @author  <A HREF="mailto:boris.mogilchenko@yandex.ru">Boris Mogilchenko</A>
 */

@Data
@NoArgsConstructor
@Entity
public class FileToStream {

    @Id
    @GeneratedValue
    private String readingTarget;
    private String targetPath;
    private String fileName;
}
