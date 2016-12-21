Make sure maven is installed to build and run project 

Make sure MySQL database is installed to run project 

Steps to run project 

1) Update connection details of Local MySQL database inside dispatcher-servlet.xml
2) mvn clean compile package    (This will build project)
3) mvn jetty:run                (This will run project with jetty server)


