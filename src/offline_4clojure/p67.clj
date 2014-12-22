;; Prime Numbers - Medium
;; Write a function which returns the first x
;;number of prime numbers.
;; tags - primes
;; restricted - 
(ns offline-4clojure.p67
  (:use clojure.test))

(defn __ [n]
  (let [logn (Math/log n)
        limit (Math/ceil (+ (* n logn) n))]
    (loop [vals (vec (repeat limit true))
           base 2]
      (let [non-primes (range (* base 2) limit base)
            next-prime-jump (.indexOf (drop base vals) true)
            next-prime (+ base 1 next-prime-jump)]
        (if (< -1 next-prime-jump)
          (recur (reduce #(assoc %1 (- %2 1) false) vals non-primes) next-prime)
          (take n (drop 1 (map (comp inc first) (filter (comp true? last) (map-indexed vector vals))))))))))

(defn -main []
  (are [soln] soln
(= (__ 2) [2 3])
(= (__ 5) [2 3 5 7 11])
(= (last (__ 100)) 541)
))
