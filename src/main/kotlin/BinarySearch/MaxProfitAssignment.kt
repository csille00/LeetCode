package BinarySearch

//You have n jobs and m workers. You are given three arrays: difficulty, profit, and worker where:
//
//difficulty[i] and profit[i] are the difficulty and the profit of the ith job, and
//worker[j] is the ability of jth worker (i.e., the jth worker can only complete a job with difficulty at most worker[j]).
//Every worker can be assigned at most one job, but one job can be completed multiple times.
//
//For example, if three workers attempt the same job that pays $1, then the total profit will be $3. If a worker cannot complete any job, their profit is $0.
//Return the maximum profit we can achieve after assigning the workers to the jobs.
//
//
//
//Example 1:
//
//Input: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
//Output: 100
//Explanation: Workers are assigned jobs of difficulty [4,4,6,6] and they get a profit of [20,20,30,30] separately.

fun main(){
    println(maxProfitAssignment(intArrayOf(68,35,52,47,86), intArrayOf(67,17,1,81,3), intArrayOf(92,10,85,84,82)))
}

fun maxProfitAssignment(difficulty: IntArray, profit: IntArray, worker: IntArray): Int {
    var p = 0

    //I am going to want to run a binary search loop for each individual worker to find the maximum profit that he can do based on his difficulty
    //I want to sort the difficulty array, but I have to sort the profit array as well. I think it would be best if I made a map with keys difficulty and profit values?
    val jobs = difficulty.zip(profit).sortedBy { it.first }.toMutableList()

    //the trickiest part of this problem was this part. you want to go through and update each of the profits to the max
    // profit that that difficulty can perform. This is to account for the fact that a lower difficulty job could have
    // higher profit than a higher difficulty job.
    // After you do this, you can do the binary search for each of the individual workers to find the highest difficulty
    // he/she can perform.
    for (i in 1 until jobs.size) {
        jobs[i] = jobs[i].first to maxOf(jobs[i].second, jobs[i - 1].second)
    }

    fun binarySearch(jobs: List<Pair<Int, Int>>, individualWorker: Int): Int{
        var left = 0
        var right = jobs.size
        while(left < right){
            val mid = left + (right - left) / 2
            if(jobs[mid].first > individualWorker){
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left - 1
    }

    for(individualWorker in worker){
        val maxDifficulty = binarySearch(jobs, individualWorker)
        if(maxDifficulty == -1) continue
        p += jobs[maxDifficulty].second
    }

    return p
}
