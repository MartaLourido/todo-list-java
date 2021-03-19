# ToDoLy

ToDoLy is an application created in Java to add a list of daily tasks with a deadline date, you can edit your tasks, add new tasks and see all the pending tasks.
This application works on command line.

## Build with

- Gradle
- JDK 15
- JUnit

## Class Diagram

Please, click the link to see the class diagram: https://ibb.co/8x90Wtw

## Getting started

You can start the application with Gradle or clone the repository.

### Run with Gradle

1. Go to the root folder
2. Start the application with Gradle's run command

```bash
gradle run 
```
3. If you want to run the test please, run command

```bash
gradle test 
```

### Clone the repository

1. Clone this repository:

```
https://github.com/MartaLourido/todo-list-java.git
```

2. Open the code in the IDE of your choice or use the terminal

4. Run the project from the Main class

5. You can now view tasks, add new tasks, delete tasks and save tasks.

## Usage

You will have to start the command line and when you start the application you will be able to choose an option and start typing the numbers that correspond to each option and what you want to view, add, edit or update.

Example:
```
******** Welcome to ToDoLy ********
You have: 2 tasks to do and 1 done
         ****************          
Pick an option:
1.Show Task List (by date or project) 
2.Add a new Task
3.Edit Task (update, mark as done, remove)
4.Save and Quit
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

If you want to edit a task, you will have to press 3, it will ask you which task you want to edit and then you will see a menu to choose if you want to change the title, the name of the project, the end date, delete the task or mark it as done:
```
What task do you want to edit?
1
What do you want to edit in this task?
Pick an option:
(1)Edit title of the task
(2)Edit due date of the task
(3)Edit project of the task
(4)Mark task as done
(5)Delete task
(6)Go back to the main menu
Selection: 
```

## About

I am a junior programmer and this is my first project done in Java for the KTH Software Development Academy.

[![Linkedin](https://i.stack.imgur.com/gVE0j.png) LinkedIn](https://www.linkedin.com/in/marta-louridob/?locale=en_US/)
&nbsp;

[![GitHub](https://i.stack.imgur.com/tskMh.png) GitHub](https://github.com/MartaLourido)



