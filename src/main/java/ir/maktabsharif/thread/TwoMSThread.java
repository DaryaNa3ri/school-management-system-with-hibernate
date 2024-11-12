package ir.maktabsharif.thread;
import ir.maktabsharif.repository.StudentRepository;
import lombok.AllArgsConstructor;

import java.lang.Thread;

@AllArgsConstructor
public class TwoMSThread<T> extends Thread {
    private StudentRepository repository;



    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(repository.findAll().size());
        }


    }

}
