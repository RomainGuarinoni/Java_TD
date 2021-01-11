JFLAGS = -g
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Algorithme_de_Cesar.java \
	Algorithme_de_Vigenere.java

default: classes decrypt_vigenere

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
	
cesar:
	java Algorithme_de_Cesar

vigenere: 
	java Algorithme_de_Vigenere

decrypt_cesar:
	javac -cp '.:GestionDesFichiers.jar' Decrypter_cesar.java
	java -cp '.:GestionDesFichiers.jar' Decrypter_cesar

decrypt_vigenere:
	javac -cp '.:GestionDesFichiers.jar' Decrypter_vigenere.java
	java -cp '.:GestionDesFichiers.jar' Decrypter_vigenere