
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Создаю потоки...");

        // Создаем пул потоков фиксированного размера
        // В данном случае у нас будет 4 потока
        final ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        // Создаем задачу с результатом типа String
        Callable<Integer> myCallable1 = new MyCallable("поток №1");
        Callable<Integer> myCallable2 = new MyCallable("поток №2");
        Callable<Integer> myCallable3 = new MyCallable("поток №3");
        Callable<Integer> myCallable4 = new MyCallable("поток №4");

        // Отправляем задачу на выполнение в пул потоков
        final Future<Integer> task1 = pool.submit(myCallable1);
        final Future<Integer> task2 = pool.submit(myCallable2);
        final Future<Integer> task3 = pool.submit(myCallable3);
        final Future<Integer> task4 = pool.submit(myCallable4);

        // Получаем результат
        final int resultOfTask1 = task1.get();
        final int resultOfTask2 = task2.get();
        final int resultOfTask3 = task3.get();
        final int resultOfTask4 = task4.get();
        System.out.println("поток №1 количество отправленных сообщений " + resultOfTask1);
        System.out.println("поток №2 количество отправленных сообщений " + resultOfTask2);
        System.out.println("поток №3 количество отправленных сообщений " + resultOfTask3);
        System.out.println("поток №4 количество отправленных сообщений " + resultOfTask4);

        List<Callable<Integer>> tasks = new ArrayList<>();
        tasks.add(myCallable1);
        tasks.add(myCallable2);
        tasks.add(myCallable3);
        tasks.add(myCallable4);

        int x = pool.invokeAny(tasks);
        System.out.println("Метод invokeAny для получения результата " + x);

        // Завершаем работу пула потоков
        System.out.println("Завершаю все потоки...");
        pool.shutdown();

    }
}

