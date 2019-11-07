public class Speed {
    public static void main(String[] args) {
        long begin = System.nanoTime();
        long sum=0;
        long sum1=0;
        long sum2=0;
        for(int i=1;i<=1000000;i++){
            sum=sum+i;
        }
        System.out.println(sum);
        for(int i=1;i<=1000001;i=i+2){

                sum1=sum1+i;

        }
        System.out.println(sum1);

        for(int i=1;i<=100000;i++){
            sum2=sum2+i^2;
        }
        System.out.println(sum2);
        long end = System.nanoTime();
        double s = (end - begin) * 1.0 / 1000 / 1000 / 1000;
        System.out.printf("并发模式: 耗时: %.4f%n", s);
        long begin1 = System.nanoTime();
        Thread thread1=new Thread1();
        Thread thread2=new Thread2();
        Thread thread3=new Thread3();
        thread1.start();
        thread2.start();
        thread3.start();
        long end1 = System.nanoTime();
        double s1 = (end1 - begin1) * 1.0 / 1000 / 1000 / 1000;
        System.out.printf("多线程模式: 耗时: %.4f%n", s1);

    }

    private static class Thread1 extends Thread{
        long sum=0;
        @Override
        public void run(){
            for(int i=1;i<=1000000;i++){
                sum=sum+i;
            }
            System.out.println(sum);
        }
    }
    private static class Thread2 extends Thread{
        long sum1=0;
        @Override
        public void run(){
            for(int i=1;i<=1000001;i=i+2){

                    sum1=sum1+i;

            }
            System.out.println(sum1);
        }
    }
    private static class Thread3 extends Thread{
        long sum2=0;
        @Override
        public void run(){
            for(int i=1;i<=100000;i++){
                sum2=sum2+i^2;
            }
            System.out.println(sum2);
        }
    }
}
