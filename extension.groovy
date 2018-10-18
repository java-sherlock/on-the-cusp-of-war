import org.sherlock.s01.Order
import org.sherlock.s01.РrintеrStation
import org.springframework.beans.BeansException
import org.springframework.beans.factory.config.BeanPostProcessor

import javax.annotation.PostConstruct

beans {
    smokingRoom SmokingRoom
    bpp PS
}

class PS implements BeanPostProcessor{
    @Override
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        println beanName
        if (beanName == 'рrintеrStation') {
            return new РrintеrStation(){
                @Override
                void print(Order order) {
                    order.body-=~/(?s)spring.*?spring/
                    super.print(order)
                }
            }
        }
    }
}




class SmokingRoom {
    @PostConstruct
    def ventilationSystemOn() {
        println 'getting this smoke out!'
    }
}