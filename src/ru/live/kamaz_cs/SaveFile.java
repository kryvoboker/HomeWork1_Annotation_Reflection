package ru.live.kamaz_cs;

import java.lang.reflect.Method;

public class SaveFile {

    public static String test(Class<?>... ls) {
        TextContainer tx = new TextContainer();
        final Class<?> cls = TextContainer.class;
        try {
            if (cls.isAnnotationPresent(SaveTo.class));
            SaveTo st = cls.getAnnotation(SaveTo.class);
            System.out.println("SaveTo: " + st.path());
            Method[] methods = cls.getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Saver.class)) {
                    Object ob = method.invoke(tx, st.path());
                    System.out.println("Saver: " + method.getName());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return "File saved";
    }
}
