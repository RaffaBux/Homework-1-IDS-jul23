### TO COMPILE AND RUN TESTS

`mvn clean compile test`

WARNING: compiling manually could generate some errors due compiled classes unintended locations

### TO GENERATE API DOC

`mvn javadoc:javadoc`


### TO GENERATE TEST DOC

`mvn surefire-report:report`

### TO RUN TEST MANUALLY FROM COMMAND LINE (WINDOWS)

`java -cp ".\matcher\junit-4.13.jar;.\matcher\hamcrest-core-1.3.jar;target" org.junit.runner.JUnitCore myTest.TestRunner`