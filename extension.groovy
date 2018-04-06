import groovy.transform.Canonical
import org.springframework.beans.BeansException
import org.springframework.beans.factory.config.BeanPostProcessor
import org.sherlock.s01.Order
import org.sherlock.s01.PrintеrStation

import javax.annotation.PostConstruct

beans {
    smokingRoom SmokingRoom
    conversionServiceBPP ConversionService
}

class SmokingRoom {
    @PostConstruct
    def ventilationSystemOn(){
        println 'getting this smoke out!'
    }
}

@Canonical
class ConversionService implements BeanPostProcessor {

    @Override
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals('printеrStation')) {
            return new PrintеrStation() {
                @Override
                void print(Order order) {
                    String text = order.getBody()
                    text-=~/(?s)(spring).*?(spring)/
                    order.setBody(text)
                    super.print(order)
                }
            }
        } else {
            bean
        }
    }
}