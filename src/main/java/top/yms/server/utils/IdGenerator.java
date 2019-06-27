package top.yms.server.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class IdGenerator {

    public static long get() {
        long id = System.currentTimeMillis()*1000+(ThreadLocalRandom.current().nextInt(999) + 1);
        return id;

    }

}
