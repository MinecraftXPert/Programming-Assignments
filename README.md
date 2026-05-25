# Programming Assignment Tasks

Below are the programming assignment tasks we were given to give context for each PA we had to complete.

## PA 1 - Being Clever 

### Problem: Help Gustavo to choose the games!

Gustavo got an arcade game card with T points in it. The arcade has n unique games where each game requires a unique number of points to play. Gustavo is allowed to play only two games and he wants to spend the full T points to play two games so that no points will remain in the card. So, he needs to decide whether is it possible or not to play two games that will cost exactly T points. Given an array of n distinct none zero values representing the points needed to play the games. Also, given the target points T available on the card. Determine in O(n) time whether or not there exist two distinct points in the array that sum to T. The given array maybe sorted or may not be already sorted. It will be specified in the input whether it is sorted or not and you have to fulfill specific requirement based on the sorted status. (For example, if the array contained 3, 5, 6, 7, and 9 and T = 14, then the method you are to write should return points pair (5,9), since 5+9 = 14. It should return points pair (0,0) for the same array of points if T = 17.)

***<u><p style="font-size: 15px;">Input Format (Your code must read from standard input (no file i/o is allowed))</p></u>***

The first line of the input will have a single positive integer k, representing the number of test cases in the inputs. The next 2*k lines will contain the test cases, with two lines being used for each test case. The first value on the first line of each test case will be the sorted status (0 means unsorted, 1 means sorted). The next number in the line is n, the size of the array (the number of games in the Knights arcade). The rest of the line will contain n distinct none zero integers representing the points needed to play, each separated by spaces. The second line of each test case will contain a single integer, T, the target for the problem (The number of points in the game card). Here's an example input contents: `

```
4 
1 5 3 5 6 7 9 
14 
0 3 1 6 3 
11 
0 6 4 1 -8 6 45 10 
16 
1 6 -8 1 4 6 10 45 
16 
```
 
***<u>Output Format</u>***

For each test case, output a line with one of the following two formats: 
`Test case m: Spend X points by playing the games with n1 points and n2 points. `
`Test case m: No way you can spend exactly X points. `
**where m (1 ≤ m ≤ k), represents the appropriate test case. In the output n1 also must be less than n2**
Example output for the above inputs: 
`Test case#1: Spend 14 points by playing the games with 5 points and 9 points. `
`Test case#2: No way you can spend exactly 11 points. `
`Test case#3: Spend 16 points by playing the games with 6 points and 10 points. `
`Test case#4: Spend 16 points by playing the games with 6 points and 10 points. `
 
 
***<u><p style="font-size: 15px;">Specific Restrictions:</u>***
Your code must incorporate the following restrictions to receive full credit: 
1.	If you see that a particular test case is sorted (sorted status = 1), your code must process it with O(n) operation to receive more than 50% credit on this part. For this part of the implementation, you are not allowed to use Hashset. 
2.	For finding the pair in the sorted array, you must implement the following function: 
a. _________ getCandidatePair(int A[], int target): This function receives an int array and the target and returns the pair of ints from the array that can addup to target. For this purpose, you may consider having another class and return an object of that class. If a pair does not exist, the function should return the pair as (0, 0). Note that you are not allowed to print any information in this function as part of the output. 
3.	If you see that a particular test case is not sorted (sorted status = 0), your code must process it with O(n) operation to receive more than 75% credit on this part. If your code works with O(n log n), you can get up to 75% on this part. Note that Arrays.sort() method sometimes can result in O(n^2). The Collections.sort() method could be a good idea to guarantee O(n log n) sorting. If you would like to get 100% credit for this part and get O(n) run-time, then Hashset would be the best option (Note that HashSet insert and lookup O(1)). If you are unable to find a solution within even O(n log n), then at least solve it with O(n^2) to receive some partial credit. 
