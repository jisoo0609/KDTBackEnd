package December.T231227.iocexam.src.main.java.sample.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import December.T231227.iocexam.src.main.java.sample.Dice;
import December.T231227.iocexam.src.main.java.sample.Game;
import December.T231227.iocexam.src.main.java.sample.MyBean;
import December.T231227.iocexam.src.main.java.sample.config.DiceGameConfig;
import December.T231227.iocexam.src.main.java.sample.config.MyBeanConfig;

public class SpringExam02 {
    public static void main(String[] args) {
        System.out.println("ApplicationContext 생성전");
        ApplicationContext context = new AnnotationConfigApplicationContext(DiceGameConfig.class);
        System.out.println("ApplicationContext 생성후");

//       Dice dice = context.getBean(Dice.class);
//
//        System.out.println(dice.getNumber());

        Game game = context.getBean(Game.class);
        game.play();
    }
}
