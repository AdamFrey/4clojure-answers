;; Word Sorting - Medium
;; Write a function that splits a sentence up into a sorted list of words.  Capitalization should not affect sort order and punctuation should be ignored.
;; tags - sorting
;; restricted - 
(ns offline-4clojure.p70
  (:use clojure.test))

(def __
  (fn [s]
    (let [words (clojure.string/split s (re-pattern " "))
          compare-words (fn [a b] (compare (clojure.string/lower-case a) (clojure.string/lower-case b)))]
      (map #(clojure.string/replace % #"[^\w]" "") (sort compare-words words)))))

(defn -main []
  (are [soln] soln
(= (__  "Have a nice day.")
   ["a" "day" "Have" "nice"])
(= (__  "Clojure is a fun language!")
   ["a" "Clojure" "fun" "is" "language"])
(= (__  "Fools fall for foolish follies.")
   ["fall" "follies" "foolish" "Fools" "for"])
))
