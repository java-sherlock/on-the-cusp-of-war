import org.sherlock.s01.Order
import org.sherlock.s01.РrintеrStation
import org.springframework.beans.BeansException
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct

beans {
    smokingRoom SmokingRoom
}


class SmokingRoom {
    @PostConstruct
    def ventilationSystemOn() {
        println 'getting this smoke out!'
    }
}