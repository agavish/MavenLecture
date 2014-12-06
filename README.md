MavenLecture
============

This is the example code of the maven lecture

This is a simple example of:


1.  Dependency Management


2.  Build process (validations, packaging, versioning)


3.  Unit testing
  

4.  Integration testing (embedded mongoDB)



##### How to insert the git commit to the .jar file
mvn clean install -Dgit.commit=28053e48a408c38e50e49b62ffcd4b1dffedc6eb

##### How to see the git commit in .jar file
unzip -q -c target/MavenLectureExample.jar META-INF/MANIFEST.MF
