# spark-challenge

## Links

- [Repo](https://github.com/denisecase/spark-challenge)

## Prerequisites

- VS Code
- VS Code Extension: Maven for Java
- VS Code Extension: Java Extension Pack

## Instructions 1 - Start New Maven Project

1. Build from Scratch (do not fork this repo)
1. There should be a folder on your laptop where you keep your git projects. Go to this folder, e.g. 44517.
1. Open this parent folder in VS Code.
1. Click the VS Code Extensions icon. Verify you have the two required extensions. If not, install them.
1. Click the VS Code Explorer icon. From the menu, select:
1. View / Command Palette / Maven: Create Maven Project / archetype-quickstart-jdk8 / most recent version.
1. When the folder window opens, click your parent folder up at the top, click "Select Destination Folder".

## Instructions 2 - Interactive Mode

```Bash
groupId: edu.nwmissouri.yourname
artifactId: spark-challenge
version: HIT ENTER
package: HIT ENTER
Y: HIT ENTER
```

You will now have a spark-challenge project folder. Exit VS Code.

## Instructions 3 - Code the project

Change directory into your new spark-challenge folder. Right-click and open this folder in VS Code.

Add a basic README.md.

When VS Code asks: "A build file was modified. Do you want to synchronize the Java classpath/configuration?" Answer "Always" to allow VS Code to generate these artifacts automatically.

## Instructions 4 - Add to POM.xml

Copy the POM.xml from this repo to yours. Change your groupId.

## Prepare the Code

```PowerShell
mvn clean
mvn compile
mvn assembly:single
```

## Execute

```Bash
java -cp target/spark-challenge-1.0.0-jar-with-dependencies.jar edu.nwmissouri.isl.App "data.txt"
```
