package DP

//There is only one character 'A' on the screen of a notepad. You can perform one of two operations on this notepad for each step:
//
//Copy All: You can copy all the characters present on the screen (a partial copy is not allowed).
//Paste: You can paste the characters which are copied last time.
//Given an integer n, return the minimum number of operations to get the character 'A' exactly n times on the screen.
//How many characters may be there in the clipboard at the last step if n = 3? n = 7? n = 10? n = 24?

// 3
//A, AA, AAA
// 1

//4
// A, AA, AAAA,

//5
// A, AA, AAA, AAAA, AAAAA

//6
// A, AA, AAA, AAAAAA

//find largest prime factor of n, if that is n, then return the number itself, else,
//minsteps of n = minsteps(p) + minsteps(n/p)

//24
//12, 2, 8, 3, 6, 4, 24, 1

//3 + (8 -> 2 + (4 -> 2 + 2)) = 9


fun main(){
    println(minSteps(24))
}

    fun minSteps(n: Int): Int {
        // minimum problem, so initialize to max
        val dp = Array(n+1) {Int.MAX_VALUE}
        dp[0] = 0
        dp[1] = 0

        fun largestPrimeFactor(num: Int): Int{
            if(num == 1) return 1
            var number = num
            //the smallest prime is 2, so start here
            var start = 2
            val primeFactors = mutableListOf(1)
            //iterate until the number is 1
            while(number > 1){
                if(number % start == 0){
                    //if your current number is divisible by the prime youre on, then divide that prime out of the number and add to the list
                    primeFactors.add(start)
                    number /= start
                } else {
                    //else, iterate your prime
                    start++
                }
            }
            //return the biggest prime factor
            return primeFactors.max()
        }

        for(i in 2 until dp.size){
            //find the largest prime of the number youre on.
            //since a prime number is only divisible by itself and one, it will take n operations to do (one to copy, and then just paste single 'A's
            //so you want to find the largest prime, and then figure out how many operations it is to do i/largestPrime.
            //since i = k*p where p is the largest prime and k is i/p
            val largestPrime = largestPrimeFactor(i)
            if(i == largestPrime) dp[i] = i
            else{
                dp[i] = dp[largestPrime] + dp[i/largestPrime]
            }
        }
        return dp[n]
    }

