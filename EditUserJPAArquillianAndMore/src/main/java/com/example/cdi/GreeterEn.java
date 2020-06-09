package com.example.cdi;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

// @Dependent // not needed when empty beans.xml present in WEB-INF
@EN
@Stateless
public class GreeterEn implements IGreeter {
    @Resource SessionContext context;

    public String greet(String name) {
        String principalName = context.getCallerPrincipal().getName();
        return name != null ? "Hello " + name + principalName : "Hello stranger";
    }
}
