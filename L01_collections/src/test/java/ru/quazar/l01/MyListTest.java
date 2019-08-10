package ru.quazar.l01;

import org.junit.Assert;
import org.junit.Test;
import ru.quazar.l01.CustomList;
import ru.quazar.l01.Main;

public class MyListTest {

    @Test
    public void getListTest() {
        Assert.assertEquals(256, CustomList.getList());
    }

    @Test
    public void setListTest() {
        Assert.assertNotNull(256, CustomList.setList());
    }

    @Test
    public void MinimumClassTest() {
        Assert.assertTrue(CustomList.removeElement());
    }

}