# compile all the necessary classes
cd src/myAdapter
for file in *.java
	do {
		echo "Building ${file}"
		javac -d "..\..\target" *.java
	} && {
		echo "${file} built succesfully"
		echo
	}
	done

cd ../myTest
for file in *.java
	do {
		echo "Building ${file}"
		javac -d "..\..\target" $file -cp "..;..\..\matcher\junit-4.13.jar;..\..\matcher\hamcrest-core-1.3.jar"
	} && {
		echo "${file} built succesfully"
		echo
	}
	done

# from .\myTest to .\bin\myTest and run all the tests
cd ../../target/myTest
java -cp "..\..\target;..\..\matcher\junit-4.13.jar;..\..\matcher\hamcrest-core-1.3.jar" org.junit.runner.JUnitCore myTest.TestRunner

$SHELL