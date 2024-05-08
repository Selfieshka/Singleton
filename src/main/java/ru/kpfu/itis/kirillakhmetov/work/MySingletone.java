package ru.kpfu.itis.kirillakhmetov.work;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MySingletone {

    private static MySingletone instance;

    private MySingletone() {}

    public static MySingletone getInstance() {
        if (instance == null) {
            synchronized (MySingletone.class) {
                if (instance == null) {
                    instance = new MySingletone();
                }
            }
        }
        return instance;
    }

    public List<Integer> read(String name) {
        List<Integer> bytes = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(name)) {
            int byteRead = 0;

            while ((byteRead = fis.read()) != -1) {
                bytes.add(byteRead);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return bytes;
    }

    public void write(List<Integer> list, String name) {
        try (FileOutputStream fos = new FileOutputStream(name)){
            for (Integer integer : list) {
                fos.write(integer);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
