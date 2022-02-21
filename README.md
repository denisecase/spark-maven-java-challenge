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

-----

## Resource Article - Test the Installation Project

Article: <https://www.journaldev.com/20342/apache-spark-example-word-count-program-java>

Go to your 44-517 folder. Open Git Bash. Run the following command (see note below):

`mvn archetype:generate -DgroupId=com.journaldev.sparkdemo -DartifactId=JD-Spark-WordCount -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false`

Open the whole project folder in VS Code 

- Edit pom.xml in root project folder (see article)
- Edit App.java (change the class name AND file name to WordCounter - see article)
- Create input.txt in the root project folder (add any text you like)

Run Maven Commands

Run the mvn commands from the article / slides to count the words:

```PowerShell
mvn dependency:tree
mvn clean
mvn compile
mvn exec:java "-Dexec.mainClass=com.journaldev.sparkdemo.WordCounter" "-Dexec.args=input.txt"
```

Alternate: The article command is for Git Bash:

`mvn exec:java -Dexec.mainClass=com.journaldev.sparkdemo.WordCounter -Dexec.args="input.txt"`

Error? 

- You must delete the output directory before rerunning. 


