package cmd;

import java.io.File;
import java.security.SecureRandom;

/**
 * 复习
 * 从已做过的题中随机抽出一道
 *
 * @author fengxxc
 * @date 2021-08-17
 */
public class Review {
    static enum Difficult {
        Junior("junior"),
        Medium("medium"),
        Hard("hard");
        public String val = "";
        Difficult(String val) { this.val = val; }
    }
    public static String getRandom(Review.Difficult difficult) {
        final String dir = System.getProperty("user.dir") + File.separator + "src" + File.separator + difficult.val;
        final String[] list = new File(dir).list();
        final int i = new SecureRandom().nextInt(list.length);
        return list[i];
    }
    public static void main(String[] args) {
        final String topic = getRandom(Difficult.Junior);
        System.out.println("(" + topic + ".main(" + topic + ":0))");
    }
}
