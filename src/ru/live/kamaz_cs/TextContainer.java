package ru.live.kamaz_cs;

import java.io.FileWriter;
import java.io.IOException;

@SaveTo(path = "file.txt")
class TextContainer {
    String text = "Hi man :))";

    @Saver
    public void save(String tr) {
        try (FileWriter writer = new FileWriter(tr)) {
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Save text: " + text);
    }
}
