JFLAGS = -g
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Algorithme_de_Cesar.java \
	Algorithme_de_Vigenere.java

default: classes vigenere

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
	
cesar:
	java Algorithme_de_Cesar

vigenere: 
	java Algorithme_de_Vigenere