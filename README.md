# taff-yves-rocher

The project contains test cases for the User Interface and REST API

The tested site is (https://www.y-r.by)
Site is created as web-shop of perfume,
white and decorative cosmetic
for Belarus.

2. Libraries and Tools, which used
   in the project are shown here:
   Libraries:
   -java.faker
   -selenium
   -rest-assured
   -junit.jupiter
   -hamcrest.Matchers

Frameworks:
-Java, Maven, IntelliJ IDEA,
-GIT, GitHub,
-Postman, Chrome DevTools

3. Site was tested in 3 endpoints:
   -HomePage and SearchForm
   -LoginForm
   -Cart/Basket

4. Architecture of the test framework
   is here:

I REST API area:
   PageObject > REST API Tests

II UI area:
PageObject
DriverSingleton
Steps
Utils
BaseTest > UI Tests