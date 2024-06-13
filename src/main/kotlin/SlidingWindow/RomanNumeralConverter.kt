package org.example.SlidingWindow

fun main() {
    println(intToRoman2(1994))
}
/*
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II.
The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle
 applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.
*/

fun romanToInt(s: String): Int {
    var num = 0
    var i = 0
    while(i < s.length){
        when(s[i]){
            'M' -> num += 1000
            'D' -> num += 500
            'C' -> {
                if(i + 1 < s.length && s[i + 1] == 'D' ){
                    num += 400
                    i++
                } else if(i + 1 < s.length && s[i+1] == 'M'){
                    num += 900
                    i++
                } else {
                    num += 100
                }
            }
            'L' -> num += 50
            'X' -> {
                if(i+1 < s.length && s[i+1] == 'L'){
                    num += 40
                    i++
                } else if (i+1 < s.length && s[i+1] == 'C'){
                    num += 90
                    i++
                } else {
                    num += 10
                }
            }
            'V' -> num += 5
            'I' -> {
                if(i+1 < s.length && s[i+1] == 'V'){
                    num += 4
                    i++
                } else if(i+1 < s.length && s[i+1] == 'X'){
                    num += 9
                    i++
                } else {
                    num += 1
                }
            }
        }
        i++
    }
    return num
}

/*
Seven different symbols represent Roman numerals with the following values:

Symbol	Value
I	1
V	5
X	10
L	50
C	100
D	500
M	1000

Roman numerals are formed by appending the conversions of decimal place values from highest to lowest. Converting a
decimal place value into a Roman numeral has the following rules:

If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted from the input,
append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.

If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted from the following symbol,
for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX. Only the following subtractive forms
are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).

Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10. You cannot
append 5 (V), 50 (L), or 500 (D) multiple times. If you need to append a symbol 4 times use the subtractive form.
Given an integer, convert it to a Roman numeral.

*/

fun intToRoman(num: Int): String {
    var roman = ""
    var numCpy = num
    while(numCpy > 0){
        if(numCpy.toString()[0] == '4' || numCpy.toString()[0] == '9'){
            //subtractive form
            println("subtractive form")
            if(numCpy - 900 >= 0){
                roman += 'C'
                roman += 'M'
                numCpy -= 900
            } else if (numCpy - 400 >= 0){
                roman += 'C'
                roman += 'D'
                numCpy -= 400
            } else if(numCpy - 90 >= 0){
                roman += 'X'
                roman += 'C'
                numCpy -= 90
            } else if(numCpy - 40 >= 0){
                roman += 'X'
                roman += 'L'
                numCpy -= 40
            } else if (numCpy - 9 >= 0){
                roman += 'I'
                roman += 'X'
                numCpy -= 9
            } else if (numCpy - 4 >= 0){
                roman += 'I'
                roman += 'V'
                numCpy -= 4
            }
        } else {
            if(numCpy - 1000 >= 0){
                roman += 'M'
                numCpy -= 1000
            } else if(numCpy - 500 >= 0){
                roman += 'D'
                numCpy -= 500
            } else if(numCpy - 100 >= 0){
                roman += 'C'
                numCpy -= 100
            } else if(numCpy - 50 >= 0){
                roman += 'L'
                numCpy -= 50
            } else if(numCpy -10 >= 0){
                roman += 'X'
                numCpy -= 10
            } else if (numCpy - 5 >= 0){
                roman += 'V'
                numCpy -= 5
            } else if (numCpy - 1 >= 0) {
                roman += 'I'
                numCpy -= 1
            }
        }
    }
    return roman
}

fun intToRoman2(num: Int): String{
    val values = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
    val romans = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")

    var remaining = num
    var result = ""

    for( i in values.indices){
        while(remaining >= values[i]){
            result += romans[i]
            remaining -= values[i]
        }
    }
    return result
}