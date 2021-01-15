JFLAGS = -g
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	FIPS.java 

default: classes escargot

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
	
fips:
	java FIPS

escargot:
	javac -cp '.:ComplementTP4.jar' Escargot.java
	java -cp '.:ComplementTP4.jar' Escargot
