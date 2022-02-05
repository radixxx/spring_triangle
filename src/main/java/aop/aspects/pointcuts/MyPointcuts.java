package aop.aspects.pointcuts;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {

    @Pointcut("execution(* gett*())")
    public void allGetMethods(){}

    @Pointcut("execution(* addd*(..))")
    public void allAddMethods(){}

}
