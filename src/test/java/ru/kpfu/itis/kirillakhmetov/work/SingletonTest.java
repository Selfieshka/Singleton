package ru.kpfu.itis.kirillakhmetov.work;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SingletonTest {
    @Test
    public void testSingleton() {
        MySingletone singleton1 = MySingletone.getInstance();
        MySingletone singleton2 = MySingletone.getInstance();

        Assertions.assertSame(singleton1, singleton2);
    }
}
