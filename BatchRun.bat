set projectLocation=C:\Users\pp62\workspace\SeleniumTrain
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testng.xml
pause