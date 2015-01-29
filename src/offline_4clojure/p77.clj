;; Anagram Finder - Medium
;; Write a function which finds all the anagrams in a vector of words.  A word x is an anagram of word y if all the letters in x can be rearranged in a different order to form y.  Your function should return a set of sets, where each sub-set is a group of words which are anagrams of each other.  Each sub-set should have at least two words.  Words without any anagrams should not be included in the result.
;; tags - 
;; restricted - 
(ns offline-4clojure.p77
  (:use clojure.test))

(def __
  (fn [w]
    (let [anagram? (fn [a b]
                     (= (frequencies a) (frequencies b)))]
      (loop [words w
             res #{}]
        (if-let [fst (first words)]
          (let [anagrams (reduce #(if (anagram? fst %2)
                                    (into %1 #{fst %2})
                                    %1)
                                 #{fst}
                                 (rest words))
                rem-words (remove anagrams words)]
            (if (> (count anagrams) 1)
              (recur rem-words (conj res anagrams))
              (recur rem-words res)))
          res)))))

(defn -main []
  (are [soln] soln
(= (__ ["meat" "mat" "team" "mate" "eat"])
   #{#{"meat" "team" "mate"}})
(= (__ ["veer" "lake" "item" "kale" "mite" "ever"])
   #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}})
))
