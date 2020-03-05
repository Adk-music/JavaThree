package geekbrains.lessons.lesson8;

//•	Создать три потока, каждый из которых выводит определенную букву(A, B и C) 5 раз, порядок должен быть именно
// ABСABСABС. Используйте wait/notify/notifyAll.
public class LessonFour {
    static volatile char someChar = 'A';
    static Object someThreads = new Object();

    static class WaitNotifyClass implements Runnable {
        private char currentLetter;
        private char nextLetter;

        public WaitNotifyClass(char currentLetter, char nextLetter) {
            this.currentLetter = currentLetter;
            this.nextLetter = nextLetter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                synchronized (someThreads) {
                    try {
                        while (someChar != currentLetter)
                            someThreads.wait();
                        System.out.print(currentLetter);
                        someChar = nextLetter;
                        someThreads.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        new Thread(new WaitNotifyClass('A', 'B')).start();
        new Thread(new WaitNotifyClass('B', 'C')).start();
        new Thread(new WaitNotifyClass('C', 'A')).start();
    }
}
