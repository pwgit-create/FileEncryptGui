
# File Encrypt 
File Encrypt is an application that encrypts files with RSA/AES from a graphical user interface. The benefit of using this app is the ease of use while getting the safety of 4096 bits RSA encryption. 


#### Written in: Java 8 

<p align="center">
  <img src="img/bg_image.jpg" width="400" title="hover text">

</p>


## Project Libraries

* Java FX : https://docs.oracle.com/javase/8/javase-clienttechnologies.htm

* Apache Commons Codec 1.15 : https://mvnrepository.com/artifact/commons-codec/commons-codec/1.15

* Apache Commons IO 2.11 https://mvnrepository.com/artifact/commons-io/commons-io/2.11.0

* Zip4j 2.9.1 https://mvnrepository.com/artifact/net.lingala.zip4j/zip4j/2.9.1




## Instructions of use
    1. Generate a key pair by clicking on “New Keypair”.

    2. Set the key paths by clicking on the Set Key buttons.

    3. Keys.properties will contain the paths to your keys. This file must exist (and can’t be renamed) in order for the jar/project to run. You can edit this file manually as well 😊 



#### Encrypt file

    1. Click on Encrypt to encrypt a file
    2. A new file that ends on.” zc” will be created. That is the file you decrypt or send to a friend.
    3. Remember that if you use a friend’s public key, you can’t decrypt the file yourself.


### Decrypt File
    1. Click on decrypt 
    2. Choose a file that has been encrypted using this app and has the file ending “.zc”. 
    3. If the file has been encrypted with your public key, you can decrypt it with your private key,

### How to Start the Project 

 #### Start the Jar

    1. Download a JVM with Java FX and Java 8. See download links below: 

        1.1 Azul JVM (Easy to download): https://www.8azul.com/downloads/?version=java-8-lts&package=jdk
        1.2 Oracle(Must create account before download) : https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html

    2. Run the jar from the jar_executable folder by clicking on the icon or by executing it from your console (See below); 
````java -jar FileEncryptGui````


#### Start the project in IntelJ

    1. Import the libraries from the lib_jars folder. ````File -> Project Structure  -> Libraries ````

    2. Use a JDK that contains Java FX or add the library to the project 

    3. Use Main.class as the starting class



## Project FAQ
* Why isn’t mvn used?
Its really a hazard to make jar executable with maven and Java FX☹

* Who can’t contribute to this project? 
 Everyone that is invited to the repository is welcome to 😊  
 
