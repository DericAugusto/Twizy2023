# Project Twizy 2023

## About the project

Second year project developed as part of the curriculum of the Digital Systems branch of the **École nationale supérieure d’électricité et de mécanique** in the Université de Lorraine (Vandœuvre-lès-Nancy - FR).

The project is a computer vision application capable of **identify traffic signs** through photos and videos. The application is developed in Java through the OpenCV tool, containing a graphical interface.

group members :
- Déric Augusto França de Sales;
- Ibraim Souley;
- Oumnia Lachgar;
- Mathis Eddam;
- Theo Bourderon.

## To run the project 

To run the project, first you'll need to instal the Java version 19 or superior. 

For windows users, it's important to remember to set the java variables path in the system variables. This [video](https://www.youtube.com/watch?v=AUL--F5Wdh8&t=26s) is a good installation guide. You'll also need to install [Maven](https://www.youtube.com/watch?v=km3tLti4TCM), OpenCv (version 2.4.13.6) and the [MySQL](https://www.youtube.com/watch?v=km3tLti4TCM) applications. 

For executing in VsCode, it's necessary to configure the line : "vmArgs": "-Djava.library.path=C:\\...\\opencv_2.4.13.6\\build\\java\\x64", below "projectName" in the configuration file (launch.jason). It's also necessary to add the reference of the OpenCv library (...\opencv_2.4.13.6\build\java\opencv-2413.jar) and the [mysql-connector-j-8.0.33.jar](https://www.youtube.com/watch?v=h6xwRwlFypM) in the JAVA PROJECTS section, in the lowe left corner of the VSCode Explorer interface.

The files are also organized in different project structures, so to open the project its necessary to open a individual project folder separately. There's 3 project folders in this repository. The TwizyUI folder, and the ExercicesOpenCV and TutoOpenCv, available in the Annexes folder.