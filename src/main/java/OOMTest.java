
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Mechrevo
 * @version v1.0
 * 2020/2/8 20:01
 */
public class OOMTest {

    static List<String[]> list=new ArrayList<>();
    static ExecutorService executor = Executors.newSingleThreadExecutor();
    static String[] str;
    public static void main(String[] args) throws Exception {
        for (;;){
            Thread.sleep(100);
            add();
        }
    }
    private static void add(){
        executor.execute(() -> list.add(addString()));
    }
    private static String[] addString(){
        str=new String[1000];
        for (int i = 0; i < 1000; i++) {
            str[i]=new String(String.valueOf(i));
        }
        return str;
    }
}
