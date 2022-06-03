package top.yms.server.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
public class ApplicationOther implements CommandLineRunner, ApplicationRunner, ApplicationListener<ContextRefreshedEvent>{
    @Override
    public void run(String... args) throws Exception {
        System.out.println("String... args ==> ["+ Arrays.toString(args) +"]");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationArguments args ==> "+args.toString());
    }

    //这个ApplicationListener.onApplicationEvent什么时候回被调用?
    //    当初始化Spring容器时会调用 AbstractApplicationContext.refresh()方法, => 调用 finishRefresh()方法，finishRefresh(),会调用publishEvent()
    //publishEvent() => ApplicationEventMulticaster.multicastEvent => ApplicationListener.onApplicationEvent
    //
    //    这个AbstractApplicationContext是Spring容器. 所以如果存在多个Spring容器，那么这个方法ApplicationListener.onApplicationEvent()会
    //被调用多次. 记得之前我在做Bidding项目的时候, 初始化Netty,用的就是这个ApplicationListener.onApplicationEvent()进行初始化,后面出现很多问题.
    //比如说 被多次初始化, 还有拿不到Spring容器(因为并不是所有Spring容器都初始化完毕了)等
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("onApplicationEvent ===> "+contextRefreshedEvent.toString());
    }



}
