# Things to work on:

### Data Structures:

I tend to ignore the "optimal" data structure often,
and go straight to some classical algorithmic approach. I need to work on my understanding 
comfortability with different data structures such as LinkedList, PriorityQueue, HashMap etc. 

#### Example:

For
the [kth Largest Element](https://leetcode.com/problems/kth-largest-element-in-a-stream/description/?envType=daily-question&envId=2024-08-12)
problem, I just hopped in and implemented an (incorrect) binary search
solution. It would have been super simple to implement a Min Heap PQ that contains the specified number of elements in
order to see the kth largest at the head. then if adding a new element makes the pq bigger than k, just remove the
smallest element (head)



