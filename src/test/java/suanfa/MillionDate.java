package suanfa;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;

import javax.swing.text.AbstractDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * 百万条数据中找出缺失的数据
 *
 * @author Mechrevo
 * @version v1.0
 * 2020/3/24 22:48
 */
public class MillionDate {
    static final int TITLE = 10000000;
    static final int MISS = 2;
    static final int NUM = TITLE - MISS;
    static final List<Info> dateList = new ArrayList<>(NUM);

    // 填写百万条数据
    static {
        Random random = new Random();
        // 由于id从1开始，随机数范围(0，TITLE]
        int anInt_1 = random.nextInt(TITLE) + 1;
        int anInt_2;
        // 获取第二个非重复的随机数
        do {
            anInt_2 = random.nextInt(TITLE) + 1;
        } while (anInt_1 == anInt_2);
        // 输出数字
         System.out.println("anInt_1=" + anInt_1 + ", anInt_2=" + anInt_2);
        String prefix = "com20200324-";
        for (int i = 1; i <= (TITLE); i++) {
            if (i == anInt_1 || i == anInt_2) {
                continue;
            }
            String format = String.format("%07d", i);// 0代表前面要补的字符, 10代表字符串长度, d表示参数为整数类型
            dateList.add(new Info(prefix + format, "00"));
        }
        System.out.println("数据添加完成！！！");
    }

    public static void main(String[] args) {
        // 思路1：将后面的7位数字每位分一组，找到每组缺失的数字，然后全排列，去排除
        // 思路2：排序：先将最后的字符串转int，然后排序装入list中，然后比较角标与素质是否一样，不一样则是缺失
        // 思路3：

        // 开始计时hutool工具类
        TimeInterval timer = DateUtil.timer();

        // 思路1
//        timer.interval();//花费毫秒数
        long l1 = timer.intervalRestart();//返回花费时间，并重置开始时间
        System.out.println("思路1花费时间："+ l1);
        // 思路2
        idea2();
        long l2 = timer.intervalRestart();//返回花费时间，并重置开始时间
        System.out.println("思路2花费时间："+ l2);
        timer.intervalMinute();//花费分钟数

    }

    // 思路1：将后面的7位数字每位分一组，找到每组缺失的数字，然后全排列，去排除
    private static void idea1(){}

    // 思路2：排序：先将最后的字符串转int，然后排序装入list中，然后比较角标与素质是否一样，不一样则是缺失
    private static void idea2(){
        Stream<Info> stream = dateList.stream();
        int[] ints = stream.mapToInt(info -> {
            return Integer.valueOf(info.getID().substring(12));
        }).toArray();
        // temp
        int temp = 1;
        for (int i = 1; i <= ints.length +2; i++) {
            if ((ints[i-temp]) != i) {
                System.out.println("缺失数字：" + i);
                temp++;
            }
            if (temp==3) {
                break;
            }
        }

    }


    static class Info {
        private String ID;
        private String name;

        public Info() {
        }

        public Info(String ID, String name) {
            this.ID = ID;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Info{ID='" + ID + ", name='" + name + '}';
        }

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
