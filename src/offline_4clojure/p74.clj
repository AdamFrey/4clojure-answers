;; Filter Perfect Squares - Medium
;; Given a string of comma separated integers, write a function which returns a new comma separated string that only contains the numbers which are perfect squares.
;; tags - 
;; restricted - 
(ns offline-4clojure.p74
  (:use clojure.test))

(def __
  (fn [s]
    (let [nums (clojure.string/split s #",")
          is-sqr (fn [n]
                   (let [sqrt (Math/sqrt n)]
                     (= sqrt (Math/ceil sqrt))))]
      (clojure.string/join "," (filter (comp is-sqr read-string) nums)))))

(defn -main []
  (are [soln] soln
(= (__ "4,5,6,7,8,9") "4,9")
(= (__ "15,16,25,36,37") "16,25,36")
))
