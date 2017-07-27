(ns opacity.us.il.chicago.cps
  (:require [clash.core :as c]
            [clash.tools :as ct]
            [clojure.string :as s]))

(def resources (str (System/getProperty "user.dir") "/resources/"))

(defrecord CpsBudget [school students pop_delta budget budget_delta])

(defn bparser
  "Parse a CPS budget file into memory"
  [line]
  (let [[sc st pd bud bd] (s/split line #",")]
    (->CpsBudget sc (read-string st) pd (read-string bud) bd)))

(defn load-cps-budget
  "Load a CPS budget file that conforms to record CpsBudget."
  [f]
  (c/transform-lines f bparser))

(defn per-student-budget
  "Find the raw average number of money per student for every school."
  [data]
  (map
    #(try
       (/ (float (:budget %)) (:students %))
       (catch Exception e (println "Bad Line: " % "|" (.getMessage e))))
    data))

(defn school-per-student-budget
  "List the school and average money per student."
  [data]
  (reduce
    (fn [result current]
      (assoc result (:school current) (/ (float (:budget current)) (:students current))))
    {}
    data))

(defn sort-school-budget
  "Sort descending school per student budgets"
  [psbudget_data]
  (ct/sort-map-by-value psbudget_data))