JFLAGS = -g
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Algorithme_de_Cesar.java \
	Algorithme_de_Vigenere.java

default: classes decrypt

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
	
cesar:
	java Algorithme_de_Cesar

vigenere: 
	java Algorithme_de_Vigenere

decrypt:
	javac -cp '.:GestionDesFichiers.jar' Decrypter.java
	java -cp '.:GestionDesFichiers.jar' Decrypter