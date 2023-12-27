package December.T231227.iocexam.src.main.java.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import December.T231227.iocexam.src.main.java.sample.MyBean;

public class MyBeanConfig {
    @Bean
//    @Scope("prototype")
    public MyBean bean(){
        return new MyBean();
    }

//    @Bean
//    public MyBean bean2(){
//        return new MyBean();
//    }
    //<bean id="bean" calss="sample.MyBean" >
}
