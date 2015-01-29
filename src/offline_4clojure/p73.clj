;; Analyze a Tic-Tac-Toe Board - Hard
;; A <a href="http://en.wikipedia.org/wiki/Tic-tac-toe">tic-tac-toe</a> board is represented by a two dimensional vector. X is represented by :x, O is represented by :o, and empty is represented by :e.  A player wins by placing three Xs or three Os in a horizontal, vertical, or diagonal row.  Write a function which analyzes a tic-tac-toe board and returns :x if X has won, :o if O has won, and nil if neither player has won.
;; tags - game
;; restricted - 
(ns offline-4clojure.p73
  (:use clojure.test))

(def __
  (fn [board]
    (let [vs board
          hs (map (fn [n]
                    (map #(% n) board)) [0 1 2])
          d1 (map #(get-in board [% %]) [0 1 2])
          d2 (map #(get-in board [%1 %2]) [0 1 2] [2 1 0])
          rows (concat vs hs [d1 d2])]
      (first (filter #(or (every? (partial = :x) %)
                          (every? (partial = :o) %)) rows)))))

(defn -main []
  (are [soln] soln
(= nil (__ [[:e :e :e]
            [:e :e :e]
            [:e :e :e]]))
(= :x (__ [[:x :e :o]
           [:x :e :e]
           [:x :e :o]]))
(= :o (__ [[:e :x :e]
           [:o :o :o]
           [:x :e :x]]))
(= nil (__ [[:x :e :o]
            [:x :x :e]
            [:o :x :o]]))
(= :x (__ [[:x :e :e]
           [:o :x :e]
           [:o :e :x]]))
(= :o (__ [[:x :e :o]
           [:x :o :e]
           [:o :e :x]]))
(= nil (__ [[:x :o :x]
            [:x :o :x]
            [:o :x :o]]))
))
