package top.yms.server.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;


public class IdGenerator {

    /**
     * 生成16位的唯一id
     *  时间戳+3位(1-999)的数字
     * @return
     */
    public static long getArticleId() {
        long id = System.currentTimeMillis()*1000+(ThreadLocalRandom.current().nextInt(999) + 1);
        return id;

    }

    /**
     * 生成15位的唯一id
     *  时间戳+2位(1-99)的数字
     * @return
     */
    public static long getTagId() {
        long id = System.currentTimeMillis()*1000+(ThreadLocalRandom.current().nextInt(99) + 1);
        return id;

    }

}
