#!/bin/bash

javac util/*.java && javac backend/donnees/*.java && javac backend/minijeu/*.java && javac general/*.java && javac frontend/*.java && javac Main.java && java Main

rm Main.class;
rm */*.class;
rm */*/*.class;