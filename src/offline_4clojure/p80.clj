;; Perfect Numbers - Medium
;; A number is "perfect" if the sum of its divisors equal the number itself.  6 is a perfect number because 1+2+3=6.  Write a function which returns true for perfect numbers and false otherwise.
;; tags - 
;; restricted - 
(ns offline-4clojure.p80
  (:use clojure.test))

(def __
  (fn [n]
    (let [sqrt (Math/sqrt n)
          ints (take-while #(<= % sqrt) (iterate inc 2))
          lower-divs (filter #(= 0 (rem n %)) ints)
          divs (concat [1] lower-divs (map #(/ n %) lower-divs))]
      (= n (reduce + divs)))))

(defn -main []
  (are [soln] soln
(= (__ 6) true)
(= (__ 7) false)
(= (__ 496) true)
(= (__ 500) false)
(= (__ 8128) true)
))
