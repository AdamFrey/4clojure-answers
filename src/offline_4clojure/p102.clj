;; intoCamelCase - Medium
;; When working with java, you often need to create an object with <code>fieldsLikeThis</code>, but you'd rather work with a hashmap that has <code>:keys-like-this</code> until it's time to convert. Write a function which takes lower-case hyphen-separated strings and converts them to camel-case strings.
;; tags - strings
;; restricted - 
(ns offline-4clojure.p102
  (:use clojure.test))

(def __
  (fn [s]
    (let [words (clojure.string/split s #"-")]
      (apply str
             (conj (map clojure.string/capitalize (rest words)) (first words))))))

(defn -main []
  (are [soln] soln
(= (__ "something") "something")
(= (__ "multi-word-key") "multiWordKey")
(= (__ "leaveMeAlone") "leaveMeAlone")
))
