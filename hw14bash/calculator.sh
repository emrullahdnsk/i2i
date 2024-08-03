#!/bin/bash


echo "Input calculation operand (+, -, *, /, %, !):"
read operand


if [ "$operand" = "!" ]; then
    echo "Input number:"
    read num
else
    echo "Input number1:"
    read num1
    echo "Input number2:"
    read num2
fi


case $operand in
    +)
        result=$((num1 + num2))
        echo "Result: $result"
        ;;
    -)
        result=$((num1 - num2))
        echo "Result: $result"
        ;;
    \*)
        result=$((num1 * num2))
        echo "Result: $result"
        ;;
    /)
        if [ "$num2" -ne 0 ]; then
            result=$((num1 / num2))
            echo "Result: $result"
        else
            echo "Error: Division by zero"
        fi
        ;;
    %)
        result=$((num1 % num2))
        echo "Result: $result"
        ;;
    !)
        # Factorial hesaplama
        factorial=1
        for ((i=1; i<=num; i++)); do
            factorial=$((factorial * i))
        done
        echo "Result: $factorial"
        ;;
    *)
        echo "Invalid operand"
        ;;
esac
