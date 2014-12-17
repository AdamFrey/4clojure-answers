;; Find Distinct Items - Medium
;; Write a function which removes the duplicates from a sequence. Order of the items must be maintained.
;; tags - seqs:core-functions
;; restricted - distinct
(ns offline-4clojure.p56
  (:use clojure.test))

(def __
  (fn [coll]
    (map first
         (sort-by val < (into {}
                              (reverse (map vector coll (range))))))))

(defn -main []
  (are [soln] soln
(= (__ [1 2 1 3 1 2 4]) [1 2 3 4])
(= (__ [:a :a :b :b :c :c]) [:a :b :c])
(= (__ '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3]))
(= (__ (range 50)) (range 50))
))
