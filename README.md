# EasyKanBan - Java Task Management System

## Overview
EasyKanBan is a console and dialog-based task management application written in Java. The system allows users to create accounts, log in, and manage tasks in a Kanban-style workflow.
Features

## User Authentication System

Secure signup with username and password validation
Login functionality with attempt limiting
Password complexity requirements (capitals, numbers, special characters)


## Task Management

Create tasks with name, description, and status tracking
Assign developers to tasks with estimated duration
Automatic task ID generation based on task name and developer information
Track task status (To Do, Doing, Done)


## Reporting Features

Search tasks by name
Filter tasks by developer
View tasks with "Done" status
Calculate total development hours across all tasks
Identify developers with the longest task durations


## User-Friendly Interface

Colorful console output for better readability
Dialog-based input for critical functions
Intuitive menu-driven navigation



## Technical Details
The application uses a modular object-oriented approach with classes representing:

User accounts and authentication (UserManager, Login)
Tasks and their properties (TaskClass)
Developers assigned to tasks (DeveloperClass)
Task management operations (TaskManager)
Console color formatting (ConsoleColours)

## Usage
Users can register accounts, log in, create tasks, assign developers, and generate various reports to track project progress.
Future Enhancements

## Data persistence using file storage or database
GUI interface improvements
Team collaboration features
Timeline visualization

## Author
Dillon Rinkwest - ST10439147
