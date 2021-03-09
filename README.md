# todo-list-java ToDoLy

ToDoLy is an application created in Java to add a list of daily tasks with a deadline date, you can edit your tasks, add new tasks and see all the pending tasks.
This application works on command line.

## Class Diagram

The initial class diagram is this but will change as the project progresses:

https://ibb.co/mR1D88y

## Getting started

You can start the application with Gradle or clone the repository.

### Run with Gradle

1. Go to the root folder
2. Start the aplication with Gradle's run command

```bash
gradle run 
```

### Clone the repository

1. Clone this repository:

```
https://github.com/MartaLourido/todo-list-java.git
```

2. Open the code in the IDE of your choice or use the terminal

3. In the IDE start the code from the Main.java class

4. Run the project

5. You can now view tasks, add new tasks, delete tasks and save tasks.

## Usage

You will have to start the command line and when you start the application you will be able to choose an option and start typing the numbers that correspond to each option and what you want to view, add, edit, delete or update.

Example: 
```
Welcome to ToDoLy
Pick and option:
1. Show Task List (by date or project) 
2. Add New Task
3. Remove Task
4. Save and Quit
|  *Type a number to make a selection*  |
Selection: 
```
If, for example, in selection I write the number 2, which is to add a new task, the programme will ask us for certain information that we will have to answer:

```
Selection: 2
Add new Task
Please, enter your name
Marta
Please, enter the name of the project you want to add the task to
Project Todo List
Please, enter a title for the task
Add the Readme to the project
Enter the task due date (dd/mm/yyyy): 09/03/2021'
```

## About

This is a project under construction and is not yet finished, there may be some functionality that is not 100% complete.
