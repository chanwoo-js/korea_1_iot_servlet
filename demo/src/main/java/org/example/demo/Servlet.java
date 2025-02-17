package org.example.demo;

/*
    == 서블릿 ==
    1. 서블릿 정의
    JAVA EE (Enterprise Edition) 의 일부
    웹 서버에서 실행되는 java 프로그램
    간단하게 얘기하면 클라이언트의 "요청"을 처리하고 그 결과를 웹브라우저에 "반환(응답)"하는 역할을 한다.

    2. 서블릿의 작동 구조
    apache tomcat과 같은 (톰캣만 되는게 아니다) 서블릿 컨테이너에서 실행된다
    서블릿 컨테이너란 ?
    클라이언트로부터 http 요청을 받아 서블릿에 전달하고
    서블릿에서 응답을 처리한 후 다시 클라이언트로 응답을 반환하는 역할을 한다.

    서블릿 라이프사이클
    init() : 서블릿이 처음 호출될 떄 실행, 초기화 작업을 담당
    service() : 클라이언트 요청이 있을때마다 호출이 된다. doGet()이나 doPost() 등과 같은 http 메서드에서 따라 요청을 처리한다.
    destroy() : 서블릿이 종료될 때 호출되어 리소스를 정리

    http 요청 & 응답 처리
    httpServletRequest 와 HttpServletResponse 객체를 사용하여 처리한다.

    3. 서블릿 개발의 특징
    핸들러 관리
    각가의 요청을 처리하는 메서드를 직업 정의한다.
    http 요청을 수동으로 처리하고 응답을 작성한다.
    매핑 설정
    서블릿 매핑은 web.xml 과 같은 배포 기술자나 어노테이션을 통해 설정한다.

    jsp (자바 서버 페이지)
    html 코드 내에 java 코드를 작성한다
    예) <% 소스코드 %> 또는 <%= 소스코드 =%>
    서블릿에서 jsp 가 나왔긴하지만 결국은 같은 톰캣을 통해서 사용됨




*/
public class Servlet {
}
