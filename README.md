#ServletsFp

12 Fast testing system<br>

Company:	External courses<br>
Company Location:	Ukraine, Kiev
Duration:	01/06/2019 – 20/06/2019<br>
Description:	Student Quick Testing System. The student is registered by e-mail, his success is attached to him and he will receive messages about the result of tests. In the system there is a catalog of tests on topics, an authorized student can take tests. At the end of the test , form with errors will be displayed for student . All data on progress and courses are displayed on the Administrator page as a summary table for all Students.<br>
Position:	Full-Stack developer<br>
Tools & Technologies:<br>
	IDE : Intellij IDEA<br>
WEB Server : Apache Tomcat 9<br>
Version Control System : Git<br>
Project builder : Apache Maven<br>
Database manage : MySQL workbench<br>
Backend programming language : Java 8<br>
Frameworks : Spring Boot, Spring Security, Spring MVC, Spring Data<br>
Frontend : CSS, HTML, Freemarker, Bootstrap<br>
Testing : JUnit, Mockito , Spring Test<br>
DB Migration : FlyWay<br>
Object Relational Mapping : JPA<br>
Logging : Log4j<br>
Participation:<br>
Project contains :<br>
- User role system : user , admin<br>
- Test catalog : catalog of test for passing<br>
- Validation off all input (backend)<br>
- Internationalization (EN, UA)<br>
- implemented paging<br>
- implemented filtering<br>
- implementing sorting<br>
- realization according to SOLID;<br>
- used patterns : builder , abstract factory, template method.<br>
- Code covered by comments<br>
Project architecture (MVC) :<br>
Model :<br>
- Entities with services<br>
View:<br>
- FTL, HTML, Freemarker<br>
Controller:<br>
- Spring web controller<br>

Запуск :

1. Для запуска вам понадобятся jdk, git, maven.

2. Вставить URL в src\main\resources\db.properties 'jdbc:mysql://localhost:3306/servletfp'

3. В корневой папке проекта откройте терминал и введите команду (mvn tomcat7:run)

4. Открыть браузер и перейти по ссылке http://localhost:8080/api
