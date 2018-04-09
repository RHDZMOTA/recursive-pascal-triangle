#!/usr/bin/env bash
echo "Running scala code"
while IFS='' read -r line || [[ -n "$line" ]]; do
	for i in `seq 1 5`;
	do
		START=$(date +%s.%N)
		scala src/scala/PascalTriangle.scala $line
		END=$(date +%s.%N)
		DIFF=$(echo "$END - $START" | bc)
		echo "scala,naive,$line,$DIFF"
		echo "scala,naive,$line,$DIFF" >> data/results.csv
	done
done < "data/input"

while IFS='' read -r line || [[ -n "$line" ]]; do
	for i in `seq 1 5`;
	do
		START=$(date +%s.%N)
		scala src/scala/FuturesPascalTriangle.scala $line
		END=$(date +%s.%N)
		DIFF=$(echo "$END - $START" | bc)
		echo "scala-futures,naive,$line,$DIFF"
		echo "scala-futures,naive-futures,$line,$DIFF" >> data/results.csv
	done
done < "data/input"

echo "Running python code"
while IFS='' read -r line || [[ -n "$line" ]]; do
	for i in `seq 1 5`
	do
		START=$(date +%s.%N)
		python src/python/pascal_triangle.py $line
		END=$(date +%s.%N)
		DIFF=$(echo "$END - $START" | bc)
		echo "python,naive,$line,$DIFF"
		echo "python,naive,$line,$DIFF" >> data/results.csv
	done
done < "data/input"


