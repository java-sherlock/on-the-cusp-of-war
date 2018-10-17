import org.sherlock.s01.Order
import org.sherlock.s01.PrintеrStation
import org.springframework.beans.BeansException
import org.springframework.beans.factory.config.BeanPostProcessor

import javax.annotation.PostConstruct

beans {
    smokingRoom SmokingRoom
    bpp ConversionService
//    printеrStation PS
}
/*
class PS extends PrintеrStation{
    public void print(Order order) {

        order.body-=~/(?s)spring.*?spring/
        super.print(order)
    }

}
*/
class ConversionService implements BeanPostProcessor{
    @Override
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        println beanName
        if (beanName.equals("printеrStation") || bean.class.name == 'PrinterStation') {
            println "PrinterStation will be replaced now"
            return new PrintеrStation(){
                @Override
                void print(Order order) {
                    println "new PrinterStation is working"
                    order.body-=~/(?s)spring.*?spring/
                    super.print(order)
                }
            }
        }
        return bean

    }
}


class SmokingRoom {
    @PostConstruct
    def ventilationSystemOn() {
        println 'getting this smoke out!'
    }
}