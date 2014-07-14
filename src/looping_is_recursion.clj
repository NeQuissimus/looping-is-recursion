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
  (let [firstIndex (fn [sq idx]
    (cond
      (empty? sq) nil
      (pred (first sq)) idx
      :else (recur (rest sq) (inc idx))))]
    (firstIndex a-seq 0)))

(defn avg [a-seq]
  (let [av (fn [sq sum cnt]
    (cond
      (empty? sq) (/ sum cnt)
      :else (recur (rest sq) (+ sum (first sq)) (inc cnt))))]
    (av a-seq 0 0)))

(defn toggle [a-set elem]
  (cond
    (contains? a-set elem) (disj a-set elem)
    :else (conj a-set elem)))

(defn parity [a-seq]
  (let [pari (fn [sq st]
    (cond
      (empty? sq) st
      :else (recur (rest sq) (toggle st (first sq)))))]
    (pari a-seq #{})))

(defn fast-fibo [n]
  (loop [n2 0
         n1 0
         x 0]
    (let [nex (if (< x 2)
      x
      (+ n1 n2))]
    (if (= x n)
      nex
      (recur n1 nex (inc x))))))

(defn cut-at-repetition [a-seq]
  [":("])

