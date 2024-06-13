package TwoPointers

fun main(){
    println(longestPalindrome("bbbb"))
}

fun longestPalindrome(s: String): String{
    //I dont want to start at 0, because then I would not be able to see the +1 and -1's of the string.
    //so if I start from 1, and just check if i+1 and i-1 are the same, then you can keep building on that palindrome.
    //I am essentially wanting to find the middle of the palindrome, so that I can go two pointer style outwards on it.
    //so I want to loop, and then just keep checking if +1 and -1 are the same
    //what about the case for a 2 letter palindrome? if i+1 OR i-1 are equal to i, then that is a palindrome
    //there are also even palindromes, such as ABBA. if I find a two letter palindrome, then I need to treat the whole two letters as the middle
        var palindromes = mutableListOf<String>()
        if(s.length == 1) return s[0].toString()
        for(i in 0 until s.length){
            if(i - 1 >= 0 && i+1 < s.length && s[i+1] == s[i-1]){
    //            this is an odd palindrome
                palindromes.add(s.substring(i-1, i+2))
                var counter = 2
                while(i+counter < s.length && i - counter >= 0 &&  s[i+counter] == s[i-counter]){
                    //remove the last palindrome cause we found a bigger one
                    palindromes.removeLast()
                    palindromes.add(s.substring(i-counter, i+counter+1))
                    counter++
                }
            }
            if(i+1 < s.length && s[i+1] == s[i]){
                //this is an even palindrome
                palindromes.add(s.substring(i, i+2))
                //I now need to check i - counter and i + counter + 1
                var counter = 1
                while(i+counter+1 < s.length && i - counter >= 0 && s[i-counter] == s[i+counter+1]){
                    palindromes.removeLast()
                    palindromes.add(s.substring(i-counter, i+counter+2))
                    counter++
                }

            }
        }
        return palindromes.maxByOrNull { it.length } ?: s[0].toString()
}