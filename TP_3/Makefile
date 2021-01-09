JFLAGS = -g
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = Algorithme_de_Cesar.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
	
cesar:
	java Algorithme_de_Cesar