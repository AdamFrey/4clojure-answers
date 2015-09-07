;; Levenshtein Distance - Hard
;; Given two sequences x and y, calculate the <a href="https://secure.wikimedia.org/wikipedia/en/wiki/Levenshtein_distance">Levenshtein distance</a> of x and y, i. e. the minimum number of edits needed to transform x into y.  The allowed edits are:<br/><br/>- insert a single item<br/>- delete a single item<br/>- replace a single item with another item<br/><br/>WARNING: Some of the test cases may timeout if you write an inefficient solution!
;; tags - seqs
;; restricted - 
(ns offline-4clojure.p101
  (:use clojure.test))

(def __
  (fn [s1 s2]
    (let [length1 (count s1)
          length2 (count s2)
          coords (for [x (range length1)
                       y (range length2)] [x y])
          distances (reduce
                     (fn [acc [x y]]
                       (let [chars-equal? (= (nth s1 x) (nth s2 y))
                             cost (if chars-equal? 0 1)
                             sub-lev (min
                                      (inc (get acc [x (dec y)] x))
                                      (inc (get acc [(dec x) y] y))
                                      (+ cost (get acc [(dec x) (dec y)] (max x y))))]
                         (assoc acc [x y] sub-lev)))
                     {} coords)]
      (get distances [(dec length1) (dec length2)] (max length1 length2)))))

(defn -main []
  (are [soln] soln
(= (__ "kitten" "sitting") 3)
(= (__ "closure" "clojure") (__ "clojure" "closure") 1)
(= (__ "xyx" "xyyyx") 2)
(= (__ "" "123456") 6)
(= (__ "Clojure" "Clojure") (__ "" "") (__ [] []) 0)
(= (__ [1 2 3 4] [0 2 3 4 5]) 2)
(= (__ '(:a :b :c :d) '(:a :d)) 2)
(= (__ "ttttattttctg" "tcaaccctaccat") 10)
(= (__ "gaattctaatctc" "caaacaaaaaattt") 9)
))
