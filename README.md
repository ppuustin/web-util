Intro
==============

This is an example web application. No fancy stuff, just a simple maven web project to show the main building blocks of a web app for a Tomcat server.

http://localhost:8080/web-util/
http://localhost:8080/web-util/get-method-1
http://localhost:8080/web-util/get-method-2

Building
--------------

A working Maven setup is assumed or an IDE with an appropriate plugins.

The build is executed at the root.

    $ <web-util> mvn clean install

The build artifact is found from the module target directory.

    <module>/target/<module>.war

  
[//]: # (references)

[Hadoop Application Architectures]: http://www.pentaho.com/sites/default/files/uploads/resources/hadoop_app_architectures_preview_ed.pdf
[HDFS Commands Guide]: https://hadoop.apache.org/docs/r2.7.3/hadoop-project-dist/hadoop-common/FileSystemShell.html
