# Caruction
<h2>A simple car auction app</h2>

<h3>test credentials</h3>

login: user </br>
password: 1234

login: admin </br>
password: 1234

Healthcheck endpoint of the application:</br>
![healthcheck](src/main/resources/attachments/healthcheck.png)

Authorisation form:</br>
![authForm](src/main/resources/attachments/authForm.png)

If authorised user role - "user", only user page may be accessible, admin page will have status 403 FORBIDDEN:</br>
![userPage](src/main/resources/attachments/userPage.png)
![adminPageForbidden](src/main/resources/attachments/adminPageFail.png)

But if user role - "admin", he has access to all pages (/user, /admin)
![adminPage](src/main/resources/attachments/adminPage.png)
