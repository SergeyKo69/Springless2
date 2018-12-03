package ru.kogut.components.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import ru.kogut.annotation.UnproducableCamera;

@Component
public class UnproducableCameraBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();

        for (String name : beanDefinitionNames) {

            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);

            String className = beanDefinition.getBeanClassName();

            try {

                Class<?> beanClass = Class.forName(className);

                UnproducableCamera annotation = beanClass.getAnnotation(UnproducableCamera.class);

                if (annotation != null) {

                    Class usingCameraRollName = annotation.usingCameraClass();

                    beanDefinition.setBeanClassName(usingCameraRollName.getName());
                }

            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

}
