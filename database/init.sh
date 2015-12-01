#!/bin/bash

echo "Start";

begin=1
while [ $begin -lt 8500 ]
do
	 end=$(($begin+100));
	 echo "From "$begin" to "$end;
	 curl --data "begin="$begin"&end="$end http://labouardy.com/parser/init.php
	 echo "";
	 begin=$(($begin+100+1));	
done

echo "Done";
