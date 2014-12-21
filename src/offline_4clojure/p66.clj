;; Greatest Common Divisor - Easy
;; Given two integers, write a function which
;;returns the greatest common divisor.
;; tags - 
;; restricted - 
(ns offline-4clojure.p66
  (:use clojure.test))

(defn __ [a b]
  (let [mn (min a b)
        mx (max a b)
        diff (- mx mn)]
    (if (< 0 mn)
      (__ diff mn)
      mx)))

(defn -main []
  (are [soln] soln
(= (__ 2 4) 2)
(= (__ 10 5) 5)
(= (__ 5 7) 1)
(= (__ 1023 858) 33)
))
