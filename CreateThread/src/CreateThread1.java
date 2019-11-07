public class CreateThread1 {
    private static class MyThread extends Thread{
        private int n=0;
        @Override
        public void run(){
            while(n<10){
                System.out.println(n);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                n++;
            }
        }
    }
    private static class Source{
        private int n=0;
    }
    private static class MyThread2 extends Thread{
        private Source resource;

        MyThread2(Source resource) {
            this.resource = resource;
        }

        @Override
        public void run() {
            while (resource.n < 10) {
                System.out.println(resource.n);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                resource.n++;
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1=new MyThread();
        Thread thread2=new MyThread();
        thread1.start();
        thread2.start();
    }

}
