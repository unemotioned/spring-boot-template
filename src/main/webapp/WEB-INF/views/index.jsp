<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>index.jsp</title>
</head>
<body>
<h1>Hello, Spring Boot</h1>

<a href="/getList">회원 조회</a>

<%--
Spring Boot 프로젝트 구조

src/main/java                              : Java 파일이 위치하는 디렉토리
src/main/java/Application.java             : Spring boot 애플리케이션 메인 메소드가 존재하는 클래스. (설정 초기화 및 애플리케이션 실행 담당)
src/main/resources/static                  : 정적 리소스가 위치하는 디렉토리(JavaScript, CSS, HTML, IMG 파일 등)
src/main/resources/templates               : 타임리프, 프리마커와 같은 서버 사이드 템플릿 파일들이 위치하는 디렉토리
src/main/resources/application.properties  : Spring boot 설정 파일. (DB 접속 정보, 서버 포트, 마이바티스, 파일 업로드, 사용자 정의 경로 등)
src/test/java                              : 테스트 파일이 위치하는 디렉토리.
target                                     : 빌드 산출물이 위치하는 디렉토리.

application.properties 파일과, Configuration 어노테이션이 작성된 클래스 파일 모두 애플리케이션 관련 설정을 담당하지만
application.properties은 선언적 설정으로 비교적 간단한 기본 설정들을 작성할 수 있고,
Configuration 어노테이션이 작성된 클래스 파일은 Java 언어로 작성되는 파일이므로 동적 설정 및 고급 설정이 가능.
 --%>
</body>
</html>
