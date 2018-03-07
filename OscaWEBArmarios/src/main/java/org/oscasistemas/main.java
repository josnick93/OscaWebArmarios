package org.oscasistemas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by José Ángel Caudevílla Casaús on 22/05/2017.
 */
@Component
public class main {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("META-INF/config.xml");

        main p = context.getBean(main.class);
        p.start(args);
    }

    @Autowired
    private MyBean myBean;
    private void start(String[] args) {
        System.out.println("my beans method: " + myBean.getStr());
    }
}

    @Service
    class MyBean {
        public String getStr() {
            return "string";
        }
}
