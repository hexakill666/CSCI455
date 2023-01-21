Name:
USC NetID:
CSCI 455 Fall 2021
Lab 1

Note: All students should put their answers to the lab questions in this file.


Exercise 1
Question 1.1: What was the result of the command?
   The result of pwd command is: /mnt/data2/students/sub1/ddd_v1_w_6QAJ_663552/asn500268_2/asn500269_1/work. This command shows the current path of directory. The ls command shows files of current directory.


Question 1.2. What was the result of the command?
   The mkdir ex1 command creates a folder called ex1 with permission of drwxrwxrwx. The cd ex1 command forwards you to the ex1 directory.


Question 1.3. Predict what the results of the pwd command would be at this point. Verify your answer by trying it.
   The ls ex1 command shows files in the ex1 directory, and it shows nothing, because the ex1 directory has no files.


Question 1.4. Assuming you are still in the ex1 directory, write down two different commands that will get you to your home directory from there (i.e., will make your home directory your current directory). You can test them out by going back to the ex1 directory after trying each one.
   There are two commands that will get you to your home directory. The first one is: cd. The second one is: cd ~.


Question 1.5. Make sure you are in your home directory. Write down the command to list what's in the directory one level up from your home directory. Try it.
   The command to list files in the directory one level up from your home directory is: ls .. The cp command copies files from one directory to another directory. The mv command renames files or cuts files from one directory to another directory.


Question 1.6. Assuming you don't know what directory you are starting from, write down a sequence of commands such that after they are done, the ex1 directory in your workspace has a copy of the file Hello.java from your home directory. Try out your command sequence. Use ls to check if it worked.
   cd ~
   cp Hello.java ~/ex1


Question 1.7. Write down (and execute) the command(s) to make a directory in your home directory called lab1.
   cd ~
   mkdir lab1


Question 1.8. What does the last "cp" command above do?
   It copies the file called Hello.java under the ex1 folder to the current directory.


Question 1.9. Assuming you are starting from your home directory write down and execute a single command that will get you into your ex1 directory.
   cd ./ex1
   The cd ../.. command gets you to the two level upper directory.


Question 1.10. What directory did you just change to?
   The directory is: /mnt/data2/students/sub1/ddd_v1_w_6QAJ_663552/asn500268_2/asn500269_1


Question 1.11. "cd" into the ex1 directory. Using relative path names as seen in the previous examples, write down and execute a single command to make a directory called foo that's also inside the lab1 directory (but that is not a subdirectory of ex1. By "a single command", we mean you will still be in the same directory (ex1) after making the new directory. (When you are done a listing of the lab1 directory should show both ex1 and foo.)
   mkdir ../foo


Question 1.12. Write down and execute a single command to get into the new "foo" directory.
   cd ~/lab1/foo


Question 1.13. Write down and execute a single command to list the files in the "ex1" directory (i.e., without changing directories).
   ls ~/lab1/ex1



Exercise 2
   After executing the javac Hello.java command, a file called Hello.class shows up. After executing the java Hello command, the "Hello world!" string is printed on the screen.



Exercise 3
Question 3.1. Copy and paste the text of the compiler error message into the README file.
   Hello.java:7: error: ';' expected                                                                                 
      System.out.println("Hello world!")                                                                          
                                        ^                                                                         
1 error


Question 3.2. Note the line number of the third error. Where in the program does it think this error is?
   The third error is: Hello.java:7: error: not a statement.
   


Exercise 4
public class name {

   public static void lab(String [] args) {
      
      System.out.println("My name is xxx.");
      System.out.println("My major is xxx.");
      System.out.println("I am a xxx.");

   }
}



Exercise 5
Question 5.1. What does the first non-empty line of text after the date/time in your submission report say?
   All necessary files are present: 'Name.java README' (Passed) 


Question 5.1. What does the last non-empty line of text in your submission report say? (Hint: you may have to scroll down to see it.)
   ======= End of Report =======


Question 5.2. Did you pass the submission test?
   Yes