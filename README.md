# Spring Boot Template

`Spring Boot` is an extension of the `Spring` Framework that simplifies application development by reducing configuration and enabling developers to build production-ready applications quickly and efficiently.

## Why Spring Boot

- **Auto Configuration**
  - Automatically configures the application based on the project's dependencies.

- **Embedded Server**
  - Comes with an embedded server such as Apache Tomcat, eliminating the need to install a separate application server.

- **Easy Dependency Management**
  - Provides starters such as `spring-boot-starter-web` and `spring-boot-starter-data-jpa`, which bundle commonly used libraries.
  - Adding dependencies when creating a new project is simple.

- **Rapid Development**
  - Minimizes boilerplate code and configuration.

## Table of Contents

- [Prerequisite](#prerequisite)
  - [Apache Maven Preparation](#apache-maven-preparation)
- [STS Settings](#sts-settings)
  - [Extension](#extension)
- [Create New Project](#create-new-project)
- [Run Project](#run-project)
- [Open with IntelliJ](#open-with-intellij)
- [Troubleshooting](#troubleshooting)
  - [Java Version Difference in IntelliJ Terminal](#java-version-difference-in-intellij-terminal)

---

## Prerequisite

Download and install following packages:

- [Amazon Corretto 21](https://docs.aws.amazon.com/corretto/latest/corretto-21-ug/downloads-list.html)
- [Apache Maven 3](https://maven.apache.org/download.cgi) (Download **Binary zip archive**)
- [Spring Tools 5](https://spring.io/tools#eclipse)

### Apache Maven Preparation

Follow instruction from [unemotioned/spring-practice](https://github.com/unemotioned/spring-practice#apache-maven-1)
to set the directory where the dependencies will be installed

#### Environment Variable

To use `mvn` command in terminal you must set the environment variable.

1. 윈도우 검색에서 `시스템 환경 변수 편집`
2. `환경 변수(N)...`
3. 시스템 변수(S) > `새로 만들기(W)...`
   - **변수 이름**: `MAVEN_HOME`
   - **변수 값**: **디렉터리 찾아보기(D)...** 압축 풀려있는 `apache-maven-3.x.x` 폴더 선택
4. `Path`를 **편집(I)...**
5. **새로 만들기(N)** 클릭 후 `%MAVEN_HOME%\bin`으로 설정

Open terminal and test it:

```sh
mvn --version
```

> [!NOTE]
> **Environment variable** setup is not necessary if you only run projects from **IDEs**.

---

## STS Settings

Open `Menubar > Window > Preferences`

### JDK & Compiler

- Java > **Installed JREs**: `jdk21`
- Java > **Compiler compliance level**: `21`

### MyBatis

Follow instruction from [unemotioned/mybatis-practice](https://github.com/unemotioned/mybatis-practice#mybatis-settings).

### Maven

- Maven > **User Settings**
  - **User Setting**: `C:/apache-maven-3.x.x/conf/settings.xml`

### Extension

Menu bar > Help > **Eclipse Market Place**

Search `Eclipse Enterprise Java and Web Developer Tools 3.xx`

- Installs Kit for creating **JSP** and setting up **MyBatis**

---

## Create New Project

Right click on Package Explorer > New > `Spring Starter Project`

The prompt is for setting the project information and dependencies to go inside the `pom.xml`

- **Name**: Name of the project
- **Type**: `Maven`
- **Packaging**: `Jar`
- **Language**: `Java`
- **Group**: `kr.or.iei`
- **Artifact**: Same as the project name
- **Package**: `kr.or.iei.spring-boot-template`

Next

**Spring Boot Version**: Latest stable version is automatically selected (This project is using **3.5.16**)

Search following dependencies:

- Spring Web
- Spring Boot DevTools
- Lombok
  - If it does not work then from `Maven Dependencies` and **Run As** > `Java Application`
- Oracle Driver
- MyBatis Framework

### JSP

Add the following dependencies from [Maven Repository](https://mvnrepository.com/) to enable `JSP` support:

- Jakarta Standard Tag Library Implementation
- Jakarta Standard Tag Library API
- Jakarta Servlet API
- Tomcat Embed Jasper

```xml
<!-- Source: https://mvnrepository.com/artifact/org.glassfish.web/jakarta.servlet.jsp.jstl -->
<dependency>
    <groupId>org.glassfish.web</groupId>
    <artifactId>jakarta.servlet.jsp.jstl</artifactId>
    <version>3.0.1</version>
    <scope>runtime</scope>
</dependency>

<!-- Source: https://mvnrepository.com/artifact/jakarta.servlet.jsp.jstl/jakarta.servlet.jsp.jstl-api -->
<dependency>
    <groupId>jakarta.servlet.jsp.jstl</groupId>
    <artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
    <version>3.1.0-M1</version>
    <scope>compile</scope>
</dependency>

<!-- Source: https://mvnrepository.com/artifact/jakarta.servlet/jakarta.servlet-api -->
<dependency>
    <groupId>jakarta.servlet</groupId>
    <artifactId>jakarta.servlet-api</artifactId>
    <version>6.2.0-M2</version>
    <scope>provided</scope>
</dependency>

<!-- Source: https://mvnrepository.com/artifact/org.apache.tomcat.embed/tomcat-embed-jasper -->
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
    <version>11.0.23</version>
    <scope>compile</scope>
</dependency>
```

### application.properties

This is where you set DB connection, JSP, MyBatis config etc.
MyBatis can be configured with `mybatis-config.xml` as usual but keeping them in one
place is easier to manage.

```properties
server.port=80

# JSP directory
spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix=.jsp

# MyBatis config
mybatis.mapper-locations=classpath:/mapper/*.xml
mybatis.type-aliases-package=kr.or.iei.*.model.vo
mybatis.configuration.jdbc-type-for-null=NULL

# DB connection
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
spring.datasource.url=jdbc:oracle:thin:@127.0.0.1:1521:xe
spring.datasource.username=spring_boot_template
spring.datasource.password=1234

# File upload and download
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=50MB
```

---

## Run Project

Create `src/main/webapp/WEB-INF/views/index.jsp`

Right-click project and select **Run As**.

1. `Maven Install` (which is same as **clean, validate, compiler, test, package, verify, install, deploy**)
   - This creates `target/<package-name>.jar`
2. Spring Boot App (**Shortcut**: `Alt + Shift + X, B`)

---

## Open with IntelliJ

### Project Structure

Menu bar > File > Project Structure (shortcut: `Ctrl + Alt + Shift + S`)

Project > **SDK**: `corretto-21`

### Maven Settings

Settings > Build, Execution, Deployment > Build Tools > **Maven**

**User settings file** check Override and select the `C:/apache-maven-3.x.x/conf/settings.xml`

### Run Configurations

1. Install `Spring Boot` plugin
2. Menu bar > **Edit Configuration...**
3. **Add New...** > `Spring Boot`
4. Enter the **Main Class** path starting from `kr.or.iei`
5. Now you can run it (shortcut: `Shift + F10`)

---

## Troubleshooting

### Java Version Difference in IntelliJ Terminal

From `Edit system environment variables` edit `Path` and move currently used
Java version above other JDKs right under the `%JAVA_HOME%`.
