# DFSM-Automata-Simulator
The program should do the following:
read the DFSM from the user specified file
repeat 
ask the user to input a string which can be empty
output “true” if the string is accepted by the machine, “false” otherwise.  
Until the user wants to stop
Format of the DFSM file:
First row is alphabet separated by comma
Second row is the number of states of the DFSM, implicitly the states are 0,1, 2.. where 0 is the initial state
Third row is the accepting states: one or more separated by comma.
The remaining rows are the function, one row for each state
Example1:
0,1
2
1
(0,0,0),(0,1,1)
(1,0,1),(1,1,0)
Example2:
a,b
3
0,1
(0,a,1),(0,b,0)
(1,a,2),(1,b,0)
(2,a,2),(2,b,2)
