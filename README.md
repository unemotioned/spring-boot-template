# Spring Boot Template

## Spring Boot Framework 기본 개념

스프링 부트 정의 및 특징

- 정의 : 스프링 프레임워크를 기반으로 애플리케이션 개발을 간소화하고, 빠르게 만들 수 있도록 도와주는 개발 도구
- 대표 특징
  1. 자동 설정 : 대부분의 설정 작업을 자동으로 설치해줌
  2. 내장 서버 : Tomcat을 내장하고 있어서 별도의 WAS 설치 필요 없음
  3. 편리한 의존성 추가 : 자주 사용되는 라이브러리와 의존성을 묶어서 제공 (pom.xml에 수동 추가했던거 프로젝트 생성할 때 체크박스만으로 추가 가능)
     - 레거시 프로젝트에 비해서 설정하기가 매우 편리하다

---

## 기본 준비

[Spring 공식 사이트](https://spring.io)
[STS 다운로드](https://spring.io/tools) (Spring Tools 4 for Eclipse)
[Spring Framework 버전별 릴리즈 노트](https://spring.io/projects/spring-boot#learn)
GA : 배포된 안정된 버전 (우리가 사용할것)
SNAPSHOT : 개발 진행 중

[Maven Zip](https://dlcdn.apache.org/maven/)
[3.9.1](https://archive.apache.org/dist/maven/maven-3/3.9.1/binaries/)
[Maven 라이브러리 Dependency 검색](https://mvnrepository.com/)
[Java 17 (Window)](https://corretto.aws/downloads/latest/amazon-corretto-17-x64-windows-jdk.msi)

- Spring Boot Framework 3.4.1 요구사항
  - JDK 17 이상
  - Maven 3.6.3 이상

1. Java amazon corretto 17 설치
2. Maven 설치 및 설정 (기존 레거시랑 동일하게, repository 폴더 생성하고 settings.xml에 `<localRepository>` 설정 동일하게)
3. STS 다운로드 사이트 들어가서 최신 버전 다운로드 및 압축 해제
4. workspace 생성 및 STS 실행
5. workspace 설정
6. 프로젝트 설정

---

## Workspace settings

### Menubar / Window / Preferences 설정

1. Compiler 17
2. Installed JREs JDK 17 (경로: C:\Program Files\Amazon Corretto\jdk17.0.12_7)
3. 인코딩 UTF-8 설정 (기본으로 되어 있음)
   - General &rarr;
     - Editors &rarr; Text Editors &rarr; Spelling
     - Workspace
   - JSON &rarr; JSON Files,
   - Web &rarr;
     - CSS Files
     - HTML Files
     - JSP Files
   - XML &rarr; XML Files
4. Window &rarr; Show View에서 필요 탭 추가 (Package Explorer, Problems, Console, Search, OutLine)
5. Menubar &rarr; Help &rarr; Eclipse Market Place
   - `Eclipse Enterprise Java and Web Developer Tools 3.36` 설치

   - JSP 생성 및 아래 Mybatis 관련 설정을 위한 Kit 다운로드 (부트에서는 JSP가 기본적으로 제공되지 않음)

   - 한 번 Install 하면, workspace별 설치 없이 사용 가능

   - STS 재시작

6. Window &rarr; Perspective &rarr; Customize Perspective &rarr; Shortcuts &rarr; Web, XML에서 필요한 파일 체크
   - JSP, CSS, XML
7. Maven 설정 (기존 레거시랑 동일하게, Window &rarr; Maven &rarr; User Settings 설정)
8. Mybatis 관련 설정
   - Window &rarr; Preferences &rarr; XML &rarr; XML Catalog &rarr; User Specified Entries에 Config, Mapper 설정
   - Config 파일 내부 설정(alias, jdbc type, mapper location)은 application.properties에 작성해도 무방하므로, Mapper 설정만 진행해도 됩니다 샘플
     프로젝트 참고
   - Window &rarr; Preferences &rarr; XML (Wild Web Developer) &rarr; Download external resources like referenced DTD,
     XSD 체크

---

## Project 설정

1. 새 프로젝트 생성 `Spring Starter Project` 클릭
2. 프로젝트 생성 기본 정보 입력
   - Name : 프로젝트 이름
   - Type : 빌드 도구 (Maven으로 설정)
   - Packaging : Jar
   - Java Version : 17
   - Language : Java
   - Package : kr.or.iei

3. Dependencies 검색 및 추가 (상단 Spring Framework 3.4.1 선택 &rarr; 새 버전 출시되면 자동 선택되니 참고)
   - 기존 레거시에서, pom.xml에 수동으로 추가했던 의존성들중에 자주 사용되는 놈들을 묶어서 편리하게 추가할 수 있도록 제공

   - Spring Web (기본 Servlet 기능, 내장 Tomcat)
   - Spring Boot DevTools (소스 수정 시, 자동 재시작 등 개발 편의성)
   - Lombok
     - 체크해도 어노테이션은 작성 가능하나, 클래스 파일에 getter 및 setter 생성 또는 사용이 안되는 경우 아래대로 진행
       1. 프로젝트 - Maven Dependencies 열어 lombok.jar 파일 찾기
       2. lombok.jar 우클릭 - Run As - Java Application
       3. lombok 설치 화면 나오면, Specify location 클릭하여, STS 다운로드 경로에 존재하는 STS.ini 파일 경로 체크 및 Install
       4. STS Restart 및 프로젝트 Clean 후, 재실행
   - Oracle Driver
   - Mybatis Framework

4. src/main/resources/application.properties에 서버 포트 번호, DB 접속 정보, Mybatis, JSP 설정
   - 아래 "#"은 주석이고, 이 파일에는 한글 작성 X
   - 아래 mybatis 설정은 기존처럼 mybatis-config.xml 생성하고 작성해도 되지만, 이 파일에 모아 작성해야 관리적인 측면으로 편함
   - mybatis-config.xml 생성했으면 아래 mybatis.config-location 속성 추가

- `application.properties` 파일 내용

```properties
# server port Number
server.port=80

# jsp view location setting
spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix=.jsp

# mybatis setting
mybatis.mapper-locations=classpath:/mapper/_.xml
mybatis.type-aliases-package=kr.or.iei._.model.vo
mybatis.configuration.jdbc-type-for-null=NULL

# oracle setting
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
spring.datasource.url=jdbc:oracle:thin:@127.0.0.1:1521:xe
spring.datasource.username=boot_test
spring.datasource.password=1234

# file upload
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=50MB
```

5. JSP 사용을 위한 의존성 pom.xml에 추가

- Boot 3.0 버젼 이상으로 작성됬기때문에 낮은 버젼을 쓰면 경로가 다를 수 있음

```xml
<dependency>
  <groupId>org.glassfish.web</groupId>
  <artifactId>jakarta.servlet.jsp.jstl</artifactId>
</dependency>

<dependency>
  <groupId>jakarta.servlet.jsp.jstl</groupId>
  <artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
</dependency>

<dependency>
  <groupId>jakarta.servlet</groupId>
  <artifactId>jakarta.servlet-api</artifactId>
</dependency>

<dependency>
  <groupId>org.apache.tomcat.embed</groupId>
  <artifactId>tomcat-embed-jasper</artifactId>
</dependency>
```

6. src/main 폴더 하위에, 폴더 및 JSP 파일 추가

- src/main/webapp/WEB-INF/views 폴더 추가
- views 폴더 하위에 index.jsp 추가

7. 프로젝트 우클릭 &rarr; Run As &rarr; Spring Boot App 클릭

- 단축키: Alt + Shift + X, B

---

## 면접 Tip

- 기업에 대한, 다양한 방면의 최소한의 기준 정할 것 (연봉, 복지, 연차 및 휴가제도, 상여 및 성과급, 지역, 교통편, 유연근무제 등)
- 수료 후에 별도의 프로젝트 제작이나 계획이 없다면, 취업까지 기간을 최대 3개월 이내로 설정할 것
  (늘어날수록 열정은 사라지고 마음만 조급해져서 위에 작성한 최소한의 기준이 점점 내려가요)
- 이미 자기소개서 기본 틀은 제작되었으니, 기업별 지원 시 최소한 연혁, 주 사업, 사업 목표, 인재상 등은 변경 적용하여 지원할 것
  기업명만 OO 뚫어놓고 바꿔가면서 지원하지 마세요 (+@ 관련 뉴스까지도 찾아보면 면접에 활용 가능)
- 면접은 되는 대로 모두 참석하여, 스킬업 및 긴장감 낮추기 (그래야 기회가 왔을 때, 준비한 역량에 70% 이상은 나와요)
- 어차피 면접 떨어지면 동네 아저씨 아줌마다라는 생각으로 들어가야 긴장이 덜 됩니다
- 면접관은 기본적인 개발 역량뿐만 아니라, 조직에 잘 융화될 수 있는지도 중요하게 생각하니 잘 웃고 대화하듯이

  [잡아바](https://www.jobaba.net/introduction/mainList.do)(무료 자소서 첨삭 사이트)
  [kocw](http://www.kocw.net/)(분야별 다양한 무료 강의 사이트)

- 구직 사이트
  - 국내 : 사람인, 잡코리아, 원티드, 로켓펀치, 슈퍼루키, 자소설닷컴
  - 해외 : LinkedIn, worldjob, peoplenjob (외국계)

- 기업 분석
  - [catch](https://www.catch.co.kr/)
  - [fss](https://dart.fss.or.kr/)
  - [wanted](https://insight.wanted.co.kr/)

- Boot 프레임워크 3.4.1 기준으로 작성했으니, 상위 버전 생성 시 각 프레임워크 및 라이브러리와의 호환성 체크 필요

---

### Happy Hacking 🎉
