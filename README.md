### TO COMPILE AND RUN TESTS

`mvn clean compile test`

WARNING: compiling manually could generate some errors due compiled classes unintended locations

### TO GENERATE BOTH API AND TEST DOCUMENTATION

`mvn javadoc:javadoc javadoc:test-javadoc`

### TO COMPILE MANUALLY FROM COMMAND LINE (WINDOWS)

`javac -d ".\target" -cp ".\matcher\junit-4.13.jar;.\matcher\hamcrest-core-1.3.jar;src" myAdapter.{fileName}.java`

`javac -d ".\target" -cp ".\matcher\junit-4.13.jar;.\matcher\hamcrest-core-1.3.jar;src" myTest.{fileName}.java`

### TO RUN TEST MANUALLY FROM COMMAND LINE (WINDOWS)

`java -cp ".\matcher\junit-4.13.jar;.\matcher\hamcrest-core-1.3.jar;target" org.junit.runner.JUnitCore myTest.TestRunner`
