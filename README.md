# ManyKeyboard

## © 2013 Nan Li

ManyKeyboard is a BSD licensed Java library based on javahidlib to allow multiple keyboards to be captured on
a single computer.

### Run test

java -cp lib/hidapi-1.1.jar:target/classes/ org.nanli.util.manykeyboard.TestManyKeyboard

### Background

Native JDK supports only one mouse and one keyboard. The Manymouse project (https://icculus.org/manymouse/)
was created to allow multiple mice working in a single application. This manymouse library is originally in C,
but has Java port.

Mutiple keyboards on a single computer has not attracted many people, but it is useful in a collaborative
setting. Many people have created libraries or found ways to enable multiple keyboards to work within a .Net
application. This project provides a way to make it work on every major OS platform (Windows, Linux and OSX).

I am able to create This small library to support multiple keyboards was created with the help of javahidlib.

### About Author

Nan Li (nan.li@epfl.ch)
