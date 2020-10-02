# Lab 5: Robert, Jacob, David
 
## Resources Used
* [Gale-Shapely Demo](http://www.sephlietz.com/gale-shapley/)
* [Explanation of Gale-Shapely](https://towardsdatascience.com/gale-shapley-algorithm-simply-explained-caa344e643c2)
* [Wikipedia Article of Gale-Shapely](https://en.wikipedia.org/wiki/Gale%E2%80%93Shapley_algorithm)

##Discussion
###Question 1: Algorithm correctness
Our implementation relies on the working of 
the Gale-Shapely solution of the stable marriage
problem. This works by giving everyone
a pairing while also having run throughs which
verify compairson. We also know our solution
works because we have verified it with a 
known-working step-by-step implementation of
GS we found online.
 
###Question 2: Efficiency in the worst case
We know that for the Gale-Shapley algorithm,
the efficiency in the worst case is O(n^2) 
where n is the number of companies and programmers.
I believe our implentation has calculated efficiency of
also O(n^2) since our worst case would be
selecting the pairings (taking n time) and
having to also do n challenges (which also takes n time)
n number of times.
 