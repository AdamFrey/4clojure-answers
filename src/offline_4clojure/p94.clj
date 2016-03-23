;; Game of Life - Hard
;; The <a href="http://en.wikipedia.org/wiki/Conway's_Game_of_Life">game of life</a> is a cellular automaton devised by mathematician John Conway. <br/><br/>The 'board' consists of both live (#) and dead ( ) cells. Each cell interacts with its eight neighbours (horizontal, vertical, diagonal), and its next state is dependent on the following rules:<br/><br/>1) Any live cell with fewer than two live neighbours dies, as if caused by under-population.<br/>2) Any live cell with two or three live neighbours lives on to the next generation.<br/>3) Any live cell with more than three live neighbours dies, as if by overcrowding.<br/>4) Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.<br/><br/>Write a function that accepts a board, and returns a board representing the next generation of cells.
;; tags - game
;; restricted -
(ns offline-4clojure.p94
  (:use clojure.test))

(def __
  (fn [board]
    (let [old-board (mapv vec board)
          x-size (count (first old-board))
          y-size (count old-board)]
      (->>
        (for [x (range x-size)
              y (range y-size)]
          (let [alive? (= (get-in old-board [x y]) \#)
                neighbor-coords (for [x-offset (range (dec x) (+ x 2))
                                      y-offset (range (dec y) (+ y 2))
                                      :when (not= [x-offset y-offset] [x y])]
                                  [x-offset y-offset])
                alive-neighbors (->> neighbor-coords
                                  (map #(get-in old-board %))
                                  (filter #(= % \#))
                                  (count))]
            (cond
              (< alive-neighbors 2) \space
              (and alive? (< 1 alive-neighbors 4)) \#
              (and alive? (< 3 alive-neighbors)) \space
              (and (not alive?) (= alive-neighbors 3)) \#
              :else \space)))
        (partition x-size)
        (mapv #(apply str %))))))

(defn -main []
  (are [soln] soln
    (= (__ ["      "
            " ##   "
            " ##   "
            "   ## "
            "   ## "
            "      "])
      ["      "
       " ##   "
       " #    "
       "    # "
       "   ## "
       "      "])
    (= (__ ["     "
            "     "
            " ### "
            "     "
            "     "])
      ["     "
       "  #  "
       "  #  "
       "  #  "
       "     "])
    (= (__ ["      "
            "      "
            "  ### "
            " ###  "
            "      "
            "      "])
      ["      "
       "   #  "
       " #  # "
       " #  # "
       "  #   "
       "      "])))
