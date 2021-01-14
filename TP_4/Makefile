JFLAGS = -g
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = FIPS.java

default: classes run

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
	
run:
	java FIPS