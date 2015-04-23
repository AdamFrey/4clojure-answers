;; Least Common Multiple - Easy
;; Write a function which calculates the <a href="http://en.wikipedia.org/wiki/Least_common_multiple">least common multiple</a>.  Your function should accept a variable number of positive integers or ratios. 
;; tags - math
;; restricted - 
(ns offline-4clojure.p100
  (:use clojure.test))

(def __
  (fn lcd [& nums]
    (let [gcd (fn [x y]
                (let [[little big] (sort [x y])
                      diff (- big little)]
                  (if (< 0 little)
                    (recur diff little)
                    big)))
          lcd-of-two (fn [x y] (/ (* x y) (gcd x y)))]
      (reduce lcd-of-two nums))))

(defn -main []
  (are [soln] soln
(== (__ 2 3) 6)
(== (__ 5 3 7) 105)
(== (__ 1/3 2/5) 2)
(== (__ 3/4 1/6) 3/2)
(== (__ 7 5/7 2 3/5) 210)
))
