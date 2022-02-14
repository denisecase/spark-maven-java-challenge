# spark-challenge

## Links

- [Repo](https://github.com/denisecase/spark-challenge)

## Recommended IDE

- VS Code
- VS Code Extension: Maven for Java
- VS Code Extension: Extension Pack for Java

## Install Maven Package Manager for Java Projects

`choco install maven -y`

## Instructions - Fork / Clone / Code the project

1. Fork this repo into your GitHub. 
2. Go to your new repo in GitHub.
3. Clone your repo down to your machine. 
4. Right-click and open your new local repo in VS Code.


When VS Code asks: "A build file was modified. Do you want to synchronize the Java classpath/configuration?" Answer "Always" to allow VS Code to generate these artifacts automatically.

## Instructions  - Modify POM.xml

Copy the POM.xml from this repo to yours. Change your groupId.

## Prepare the Code

```PowerShell
mvn clean
mvn compile
mvn assembly:single
```

## Execute

```Bash
java -cp target/spark-maven-java-challenge-1.0.0-jar-with-dependencies.jar edu.nwmissouri.isl.App "data.txt"
```
