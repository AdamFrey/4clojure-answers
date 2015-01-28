;; Intro to Destructuring 2 - Easy
;; Sequential destructuring allows you to bind symbols to parts of sequential things (vectors, lists, seqs, etc.): <a href="http://clojure.org/special_forms#Special Forms--(let [bindings* ] exprs*)">(let [bindings* ] exprs*)</a>
;;
;;Complete the bindings so all let-parts evaluate to 3.
;; tags - Destructuring
;; restricted - 
(ns offline-4clojure.p173
  (:use clojure.test))

(defn -main []
  (are [soln] soln
(= 3
   (let [[f x] [+ (range 3)]] (apply f x))
   (let [[[f x] b] [[+ 1] 2]] (f x b))
   (let [[f x] [inc 2]] (f x)))
))
