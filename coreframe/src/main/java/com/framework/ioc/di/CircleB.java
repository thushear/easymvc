package com.framework.ioc.di;

/**
 * Created by Administrator on 2015/8/4.
 */
public class CircleB {

    private CircleA circleA;

    public CircleB() {


    }

    public CircleB(CircleA circleA) {
        this.circleA = circleA;
    }

    public void setCircleA(CircleA circleA) {
        this.circleA = circleA;
    }

    public void b(){
        circleA.a();
    }
}
