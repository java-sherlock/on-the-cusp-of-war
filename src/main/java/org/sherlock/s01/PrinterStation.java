package org.sherlock.s01;

import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
public class PrinterStation {
    public void print(Order order) {

        for (int i = 0; i < order.getAmount(); i++) {
            System.out.println("************************");
            System.out.println(order.getTitle());
            System.out.println(order.getBody());
            System.out.println("************************");
        }
    }
}
