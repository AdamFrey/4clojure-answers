;; Beauty is Symmetry - Easy
;; Let us define a binary tree as "symmetric" if the left half of the tree is the mirror image of the right half of the tree.  Write a predicate to determine whether or not a given binary tree is symmetric. (see <a href='/problem/95'>To Tree, or not to Tree</a> for a reminder on the tree representation we're using).
;; tags - trees
;; restricted - 
(ns offline-4clojure.p96
  (:use clojure.test))

(def __
  (fn sym
    ([[v left right]]
     (sym left right))
    ([[v1 left1 right1] [v2 left2 right2]]
     (if (or (nil? v1) (nil? v2))
       (and (nil? v1) (nil? v2))
       (and (= v1 v2) (sym left1 right2) (sym right1 left2))))))

(__ [:a [:b :c :d] nil] [:e [:f :g] nil])
(defn -main []
  (are [soln] soln
       (= (__ '(:a (:b nil nil) (:b nil nil))) true)
       (= (__ '(:a (:b nil nil) nil)) false)
       (= (__ '(:a (:b nil nil) (:c nil nil))) false)
       (= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
               [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])
          true)
       (= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
               [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]])
          false)
       (= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
               [2 [3 nil [4 [6 nil nil] nil]] nil]])
          false)
       ))
