
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    private String name;

    public MyCallable(String name) {
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        int count = 0;// кол-во выведенных в консоль сообщений
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(2500);
                System.out.println("Я " + name + ". Всем привет!");
                count++;
            }
        } catch (InterruptedException exc) {

        } finally {
            System.out.printf("%s завершен\n", name);

        }
        return count;
    }
}

