(ns looping-is-recursion)

(defn power [base exp]
  (let [pow (fn [exp res]
              (if (zero? exp)
                res
                (recur (- exp 1) (* res base))))]
    (pow exp 1)))

(defn last-element [a-seq]
  (let [lastOne (fn [sq prev]
                  (if (empty? sq)
                    prev
                    (recur (rest sq) (first sq))))]
  (lastOne a-seq nil)))

(defn seq= [seq1 seq2]
  (let [compar (fn [sq1 sq2]
                  (cond
                    (and (empty? sq1) (empty? sq2)) true
                    (or (empty? sq1) (empty? sq2)) false
                    (not (= (first sq1) (first sq2))) false
                    :else (recur (rest sq1) (rest sq2))))]
    (compar seq1 seq2)))

(defn find-first-index [pred a-seq]
  ":(")

(defn avg [a-seq]
  -1)

(defn parity [a-seq]
  ":(")

(defn fast-fibo [n]
  ":(")

(defn cut-at-repetition [a-seq]
  [":("])

