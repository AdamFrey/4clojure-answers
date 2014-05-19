;; Intro to Iterate - Easy
;; The iterate function can be used to produce an infinite lazy sequence.
;; tags - seqs
;; restricted - 
(ns offline-4clojure.p45
  (:use clojure.test))

(def __
  [1 4 7 10 13])

(defn -main []
  (are [soln] soln
(= __ (take 5 (iterate #(+ 3 %) 1)))
))
