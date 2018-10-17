import org.sherlock.s01.Order
import org.sherlock.s01.PrintеrStation
import org.springframework.beans.BeansException
import org.springframework.beans.factory.config.BeanPostProcessor

import javax.annotation.PostConstruct

beans {
    smokingRoom SmokingRoom
    printerStation PS
}
class PS extends PrintеrStation{
    @Override
    void print(Order order) {
        order-=/(?s)spring.*?spring/
        super.print(order)
    }
}
class SmokingRoom {
    @PostConstruct
    def ventilationSystemOn() {
        println 'getting this smoke out!'
    }
}
