package src.CoreJava.MultiThreading;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

public class CallableFuture {

    public Callable<Integer> getTask(int a, int b){
        return () -> a+b;
    }
    public static void main(String[] args) {

//        CallableFuture callableFuture = new CallableFuture();
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        try{
//            Future<Integer> result  = executor.submit(callableFuture.getTask(10,17));
//            System.out.println(result.isDone());
//            System.out.println("Output is "+ result.get());
//            System.out.println(result.isDone());
//        }
//        catch(Exception e){
//
//        }
//        finally {
//            executor.close();
//        }

//        try(ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,10,2,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(40))){
//            for(int i=1;i<=50;i++){
//                threadPoolExecutor.execute(() -> {
//                    System.out.println("Doing some task");
//                    try {
//                        Thread.sleep(5000);
//                    } catch(InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    System.out.println("Task is done");
//                });
//            }
//            threadPoolExecutor.shutdown();
//        }

// --------------------------------------------------------------------------------

//        try(ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,10,2,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(40))){
//            throw new Exception("Try block exception");
//        }
//        catch(Exception e){
//            System.out.println(e.getMessage());
//            for(Throwable t : e.getSuppressed()){
//                System.out.println(t.getMessage());
//            }
//        }
// --------------------------------------------------------------------------------

//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,10,2,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(40));
//        Future<?> future = threadPoolExecutor.submit(()->{
//            System.out.println("Hello from runnable");
//        });
//        try{
//            Object object = future.get();
//            System.out.println(object==null);
//        }
//        catch(Exception ex){
//            ex.printStackTrace();
//        }
// --------------------------------------------------------------------------------
//        System.out.println(Thread.currentThread().getName());
//        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(()-> {
//            System.out.println(Thread.currentThread().getName());
//            return "Hello";
//        }); // If no executor is provided then shared Forked-Join pool executor will be used.

//        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(()-> {
//            System.out.println(Thread.currentThread().getName());
//            return "Hello";
//        },Executors.newSingleThreadExecutor());

//        CompletableFuture<String> completableFuture3 = CompletableFuture.supplyAsync(()-> {
//            System.out.println(Thread.currentThread().getName());
//            return "Hello";
//        }).thenApply(str -> str+" Dhruba");
//        try{
//            String result = completableFuture3.get();
//            System.out.println(result);
//        } catch(InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
//---------------------------------------------------------------------------------------------
//
//        CompletableFuture<String> completableFuture4 = CompletableFuture.supplyAsync(()-> {
//            System.out.println(Thread.currentThread().getName());
//            return "Hello";
//        }).thenCompose(str -> {                        //thenCompose is for bringing some ordering in Async tasks.
//            return CompletableFuture.supplyAsync(() -> str+" Dhruba");
//        });
//        try{
//            String result = completableFuture4.get();
//            System.out.println(result);
//        } catch(InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
//----------------------------------------------------------------------------------------------

//        CompletableFuture<String> completableFuture5 = CompletableFuture.supplyAsync(()-> {
//            System.out.println("Task1 is done");
//            return "Hello";
//        }).thenCompose(str ->
//             CompletableFuture.supplyAsync(() -> {
//                System.out.println("Task2 is done");
//                return str+" Dhruba";}))
//                .thenComposeAsync(str -> CompletableFuture.supplyAsync(() -> {
//                            System.out.println("Task3 is done");
//                            return str+"!";}))
//                .thenComposeAsync(str-> CompletableFuture.supplyAsync(()->{
//                    System.out.println("Task4 is done");
//                    return str+"!";}));
//        try{
//            String result = completableFuture5.get();
//            System.out.println(result);
//        } catch(InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }


//        thenAccept/thenAcceptAsync generally end stage, in the chain of Async operation and
//        it doesn't return anything.
//        CompletableFuture<Void> completableFuture6 = CompletableFuture.supplyAsync(()-> {
//            System.out.println("Task1 is done");
//            return "Hello";})
//                .thenAccept(str -> System.out.println("All tasks are done"));

//        --------------------------------------------------------------------------------

        /* thenCombine/thenCombineAsync is used to combine result of 2 Completable Future. */
        CompletableFuture<String> completableFuture7 = CompletableFuture.supplyAsync(()-> {
            System.out.println("Task1 is done");
            return "Hello";});
        CompletableFuture<String> completableFuture8 = CompletableFuture.supplyAsync(()-> {
            System.out.println("Task2 is done");
            return "Dhruba";});

        CompletableFuture<String> combineResult = completableFuture7.thenCombine(completableFuture8, (str1,str2) -> str1+" "+str2);
        try{
            String result = combineResult.get();
            System.out.println(result);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
