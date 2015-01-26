;; Identify keys and values - Medium
;; Given an input sequence of keywords and numbers, create a map such that each key in the map is a keyword, and the value is a sequence of all the numbers (if any) between it and the next keyword in the sequence.
;; tags - maps:seqs
;; restricted - 
(ns offline-4clojure.p105
  (:use clojure.test))

(def __
  (fn [s]
    (let [partition-when
          (fn [f coll]
            (when-let [s (seq coll)]
              (let [fst (first s)
                    run (cons fst (take-while (comp not f) (next s)))]
                (cons run (partition-when f (seq (drop (count run) s)))))))]
      (reduce #(assoc %1 (first %2) (vec (rest %2))) {} (partition-when keyword? s)))))

(defn -main []
  (are [soln] soln
(= {} (__ []))
(= {:a [1]} (__ [:a 1]))
(= {:a [1], :b [2]} (__ [:a 1, :b 2]))
(= {:a [1 2 3], :b [], :c [4]} (__ [:a 1 2 3 :b :c 4]))
))
