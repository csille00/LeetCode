package array_string

fun main(){
    println(firstPalindrome(arrayOf("abc","car","ada","racecar","cool")))
}

fun firstPalindrome(words: Array<String>): String {

    fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.length - 1
        while(left < right){
            if(s[left] != s[right]) return false
            left++
            right--
        }
        return true
    }

    for(word in words){
        if(isPalindrome(word)) return word
    }
    return ""

}