# Caruction
<h2>A simple car auction app</h2>


<h3>To run:</h3>
mvn clean package spring-boot:repackage
<h3>then:</h3>
cd c:/path/to/dir/with/project</br>
java -jar Caruction.jar

<h3>test credentials</h3>

login: user </br>
password: user

login: admin </br>
password: admin

Healthcheck endpoint of the application:</br>
![healthcheck](src/main/resources/attachments/healthcheck.png)

Authorisation form:</br>
![authForm](src/main/resources/attachments/authForm.png)

If authorised user role - "user", only user page may be accessible, admin page will have status 403 FORBIDDEN:</br>
![userPage](src/main/resources/attachments/userPage.png)
![adminPageForbidden](src/main/resources/attachments/adminPageFail.png)

But if user role - "admin", he has access to all pages (/user, /admin)
![adminPage](src/main/resources/attachments/adminPage.png)
