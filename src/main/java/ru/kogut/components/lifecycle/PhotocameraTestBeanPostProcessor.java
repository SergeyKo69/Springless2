package ru.kogut.components.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import ru.kogut.components.Camera;

@Component
public class PhotocameraTestBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Camera){

            System.out.println("Делаю пробное фото!");
            //делаем пробное фото
            ((Camera) bean).doPhotograph();
            System.out.println("Отлично!Работает!");

        }
        return bean;
    }
}
