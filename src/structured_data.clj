(ns structured-data)

(defn do-a-thing [x]
    (let [doublex (+ x x)]
        (Math/pow doublex doublex)
    )
)

(defn spiff [v]
    (+ (get v 0) (get v 2))
)

(defn cutify [v]
    (conj v "<3")
)

(defn spiff-destructuring [v]
    (+ (first v) (nth v 2))
)

(defn point [x y]
  [x y])

(defn rectangle [bottom-left top-right]
  [bottom-left top-right])

(defn width [rectangle]
  (let [[[x1 y1] [x2 y2]] rectangle]
    (- x2 x1 )))

(defn height [rectangle]
  (let [[[x1 y1] [x2 y2]] rectangle]
    (- y2 y1 )))

(defn square? [rectangle]
  (let [[[x1 y1] [x2 y2]] rectangle]
    (= (- x2 x1) (- y2 y1) )))


(defn area [rectangle]
  (let [[[x1 y1] [x2 y2]] rectangle]
    (* (- x2 x1) (- y2 y1) )))

(defn contains-point? [rectangle point]
  (let [[[x1 y1] [x2 y2]] rectangle]
    (let [[x y] point]
      (and (<= x1 x x2) (<= y1 y y2) ))))

(defn contains-rectangle? [outer inner]
  (let [[[ox1 oy1] [ox2 oy2]] outer]
    (let [[[ix1 iy1] [ix2 iy2]] inner]
      (and (<= oy1 iy1 iy2 oy2) (<= oy1 iy1 iy2 oy2) ))))

(defn title-length [book]
  (count (:title book)))

(defn author-count [book]
  (count (:authors book)))

(defn multiple-authors? [book]
  (< 1 (count (:authors book))))

(defn add-author [book new-author]
  (let [{authors :authors} book]
    (assoc book :authors (conj authors new-author))))

(defn alive? [author]
  (not (contains? author :death-year)))

(defn element-lengths [collection]
  (map count collection))


(defn second-elements [collection]
  (let [get-sec (fn [v] (get v 1))]
    (map get-sec collection)))

(defn titles [books]
  (let [get-title (fn [book] (:title book))]
      (map get-title books)))

(defn monotonic? [a-seq]
  (or (apply <= a-seq)
      (apply >= a-seq)))

(defn stars [n]
  (apply str (repeat n "*")))


(defn toggle [a-set elem]
  (if
    (contains? a-set elem)
    (disj a-set elem)
    (conj a-set elem)
  ))


(defn contains-duplicates? [a-seq]
  (not= (count a-seq)
      (count (set a-seq))))

(defn old-book->new-book [book]
  (assoc book :authors (set (:authors book))))

(defn has-author? [book author]
  (contains? (:authors book) author))

(defn authors [books]
  (let [get-author (fn [book]
       (:authors book))]
  (clojure.set/union (set (apply concat (map get-author books))))))

(defn all-author-names [books]
  (set (map :name (authors books))))

(defn author->string [author]
  (let [birth-year (fn [author]
    (if (:birth-year author)
      (str " (" (:birth-year author) " - " (:death-year author) ")")
      ""))]
  (str (:name author) (birth-year author))))

(defn authors->string [authors]
  (apply str (interpose ", " (map author->string authors))))

(defn book->string [book]
  (apply str
       (:title book)
       ", written by "
       (authors->string (:authors book))))

(defn books->string [books]
  (if (< 0 (count books))
    (str
      (count books)
      " book"
      (if (< 1 (count books)) "s. " ". ")
      (apply str (interpose ". " (map book->string books)))
      ".")
    "No books."))

(defn books-by-author [author books]
  (let [pred (fn [book]
    (has-author? book author))]
    (filter pred books)))

(defn author-by-name [name authors]
  :-)

(defn living-authors [authors]
  :-)

(defn has-a-living-author? [book]
  :-)

(defn books-by-living-authors [books]
  :-)

; %________%
