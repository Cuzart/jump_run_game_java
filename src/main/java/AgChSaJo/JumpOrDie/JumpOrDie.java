package AgChSaJo.JumpOrDie;

import java.util.Date;
import java.util.Timer;

public class JumpOrDie {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TestTimerTask(),1000,500);

       /* try {
            System.out.println("Main starts sleeping "+ new Date());
            Thread.sleep(5000);
        }catch (InterruptedException e){
            System.out.println("fail");
        }
        System.out.println("main cancels task");
        timer.cancel();*/


    }
}