JFLAGS = -g
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	FIPS.java \
	Escargot.java

default: classes escargot

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
	
fips:
	java FIPS

escargot:
	java Escargot