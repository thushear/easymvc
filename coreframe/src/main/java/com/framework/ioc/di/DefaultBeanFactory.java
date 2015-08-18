package com.framework.ioc.di;

/**
 * Created by Administrator on 2015/8/6.
 */
public class DefaultBeanFactory {

    private final static BeanDefinitionRegister BEAN_DEFINITION_REGISTER = new BeanDefinitionRegister();

    private final static SingletonRegistry SINGLETON_REGISTRY = new SingletonRegistry();


    public void registerBeanDefiniton(BeanDefinition beanDefinition){
        BEAN_DEFINITION_REGISTER.registerBeanDefiniton(beanDefinition);
    }

    public Object getBean(String name){
        if (!BEAN_DEFINITION_REGISTER.containsBean(name)){
            throw  new RuntimeException();
        }
        BeanDefinition  beanDefinition =   BEAN_DEFINITION_REGISTER.getBeanDefiniton(name);
        //singleton
        if (BeanDefinition.SINGLETON_SCOPE.equalsIgnoreCase(beanDefinition.getScope())){
            if (SINGLETON_REGISTRY.containsSingleton(name)){
                return SINGLETON_REGISTRY.getSingleton(name);
            }
            Object bean =  createBean(beanDefinition);
            SINGLETON_REGISTRY.registerSingleton(name,bean);
            return bean;
        }
        //prototype
        return createBean(beanDefinition);
    }


    public Object createBean(BeanDefinition beanDefinition){
        Object object = null;
        String clazz = beanDefinition.getClazz();
        try {
            object =  Class.forName(clazz).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }

}
