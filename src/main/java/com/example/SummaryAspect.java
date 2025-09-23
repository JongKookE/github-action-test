package com.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class SummaryAspect {
    // Main 클래스에서 리턴타입이 void이고, 파라미터가 없긴 메소드들에 대하여 AOP 적용
    // 자동으로 Main 클래스의 main 메소드는 제외 (String[] args 파라미터가 있기 때문)
    @Before("execution(void com.example.Main.*())")
    public void addDetailsStart(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String techBlogName = TechBlogName.valueOf(methodName.toUpperCase()).getName();
        Main.sb.append("<details>\n");
        Main.sb.append("<summary>").append(techBlogName).append("</summary>\n\n");
    }

    @After("execution(void com.example.Main.*())")
    public void addDetailsEnd() {
        Main.sb.append("</details>\n");
    }
}
