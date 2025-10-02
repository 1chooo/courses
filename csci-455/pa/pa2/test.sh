echo Compiling and running test1...

javac *.java
java -ea BookshelfKeeperProg < test/test1 > mytest1.out
diff mytest1.out test/test1.out

rm -rf *.class mytest1.out

echo Compiling and running test2...

javac *.java
java -ea BookshelfKeeperProg < test/test2 > mytest2.out
diff mytest2.out test/test2.out
rm -rf *.class mytest2.out

echo Compiling and running test3...

javac *.java
java -ea BookshelfKeeperProg < test/test3 > mytest3.out
diff mytest3.out test/test3.out
rm -rf *.class mytest3.out

echo Test Done.

echo Compiling and running err1...

javac *.java
java -ea BookshelfKeeperProg < test/err1 > myerr1.out
diff myerr1.out test/err1.out
rm -rf *.class myerr1.out

echo Compiling and running err2...

javac *.java
java -ea BookshelfKeeperProg < test/err2 > myerr2.out
diff myerr2.out test/err2.out
rm -rf *.class myerr2.out

echo Compiling and running err3...

javac *.java
java -ea BookshelfKeeperProg < test/err3 > myerr3.out
diff myerr3.out test/err3.out
rm -rf *.class myerr3.out

echo Err Test Done.
