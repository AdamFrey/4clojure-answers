;; Sequence Reductions - Medium
;; Write a function which behaves like reduce, but returns each intermediate value of the reduction.  Your function must accept either two or three arguments, and the return sequence must be lazy.
;; tags - seqs:core-functions
;; restricted - reductions
(ns offline-4clojure.p60
  (:use clojure.test))

(defn __
  ([f coll]
   (lazy-seq
    (__ f (first coll) (rest coll))))
  ([f start coll]
   (cons start
         (lazy-seq
          (if-let [s (seq coll)]
            (__ f (f start (first s)) (rest s))))))
  )

(defn -main []
  (are [soln] soln
(= (take 5 (__ + (range))) [0 1 3 6 10])
(= (__ conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]])
(= (last (__ * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120)
))
