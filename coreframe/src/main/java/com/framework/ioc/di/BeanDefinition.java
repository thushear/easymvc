package com.framework.ioc.di;

/**
 * Created by Administrator on 2015/8/5.
 */
public class BeanDefinition {

     static final String SINGLETON_SCOPE = "singleton";

    static final String PROTOTYPE_SCOPE = "prototype";

    private String id;

    private String scope = SINGLETON_SCOPE;

    private String clazz;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "BeanDefinition{" +
                "id='" + id + '\'' +
                ", scope='" + scope + '\'' +
                ", clazz='" + clazz + '\'' +
                '}';
    }
}
