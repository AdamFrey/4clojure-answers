;; Prime Sandwich - Medium
;; A <a href="http://en.wikipedia.org/wiki/Balanced_prime">balanced prime</a> is a prime number which is also the mean of the primes directly before and after it in the sequence of valid primes.  Create a function which takes an integer n, and returns true iff it is a balanced prime.
;; tags - math
;; restricted - 
(ns offline-4clojure.p116
  (:use clojure.test))

(def __
  (fn [num]
    (let [prime? (memoize (fn [x] (and (> x 1)
                                      (not (some #(zero? (mod x %)) (range 2 x))))))
          prime-sandwich (fn [lower n upper]
                           (let [lower-prime? (prime? lower)
                                 upper-prime? (prime? upper)]
                             (if (and lower-prime? upper-prime?)
                               ;; sandwiched between the next two primes?
                               (= (/ (+ lower upper) 2) n)
                               ;; keep looking for the next two primes
                               (if (< lower 1)
                                 false
                                 (recur (if lower-prime? lower (dec lower))
                                        n
                                        (if upper-prime? upper (inc upper)))))))]
      (if (prime? num)
        (prime-sandwich (dec num) num (inc num))
        false))))

(defn -main []
  (are [soln] soln
    (= false (__ 4))
    (= true (__ 563))
    (= 1103 (nth (filter __ (range)) 15))))
