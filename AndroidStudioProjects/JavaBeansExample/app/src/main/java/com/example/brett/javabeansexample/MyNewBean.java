package com.example.brett.javabeansexample;

import java.io.Serializable;

/**
 * Created by Brett on 10/28/2014.
 **/
public class MyNewBean implements Serializable
{
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        MyNewBean myNewBean = (MyNewBean) o;

        if (someBoolean != myNewBean.someBoolean)
            return false;
        if (someInt != myNewBean.someInt)
            return false;
        if (Float.compare(myNewBean.somefloat, somefloat) != 0)
            return false;
        if (someString != null ? !someString.equals(myNewBean.someString) : myNewBean.someString != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = someInt;
        result = 31 * result + (someString != null ? someString.hashCode() : 0);
        result = 31 * result + (somefloat != +0.0f ? Float.floatToIntBits(somefloat) : 0);
        result = 31 * result + (someBoolean ? 1 : 0);
        return result;
    }

    private static final long serialVersionUID = -82728700752256581L;
    private int someInt;
    private String someString;
    private float somefloat;
    private boolean someBoolean;

    public MyNewBean()
    {
        this.someInt = 0;
        this.someBoolean = false;
        this.someString = "";
        this.somefloat = 0;
    }

    public float getSomefloat() {
        return somefloat;
    }

    public void setSomefloat(float somefloat) {
        this.somefloat = somefloat;
    }

    public boolean isSomeBoolean() {
        return someBoolean;
    }

    public void setSomeBoolean(boolean someBoolean) {
        this.someBoolean = someBoolean;
    }

    public String getSomeString() {

        return someString;
    }

    public void setSomeString(String someString) {
        this.someString = someString;
    }

    public int getSomeInt()
    {
        return someInt;
    }

    public void setSomeInt(int someInt)
    {
        this.someInt = someInt;
    }




}
