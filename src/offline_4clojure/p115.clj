;; The Balance of N - Medium
;; A balanced number is one whose component digits have the same sum on the left and right halves of the number.  Write a function which accepts an integer n, and returns true iff n is balanced.
;; tags - math
;; restricted - 
(ns offline-4clojure.p115
  (:use clojure.test))

(def __
  (fn [n]
    (let [st (str n)
          len (quot (count st) 2)
          sum-of-str (fn [n-str] (reduce + (map #(- (int %) 48) n-str)))]
      (= (sum-of-str (take len st)) (sum-of-str (take-last len st))))))

(defn -main []
  (are [soln] soln
(= true (__ 11))
(= true (__ 121))
(= false (__ 123))
(= true (__ 0))
(= false (__ 88099))
(= true (__ 89098))
(= true (__ 89089))
(= (take 20 (filter __ (range)))
   [0 1 2 3 4 5 6 7 8 9 11 22 33 44 55 66 77 88 99 101])
))
