console-canvas
==============

This is repository of console-canvas problem

The problem statement is as follows:
You're given the task of writing a simple console version of a drawing program. At this time, the functionality of the program is quite limited but this might change in the future. In a nutshell, the program should work as follows:

1.	create a new canvas
2.	start drawing on the canvas by issuing various commands
3.	quit

At the moment, the program should support the following commands:

**C w h**:          Should create a new canvas of width w and height h.

**L x1 y1 x2 y2**:  Should create a new line from (x1,y1) to (x2,y2). Currently only horizontal or vertical lines are supported. Horizontal and vertical lines will be drawn using the 'x' character.

**R x1 y1 x2 y2**:  Should create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2). Horizontal and vertical lines will be drawn using the 'x' character.

**B x y c**:        Should fill the entire area connected to (x,y) with "colour" c. The behaviour of this is the same as that of the "bucket fill" tool in paint programs.

**Q**:              Should quit the program.

Please Note: as you can see in the sample I/O the program is console based. You have to make shapes (lines,rectangle, canvas etc.) using text characters (x,-,o etc.) as shown. You should NOT use any in built Graphic Library like Java.awt.Graphics2D etc. and any pre defined methods for drawing these shapes.

Below is a sample run of the program. User input is prefixed with ’enter command:’.
```
enter command: C 20 4
----------------------
|                    |
|                    |
|                    |
|                    |
----------------------
```
```
enter command: L 1 2 6 2
----------------------
|                    |
|xxxxxx              |
|                    |
|                    |
----------------------
```
```
enter command: L 6 3 6 4
----------------------
|                    |
|xxxxxx              |
|     x              |
|     x              |
----------------------
```
```
enter command: R 16 1 20 3
----------------------
|               xxxxx|
|xxxxxx         x   x|
|     x         xxxxx|
|     x              |
----------------------
```
```
enter command: B 10 3 o
----------------------
|oooooooooooooooxxxxx|
|xxxxxxooooooooox   x|
|     xoooooooooxxxxx|
|     xoooooooooooooo|
----------------------
```
```
enter command: Q
```
